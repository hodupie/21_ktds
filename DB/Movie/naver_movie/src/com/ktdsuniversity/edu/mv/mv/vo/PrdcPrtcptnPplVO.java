package com.ktdsuniversity.edu.mv.mv.vo;

import com.ktdsuniversity.edu.mv.mvppl.vo.MvPplVO;

public class PrdcPrtcptnPplVO extends MvPplVO {
	
	/**
	 * 역할
	 */
	private String rol;
	
	/**
	 * 세부역할
	 */
	private String dtlRol;

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDtlRol() {
		return dtlRol;
	}

	public void setDtlRol(String dtlRol) {
		this.dtlRol = dtlRol;
	}
	
}
