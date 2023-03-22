package com.ktdsuniversity.edu.mv.cmmncd.vo;

import com.ktdsuniversity.edu.mv.util.db.Column;
import com.ktdsuniversity.edu.mv.util.db.UseColumn;

@UseColumn
public class CmmnCdVO {
	
	/**
	 * 코드ID
	 */
	@Column("CD_ID")
	private String cdId;
	
	/**
	 * 코드명
	 */
	@Column("CD_NM")
	private String cdNm;
	
	/**
	 * 상위코드ID
	 */
	@Column("PRCDNC_CD_ID")
	private String prcdncCdId;
	
	public String getCdId() {
		return cdId;
	}
	public void setCdId(String cdId) {
		this.cdId = cdId;
	}
	public String getCdNm() {
		return cdNm;
	}
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	public String getPrcdncCdId() {
		return prcdncCdId;
	}
	public void setPrcdncCdId(String prcdncCdId) {
		this.prcdncCdId = prcdncCdId;
	}

}
