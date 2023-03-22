package com.ktdsuniversity.edu.mv.pht.vo;

import com.ktdsuniversity.edu.mv.util.db.Column;
import com.ktdsuniversity.edu.mv.util.db.UseColumn;

@UseColumn
public class PhtVO {
	
	@Column("PHT_ID")
	private String phtId;
	@Column("MV_ID")
	private String mvId;
	@Column("PHT_TP")
	private String phtTp;
	@Column("THMBNL_PH")
	private String thmbnlPht;
	@Column("ORGNL_PHT")
	private String orgnlPht;
	
	public String getPhtId() {
		return phtId;
	}
	public void setPhtId(String phtId) {
		this.phtId = phtId;
	}
	public String getMvId() {
		return mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public String getPhtTp() {
		return phtTp;
	}
	public void setPhtTp(String phtTp) {
		this.phtTp = phtTp;
	}
	public String getThmbnlPht() {
		return thmbnlPht;
	}
	public void setThmbnlPht(String thmbnlPht) {
		this.thmbnlPht = thmbnlPht;
	}
	public String getOrgnlPht() {
		return orgnlPht;
	}
	public void setOrgnlPht(String orgnlPht) {
		this.orgnlPht = orgnlPht;
	}
	
	
}
