package com.ktdsuniversity.edu.mv.cmpn.vo;

import com.ktdsuniversity.edu.mv.util.db.Column;
import com.ktdsuniversity.edu.mv.util.db.UseColumn;

@UseColumn
public class CmpnVO {
	
	/**
	 * 회사ID
	 */
	@Column("CMPN_ID")
	private String cmpnId;
	
	/**
	 * 회사명
	 */
	@Column("CMPN_NM")
	private String cmpnNm;
	
	public String getCmpnId() {
		return cmpnId;
	}
	public void setCmpnId(String cmpnId) {
		this.cmpnId = cmpnId;
	}
	public String getCmpnNm() {
		return cmpnNm;
	}
	public void setCmpnNm(String cmpnNm) {
		this.cmpnNm = cmpnNm;
	}
	
}
