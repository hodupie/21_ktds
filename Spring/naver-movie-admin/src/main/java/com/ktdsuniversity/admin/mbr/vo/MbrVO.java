package com.ktdsuniversity.admin.mbr.vo;

/**
 * MBR
 */
public class MbrVO {

	/**
	 * 
	 */
	private String mbrId;

	/**
	 * 
	 */
	private String mbrNm;

	/**
	 * 
	 */
	private String pwd;

	/**
	 * 
	 */
	private String crtDt;

	/**
	 * 
	 */
	private String useYn;

	/**
	 * 
	 */
	private String lstLgnDt;

	/**
	 * 
	 */
	private String lstLgnIp;

	/**
	 * 
	 */
	private int lgnTryCnt;

	/**
	 * 
	 */
	private String lgnBlckYn;

	/**
	 * 
	 */
	private String lstLgnFailDt;

	/**
	 * 
	 */
	private String pwdSalt;

	/**
	 * 
	 */
	private String pwdChngDt;

	/**
	 * 
	 */
	private String admYn;


	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	public String getMbrId() {
		return this.mbrId;
	}

	public void setMbrNm(String mbrNm) {
		this.mbrNm = mbrNm;
	}

	public String getMbrNm() {
		return this.mbrNm;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public String getCrtDt() {
		return this.crtDt;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getUseYn() {
		return this.useYn;
	}

	public void setLstLgnDt(String lstLgnDt) {
		this.lstLgnDt = lstLgnDt;
	}

	public String getLstLgnDt() {
		return this.lstLgnDt;
	}

	public void setLstLgnIp(String lstLgnIp) {
		this.lstLgnIp = lstLgnIp;
	}

	public String getLstLgnIp() {
		return this.lstLgnIp;
	}

	public void setLgnTryCnt(int lgnTryCnt) {
		this.lgnTryCnt = lgnTryCnt;
	}

	public int getLgnTryCnt() {
		return this.lgnTryCnt;
	}

	public void setLgnBlckYn(String lgnBlckYn) {
		this.lgnBlckYn = lgnBlckYn;
	}

	public String getLgnBlckYn() {
		return this.lgnBlckYn;
	}

	public void setLstLgnFailDt(String lstLgnFailDt) {
		this.lstLgnFailDt = lstLgnFailDt;
	}

	public String getLstLgnFailDt() {
		return this.lstLgnFailDt;
	}

	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}

	public String getPwdSalt() {
		return this.pwdSalt;
	}

	public void setPwdChngDt(String pwdChngDt) {
		this.pwdChngDt = pwdChngDt;
	}

	public String getPwdChngDt() {
		return this.pwdChngDt;
	}

	public void setAdmYn(String admYn) {
		this.admYn = admYn;
	}

	public String getAdmYn() {
		return this.admYn;
	}

}