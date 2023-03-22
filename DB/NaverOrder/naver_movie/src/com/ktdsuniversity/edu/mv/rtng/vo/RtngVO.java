package com.ktdsuniversity.edu.mv.rtng.vo;

import com.ktdsuniversity.edu.mv.util.db.Column;
import com.ktdsuniversity.edu.mv.util.db.UseColumn;

@UseColumn
public class RtngVO {
	
	@Column("RTNG_ID")
	private String rtngId;
	@Column("MV_ID")
	private String mvId;
	@Column("RTNG")
	private int rtng;
	@Column("RTNG_CNTNT")
	private String rtngCntnt;
	@Column("RTNG_WRTR")
	private String rtngWrtr;
	@Column("RTNG_RGST_TM")
	private String rtngRgstTm;
	@Column("LK_CNT")
	private int lkcnt;
	@Column("DSLK_CNT")
	private int dslkCnt;
	
	public String getRtngId() {
		return rtngId;
	}
	public void setRtngId(String rtngId) {
		this.rtngId = rtngId;
	}
	public String getMvId() {
		return mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public int getRtng() {
		return rtng;
	}
	public void setRtng(int rtng) {
		this.rtng = rtng;
	}
	public String getRtngCntnt() {
		return rtngCntnt;
	}
	public void setRtngCntnt(String rtngCntnt) {
		this.rtngCntnt = rtngCntnt;
	}
	public String getRtngWrtr() {
		return rtngWrtr;
	}
	public void setRtngWrtr(String rtngWrtr) {
		this.rtngWrtr = rtngWrtr;
	}
	public String getRtngRgstTm() {
		return rtngRgstTm;
	}
	public void setRtngRgstTm(String rtngRgstTm) {
		this.rtngRgstTm = rtngRgstTm;
	}
	public int getLkcnt() {
		return lkcnt;
	}
	public void setLkcnt(int lkcnt) {
		this.lkcnt = lkcnt;
	}
	public int getDslkCnt() {
		return dslkCnt;
	}
	public void setDslkCnt(int dslkCnt) {
		this.dslkCnt = dslkCnt;
	}
	
	
}
