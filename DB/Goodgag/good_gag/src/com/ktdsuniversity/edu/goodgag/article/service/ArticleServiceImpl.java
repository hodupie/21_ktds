package com.ktdsuniversity.edu.goodgag.article.service;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.article.dao.ArticleDAO;
import com.ktdsuniversity.edu.goodgag.article.dao.ArticleDAOImpl;
import com.ktdsuniversity.edu.goodgag.article.vo.ArticleVO;

public class ArticleServiceImpl implements ArticleService{
	
	private ArticleDAO articleDAO;
	
	public ArticleServiceImpl() {
		articleDAO = new ArticleDAOImpl();
	}

	//ArticleNo 시퀀스는 외부에서 생성 -> 시퀀스의 현재값을 알 수 있음 -> 등록 하자마자 상세 조회 가능
	@Override
	public boolean createArticle(ArticleVO articleVO) {
		// 1. 새로운 게시글의 PK값 (ARTICLE_NO)를 받아온다.
		String newArticleNo = articleDAO.createNewArticleNo();
		
		// 2. PK값(ARTICLE_NO)을 파라미터 (articleVO)에 할당한다.
		articleVO.setArticleNo(newArticleNo);
		
		// 3. 게시글을 등록한다.
		int insertCount = articleDAO.createArticle(articleVO);
		
		return insertCount > 0;
	}

	@Override
	public List<ArticleVO> getAllArticles() {
		//데이터 정제
		List<ArticleVO> articleList = articleDAO.getAllArticles();

		return articleList;
	}
	

}
