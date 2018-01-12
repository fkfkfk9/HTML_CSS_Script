package com.fkfkfk9.dao;

import java.util.List;

import com.fkfkfk9.domain.Paging;
import com.fkfkfk9.domain.ReplyVO;

public interface ReplyDAO {
	//게시판 글의 번호를 주고 댓글 리스트를 받아온다.
	public List<ReplyVO> getlistReply(Integer num, Paging paging)throws Exception;
	//게시판 글의 댓글수를 가져온다.
	public int totalCnt(int num) throws Exception;
	//입력한 댓글 정보를 저장한다.
	public void create(ReplyVO vo)throws Exception;
	//기존의 댓글을 수정한다.
	public void update(int rno, String replytext)throws Exception;
	//기존의 댓글을 삭제한다.
	public void delete(int rno)throws Exception;
}
