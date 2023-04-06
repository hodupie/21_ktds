package com.ktdsuniversity.admin.prdcprtcptnppl.vo;

import java.util.List;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.myppl.vo.MvPplVO;

/**
 * PRDC_PRTCPTN_PPL
 */
public class PrdcPrtcptnPplVO {

	/**
	 * 
	 */
	private String prdcPrtcptnId;

	/**
	 * 
	 */
	private String mvId;

	/**
	 * 
	 */
	private String mvPplId;

	/**
	 * 
	 */
	private String rol;

	/**
	 * 
	 */
	private String dtlRol;

	/**
	 * 
	 */
	private String crtDt;

	/**
	 * 
	 */
	private String crtr;

	/**
	 * 
	 */
	private String mdfyDt;

	/**
	 * 
	 */
	private String mdfyr;

	/**
	 * 
	 */
	private String useYn;

	/**
	 * 
	 */
	private String delYn;
	
	private List<String> deleted; // 
	
	private MbrVO crtMbrVO;
	private MbrVO mdfyrMbrVO;
	private MvPplVO mvPplVO;
	
	
	public List<String> getDeleted() {
		return deleted;
	}

	public void setDeleted(List<String> deleted) {
		this.deleted = deleted;
	}

	public MbrVO getCrtMbrVO() {
		return crtMbrVO;
	}

	public void setCrtMbrVO(MbrVO crtMbrVO) {
		this.crtMbrVO = crtMbrVO;
	}

	public MbrVO getMdfyrMbrVO() {
		return mdfyrMbrVO;
	}

	public void setMdfyrMbrVO(MbrVO mdfyrMbrVO) {
		this.mdfyrMbrVO = mdfyrMbrVO;
	}

	public MvPplVO getMvPplVO() {
		return mvPplVO;
	}

	public void setMvPplVO(MvPplVO mvPplVO) {
		this.mvPplVO = mvPplVO;
	}

	public void setPrdcPrtcptnId(String prdcPrtcptnId) {
		this.prdcPrtcptnId = prdcPrtcptnId;
	}

	public String getPrdcPrtcptnId() {
		return this.prdcPrtcptnId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvPplId(String mvPplId) {
		this.mvPplId = mvPplId;
	}

	public String getMvPplId() {
		return this.mvPplId;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getRol() {
		return this.rol;
	}

	public void setDtlRol(String dtlRol) {
		this.dtlRol = dtlRol;
	}

	public String getDtlRol() {
		return this.dtlRol;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public String getCrtDt() {
		return this.crtDt;
	}

	public void setCrtr(String crtr) {
		this.crtr = crtr;
	}

	public String getCrtr() {
		return this.crtr;
	}

	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}

	public String getMdfyDt() {
		return this.mdfyDt;
	}

	public void setMdfyr(String mdfyr) {
		this.mdfyr = mdfyr;
	}

	public String getMdfyr() {
		return this.mdfyr;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getUseYn() {
		return this.useYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getDelYn() {
		return this.delYn;
	}

}