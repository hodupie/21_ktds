package com.ktdsuniversity.edu.goodgag;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.article.dao.ArticleDAO;
import com.ktdsuniversity.edu.goodgag.article.dao.ArticleDAOImpl;
import com.ktdsuniversity.edu.goodgag.article.service.ArticleService;
import com.ktdsuniversity.edu.goodgag.article.service.ArticleServiceImpl;
import com.ktdsuniversity.edu.goodgag.article.vo.ArticleVO;
import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAO;
import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAOImpl;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;
import com.ktdsuniversity.edu.goodgag.reply.service.ReplyService;
import com.ktdsuniversity.edu.goodgag.reply.service.ReplyServiceImpl;
import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;

public class GoodGagMain {
	
	public static void main(String[] args) {
//		회원 가입
		MemberDAO memberDAO = new MemberDAOImpl();
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail("jay@gmail.com");
		memberVO.setNickname("째이");
		memberVO.setPassword("1sdfl12");
//		memberDAO.createMember(memberVO);
		
//		게시글 작성
		ArticleVO articleVO = new ArticleVO();
		ArticleService articleService = new ArticleServiceImpl();
//		email FK는 member에서 가져오기
		articleVO.setEmail(memberVO.getEmail());
		articleVO.setTitle("졸려");
		articleVO.setDescript("눈이 감겨요");
		articleVO.setSource("점심 순대비빔");
		articleVO.setNotiYn("N");
//		boolean isSuccess = articleService.createArticle(articleVO);
//		System.out.println(isSuccess);
//		System.out.println(articleVO.getArticleNo());
		
//		게시글 목록 조회 (댓글 개수 포함)
		List<ArticleVO> articleList = articleService.getAllArticles();
		for (ArticleVO eachArticle : articleList) {
			System.out.println("=======================================");
			System.out.println(eachArticle.getTitle());
			System.out.println(eachArticle.getArticleNo());
			System.out.println(eachArticle.getMemberVO().getNickname());
			System.out.println(eachArticle.getReplyList().size());
		}
		
//		게시글 상세 조회 (댓글 포함)
		
//		게시글 수정
		
//		댓글 작성
		ReplyVO replyVO = new ReplyVO();
		ReplyService replyService = new ReplyServiceImpl();
		
		replyVO.setArticleNo("AR-20230228-00037");
		replyVO.setEmail(memberVO.getEmail());
		replyVO.setReply("멋진 레시피 감사합니다.");
		replyVO.setParentReplyNo(null);
//		boolean isReplySuccess = replyService.createReply(replyVO);
//		System.out.println(isReplySuccess);
//		System.out.println(replyVO.getReplyNo());
		
//		댓글 수정
//		게시글 삭제
		ArticleDAO articleDAO = new ArticleDAOImpl();
		articleVO.setArticleNo("AR-20230303-00078");
		articleDAO.deleteArticle(articleVO);
		
//		댓글 삭제
		
//		게시글 좋아요
		
//		게시글 싫어요
//		게시글 신고
//		댓글 좋아요
//		댓글 싫어요
	}

}
