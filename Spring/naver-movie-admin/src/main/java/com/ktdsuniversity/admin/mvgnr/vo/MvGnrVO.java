package com.ktdsuniversity.admin.mvgnr.vo;

import java.util.List;

import com.ktdsuniversity.admin.gnr.vo.GnrVO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

/**
 * MV_GNR
 */
public class MvGnrVO {

	/**
	 * 
	 */
	private String mvId;

	/**
	 * 
	 */
	private int gnrId;

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
	
	private List<String> deleted;


	private MbrVO crtMbrVO;
	private MbrVO mdfyrMbrVO;
	private GnrVO gnrVO;

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

	public GnrVO getGnrVO() {
		return gnrVO;
	}

	public void setGnrVO(GnrVO gnrVO) {
		this.gnrVO = gnrVO;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setGnrId(int gnrId) {
		this.gnrId = gnrId;
	}

	public int getGnrId() {
		return this.gnrId;
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