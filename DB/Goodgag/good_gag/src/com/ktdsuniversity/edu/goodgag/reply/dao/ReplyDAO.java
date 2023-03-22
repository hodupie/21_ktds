package com.ktdsuniversity.edu.goodgag.reply.dao;

import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;

public interface ReplyDAO {
	
	/**
	 * 댓글의 새로운 PK값을 조회한다.
	 * @return 댓글의 PK값 (RP-날짜-시퀀스)
	 */
	public String createNewReplyNo();
	
	/**
	 * 댓글 등록
	 * @param replyVO (댓글 정보)
	 * @return Insert한 개수
	 */
	public int createReply(ReplyVO replyVO);
}
