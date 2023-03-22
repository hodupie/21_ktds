package com.ktdsuniversity.edu.mv.gnr.vo;

import com.ktdsuniversity.edu.mv.util.db.Column;
import com.ktdsuniversity.edu.mv.util.db.UseColumn;

@UseColumn
public class GnrVO {
	
	/**
	 * 장르ID
	 */
	@Column("GNR_ID")
	private int gnrId;
	
	/**
	 * 장르명
	 */
	@Column("GNR_NM")
	private String gnrNm;
	
	/**
	 * 장르ID setting
	 * @param gnrId
	 */
	public void setGnrId(int gnrId) {
		this.gnrId = gnrId;
	}
	
	/**
	 * 장르ID 반환
	 * @return 장르ID
	 */
	public int getGnrId() {
		return gnrId;
	}
	
	/**
	 * 장르명 setting
	 * @param gnrNm
	 */
	public void setGnrNm(String gnrNm) {
		this.gnrNm = gnrNm;
	}
	
	/**
	 * 장르명 반환
	 * @return 장르명
	 */
	public String getGnrNm() {
		return gnrNm;
	}

}
