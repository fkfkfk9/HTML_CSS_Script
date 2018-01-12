package com.fkfkfk9.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fkfkfk9.dao.ReplyDAO;
import com.fkfkfk9.domain.PageBtn;
import com.fkfkfk9.domain.Paging;
import com.fkfkfk9.domain.ReplyVO;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Inject
	  private ReplyDAO dao;
	
	@RequestMapping(value = "/{num}/{pageNum}", method = RequestMethod.GET)
	  public ResponseEntity<Map<String, Object>> listPage(
	      @PathVariable("num") Integer num,
	      @PathVariable("pageNum") Integer pageNum) {
		logger.info("num : " + num + " pageNum : " + pageNum);
		
	    ResponseEntity<Map<String, Object>> entity = null;
	    
	    try {
	      Paging paging = new Paging();
	      paging.setPageNum(pageNum);

	      PageBtn pb = new PageBtn();
	      pb.setPaging(paging);

	      Map<String, Object> map = new HashMap<String, Object>();
	      List<ReplyVO> list = dao.getlistReply(num, paging);
	      
	      map.put("replyVO", list);

	      int replyCount = dao.totalCnt(num);
	      pb.setTotalcol(replyCount);

	      map.put("pageBtn", pb);

	      entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	  }
	
	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	  public ResponseEntity<String> remove(@PathVariable("rno") Integer rno) {
		logger.info("rno : " + rno);
	    ResponseEntity<String> entity = null;
	    try {
	      dao.delete(rno);
	      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	  }
	
	@RequestMapping(value = "/{rno}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	  public ResponseEntity<String> update(@PathVariable("rno") Integer rno, @RequestBody ReplyVO vo) {
		logger.info("update 진입 넘어온 데이터 rno : " + rno + " 댓글 : " + vo.getReplytext());
	    ResponseEntity<String> entity = null;
	    try {
	      vo.setRno(rno);
	      dao.update(vo.getRno(), vo.getReplytext());
	      
	      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	  }
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	  public ResponseEntity<String> register(@RequestBody ReplyVO vo) {
		logger.info(vo.toString());
	    ResponseEntity<String> entity = null;
	    try { 
	      dao.create(vo);
	      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	  }

}
