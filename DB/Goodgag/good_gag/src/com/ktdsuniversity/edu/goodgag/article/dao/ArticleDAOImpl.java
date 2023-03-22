package com.ktdsuniversity.edu.goodgag.article.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.goodgag.article.vo.ArticleLDVO;
import com.ktdsuniversity.edu.goodgag.article.vo.ArticleVO;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;
import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;
import com.ktdsuniversity.edu.goodgag.utils.db.AbstractDaoPoolSupport;

public class ArticleDAOImpl extends AbstractDaoPoolSupport<ArticleVO> implements ArticleDAO{

	@Override
	public String createNewArticleNo() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT 'AR-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_ARTICLE_PK.NEXTVAL, 5, '0') NEW_SEQ ");
		query.append("   FROM DUAL																				 		   ");
		
		return selectOneString(query.toString(), null, (rm) -> {
			return rm.getString("NEW_SEQ");
		});
	}
	
	
	@Override
	public int createArticle(ArticleVO articleVO) {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO ARTICLE ");
		query.append("  (ARTICLE_NO        ");
		query.append("  , EMAIL            ");
		query.append("  , REGIST_DATE      ");
		query.append("  , TITLE            ");
		query.append("  , DESCRIPT         ");
		query.append("  , SOURCE           ");
		query.append("  , NOTI_YN)         ");
		query.append(" VALUES              ");
		// ARTICLE_NO는 ArticleService의 createArticle로 대체
		query.append("  ( ?       ");
		query.append("  , ?       ");
		query.append("  , SYSDATE ");
		query.append("  , ?       ");
		query.append("  , ?       ");
		query.append("  , ?       ");
		query.append("  , ?)      ");
		
		return insert(query.toString(), (pm) -> {
			pm.setString(1, articleVO.getArticleNo());
			pm.setString(2, articleVO.getEmail());
			pm.setString(3, articleVO.getTitle());
			pm.setString(4, articleVO.getDescript());
			pm.setString(5, articleVO.getSource());
			pm.setString(6, articleVO.getNotiYn());
		});
	}


	@Override
	public List<ArticleVO> getAllArticles() {
		StringBuffer query = new StringBuffer();
	query.append(" SELECT ROW_NUMBER() OVER(ORDER BY A.ARTICLE_NO ASC) ROWNUMBER ");
	query.append("      , A.ARTICLE_NO                                           ");
	query.append("	    , A.EMAIL A_EMAIL                                        ");
	query.append("	    , A.REGIST_DATE                                          ");
	query.append("	    , A.TITLE                                                ");
	query.append("	    , A.DESCRIPT                                             ");
	query.append("	    , A.SOURCE                                               ");
	query.append("	    , A.NOTI_YN                                              ");
	query.append("	    , R.REPLY_NO                                             ");
	query.append("	    , M.EMAIL M_EMAIL                                        ");
	query.append("	    , M.NICKNAME                                             ");
	query.append("   FROM ARTICLE A                                              ");
	query.append("   LEFT OUTER JOIN REPLIES R                                   ");
	query.append("     ON A.ARTICLE_NO = R.ARTICLE_NO                            ");
	query.append("  INNER JOIN MEMBER M                                          ");
	query.append("     ON A.EMAIL = M.EMAIL                                      ");
	query.append("  ORDER BY A.ARTICLE_NO DESC                                   ");
	
	List<ArticleVO> articleList = new ArrayList<>();
	
	select(query.toString(), null, (rm) -> {
		String articleNo = rm.getString("ARTICLE_NO");

		ArticleVO articleVO = getExistArticle(articleList, articleNo);
		if (articleVO != null) {
			// 이미 등록된 Article일 경우
			// eachArticle의 replyList를 가져온다.
			List<ReplyVO> replyList = articleVO.getReplyList();
			String replyId = rm.getString("REPLY_NO");
			if (replyId != null) {
				ReplyVO replyVO = new ReplyVO();
				replyVO.setReplyNo(replyId);
				replyList.add(replyVO);
			}

			return articleVO;
		}
		else {
			// 아직 등록되지 않은 Article일 경우
			// 새로운 Article을 생성한다.
			articleVO = new ArticleVO();
			articleVO.setArticleNo(articleNo);
			articleVO.setEmail(rm.getString("A_EMAIL"));
			articleVO.setTitle(rm.getString("TITLE"));
			articleVO.setRegistDate(rm.getString("REGIST_DATE"));
			articleVO.setNotiYn(rm.getString("NOTI_YN"));

			List<ReplyVO> replyList = new ArrayList<>();
			articleVO.setReplyList(replyList);
			String replyId = rm.getString("REPLY_NO");
			if (replyId != null) {
				// 댓글이 있다면
				// replyList에 추가
				ReplyVO replyVO = new ReplyVO();
				replyVO.setReplyNo(replyId);
				replyList.add(replyVO);
			}
			
			// 게시글 작성자
			MemberVO memberVO = new MemberVO();
			articleVO.setMemberVO(memberVO);
			memberVO.setEmail(rm.getString("M_EMAIL"));
			memberVO.setNickname(rm.getString("NICKNAME"));

			articleList.add(articleVO);
			return articleVO;
		}
	});

	return articleList;
	}
	
	/**
	 * articleList 에 articleNo 값을 가진 ArticleVO 객체를 반환한다.
	 * 없으면 null을 반환한다.
	 * @param articleList
	 * @param articleNo
	 * @return ArticleVO
	 */
	private ArticleVO getExistArticle(List<ArticleVO> articleList, String articleNo) {
		for (ArticleVO eachArticle: articleList) {
			if (eachArticle.getArticleNo().equals(articleNo)) {
				return eachArticle;
			}
		}
	
		return null;
	}


	@Override
	public int deleteArticle(ArticleVO articleVO) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE                ");
		query.append("   FROM ARTICLE        ");
		query.append("  WHERE ARTICLE_NO = ? ");
		
		return insert(query.toString(), (pm) -> {
			pm.setString(1, articleVO.getArticleNo());
		});
	}


}
