package com.ktdsuniversity.edu.mv.ntn.vo;

import com.ktdsuniversity.edu.mv.util.db.Column;
import com.ktdsuniversity.edu.mv.util.db.UseColumn;

@UseColumn
public class NtnVO {
	/**
	 * 국가ID
	 */
	@Column("NTN_ID")
	private int ntnId;
	
	/**
	 * 국가명
	 */
	@Column("NTN_NM")
	private String ntnNm;
	
	public int getNtnId() {
		return ntnId;
	}
	public void setNtnId(int ntnId) {
		this.ntnId = ntnId;
	}
	public String getNtnNm() {
		return ntnNm;
	}
	public void setNtnNm(String ntnNm) {
		this.ntnNm = ntnNm;
	}
}
