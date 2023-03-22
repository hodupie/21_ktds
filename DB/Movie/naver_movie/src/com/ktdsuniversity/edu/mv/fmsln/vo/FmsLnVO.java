package com.ktdsuniversity.edu.mv.fmsln.vo;

import com.ktdsuniversity.edu.mv.util.db.Column;
import com.ktdsuniversity.edu.mv.util.db.UseColumn;

@UseColumn
public class FmsLnVO {
	
	@Column("FMS_LN_ID")
	private String fmsLnId;
	@Column("MV_ID")
	private String mvId;
	@Column("MV_PPL_ID")
	private String mvPplId;
	@Column("FMS_LN")
	private String fmsLn;
	@Column("XPLNTN")
	private String xplntn;
	@Column("RGST_TM")
	private String rgstTm;
	@Column("RGST_PPL_NM")
	private String rgstPplNm;
	@Column("RCMMND_CNT")
	private int rcmmndCnt;
	
	public String getFmsLnId() {
		return fmsLnId;
	}
	public void setFmsLnId(String fmsLnId) {
		this.fmsLnId = fmsLnId;
	}
	public String getMvId() {
		return mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public String getMvPplId() {
		return mvPplId;
	}
	public void setMvPplId(String mvPplId) {
		this.mvPplId = mvPplId;
	}
	public String getFmsLn() {
		return fmsLn;
	}
	public void setFmsLn(String fmsLn) {
		this.fmsLn = fmsLn;
	}
	public String getXplntn() {
		return xplntn;
	}
	public void setXplntn(String xplntn) {
		this.xplntn = xplntn;
	}
	public String getRgstTm() {
		return rgstTm;
	}
	public void setRgstTm(String rgstTm) {
		this.rgstTm = rgstTm;
	}
	public String getRgstPplNm() {
		return rgstPplNm;
	}
	public void setRgstPplNm(String rgstPplNm) {
		this.rgstPplNm = rgstPplNm;
	}
	public int getRcmmndCnt() {
		return rcmmndCnt;
	}
	public void setRcmmndCnt(int rcmmndCnt) {
		this.rcmmndCnt = rcmmndCnt;
	}

}
