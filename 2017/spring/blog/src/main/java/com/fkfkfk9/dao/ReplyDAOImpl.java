package com.fkfkfk9.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.fkfkfk9.domain.Paging;
import com.fkfkfk9.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.fkfkfk9.mapper.ReplyMapper";
	
	@Override
	public List<ReplyVO> getlistReply(Integer num, Paging paging) throws Exception {
		System.out.println(num);
		System.out.println(paging.toString());
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("num", num);
		paramMap.put("paging", paging);
		return session.selectList(namespace + ".getlistReply", paramMap);
	}

	@Override
	public int totalCnt(int num) throws Exception {		
		return session.selectOne(namespace + ".totalCnt", num);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(int rno, String replytext) throws Exception {
		System.out.println("rno : " + rno + ", replytext: " + replytext);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rno", new Integer(rno));
		paramMap.put("replytext", replytext);
		session.insert(namespace + ".update", paramMap);
	}

	@Override
	public void delete(int rno) throws Exception {
		System.out.println(rno);
		session.insert(namespace + ".delete", rno);
	}

}
