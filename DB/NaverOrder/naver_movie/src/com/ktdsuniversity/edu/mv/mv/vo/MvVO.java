package com.ktdsuniversity.edu.mv.mv.vo;

import java.util.List;

import com.ktdsuniversity.edu.mv.cmpn.vo.CmpnVO;
import com.ktdsuniversity.edu.mv.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.mv.mvppl.vo.MvPplVO;
import com.ktdsuniversity.edu.mv.ntn.vo.NtnVO;
import com.ktdsuniversity.edu.mv.util.db.Column;
import com.ktdsuniversity.edu.mv.util.db.UseColumn;

@UseColumn(keyColum = "MV_ID", keyVarName = "mvId", keyType = String.class)
public class MvVO {
	@Column(value = "MV_ID", isRequire = true)
	private String mvId;
	@Column("MV_TTL")
	private String mvTtl;
	@Column("ENG_TTL")
	private String engTtl;
	@Column("SCRN_STT")
	private String scrnStt;
	@Column("SCRN_TM")
	private int scrnTm;
	@Column("OPNG_DT")
	private String opngDt;
	@Column("GRD")
	private String grd;
	@Column("PSTR")
	private String pstr;
	@Column("SMR")
	private String smr;
	
	// 하나의 영화는 여러 장르를 가진다 (1:n)
	@Column(cls = GnrVO.class)
	private List<GnrVO> gnrList;
	// 하나의 영화는 여러 국가를 가진다 (1:n)
	@Column(cls = NtnVO.class)
	private List<NtnVO> ntnList;
	// 하나의 영화는 여러 회사를 가진다 (1:n) -> CmpnVO에서 PrdcPrtcptnCmpnVO로
	private List<PrdcPrtcptnCmpnVO> cmpnList;
	// 하나의 영화는 여러 영화인을 가진다 (1:n) -> MvPplVO에서 PrdcPrtcptnPplVO
	private List<PrdcPrtcptnPplVO> mvPplList;
	
	public String getMvId() {
		return mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public String getMvTtl() {
		return mvTtl;
	}
	public void setMvTtl(String mvTtl) {
		this.mvTtl = mvTtl;
	}
	public String getEngTtl() {
		return engTtl;
	}
	public void setEngTtl(String engTtl) {
		this.engTtl = engTtl;
	}
	public String getScrnStt() {
		return scrnStt;
	}
	public void setScrnStt(String scrnStt) {
		this.scrnStt = scrnStt;
	}
	public int getScrnTm() {
		return scrnTm;
	}
	public void setScrnTm(int scrnTm) {
		this.scrnTm = scrnTm;
	}
	public String getOpngDt() {
		return opngDt;
	}
	public void setOpngDt(String opngDt) {
		this.opngDt = opngDt;
	}
	public String getGrd() {
		return grd;
	}
	public void setGrd(String grd) {
		this.grd = grd;
	}
	public String getPstr() {
		return pstr;
	}
	public void setPstr(String pstr) {
		this.pstr = pstr;
	}
	public String getSmr() {
		return smr;
	}
	public void setSmr(String smr) {
		this.smr = smr;
	}
	public List<GnrVO> getGnrList() {
		return gnrList;
	}
	public void setGnrList(List<GnrVO> gnrList) {
		this.gnrList = gnrList;
	}
	public List<NtnVO> getNtnList() {
		return ntnList;
	}
	public void setNtnList(List<NtnVO> ntnList) {
		this.ntnList = ntnList;
	}
	public List<PrdcPrtcptnCmpnVO> getCmpnList() {
		return cmpnList;
	}
	public void setCmpnList(List<PrdcPrtcptnCmpnVO> cmpnList) {
		this.cmpnList = cmpnList;
	}
	public List<PrdcPrtcptnPplVO> getMvPplList() {
		return mvPplList;
	}
	public void setMvPplList(List<PrdcPrtcptnPplVO> mvPplList) {
		this.mvPplList = mvPplList;
	}
	
	
}
