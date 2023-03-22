package com.ktdsuniversity.edu.goodgag.article.service;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.article.vo.ArticleVO;

public interface ArticleService {
	
	/**
	 * 새로운 게시글을 등록한다
	 * (게시글의 ID를 발급받아서 setArticleNO에 할당한다)
	 * @param articleVO
	 * @return 등록 결과(성공/실패)
	 */
	public boolean createArticle(ArticleVO articleVO);
	
	/**
	 * 모든 게시글의 목록을 조회한다.
	 * @return 게시글 목록
	 */
	public List<ArticleVO> getAllArticles();
	

}
