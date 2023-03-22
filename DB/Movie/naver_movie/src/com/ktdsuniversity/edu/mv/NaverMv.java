package com.ktdsuniversity.edu.mv;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.mv.cmmncd.service.CmmnCdService;
import com.ktdsuniversity.edu.mv.cmmncd.service.CmmnCdServiceImpl;
import com.ktdsuniversity.edu.mv.cmmncd.vo.CmmnCdVO;
import com.ktdsuniversity.edu.mv.cmpn.service.CmpnService;
import com.ktdsuniversity.edu.mv.cmpn.service.CmpnServiceImpl;
import com.ktdsuniversity.edu.mv.cmpn.vo.CmpnVO;
import com.ktdsuniversity.edu.mv.fmsln.service.FmsLnService;
import com.ktdsuniversity.edu.mv.fmsln.service.FmsLnServiceImpl;
import com.ktdsuniversity.edu.mv.fmsln.vo.FmsLnVO;
import com.ktdsuniversity.edu.mv.gnr.controller.GnrController;
import com.ktdsuniversity.edu.mv.gnr.service.GnrService;
import com.ktdsuniversity.edu.mv.gnr.service.GnrServiceImpl;
import com.ktdsuniversity.edu.mv.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.mv.mv.service.MvService;
import com.ktdsuniversity.edu.mv.mv.service.MvServiceImpl;
import com.ktdsuniversity.edu.mv.mv.vo.MvVO;
import com.ktdsuniversity.edu.mv.mv.vo.PrdcPrtcptnCmpnVO;
import com.ktdsuniversity.edu.mv.mv.vo.PrdcPrtcptnPplVO;
import com.ktdsuniversity.edu.mv.mvppl.service.MvPplService;
import com.ktdsuniversity.edu.mv.mvppl.service.MvPplServiceImpl;
import com.ktdsuniversity.edu.mv.mvppl.vo.MvPplVO;
import com.ktdsuniversity.edu.mv.ntn.service.NtnService;
import com.ktdsuniversity.edu.mv.ntn.service.NtnServiceImpl;
import com.ktdsuniversity.edu.mv.ntn.vo.NtnVO;
import com.ktdsuniversity.edu.mv.pht.service.PhtService;
import com.ktdsuniversity.edu.mv.pht.service.PhtServiceImpl;
import com.ktdsuniversity.edu.mv.pht.vo.PhtVO;
import com.ktdsuniversity.edu.mv.rtng.service.RtngService;
import com.ktdsuniversity.edu.mv.rtng.service.RtngServiceImpl;
import com.ktdsuniversity.edu.mv.rtng.vo.RtngVO;
import com.ktdsuniversity.edu.mv.vd.service.VdService;
import com.ktdsuniversity.edu.mv.vd.service.VdServiceImpl;
import com.ktdsuniversity.edu.mv.vd.vo.VdVO;

public class NaverMv implements GnrController{
//	private void gnr(GnrService gnrService) {
//		createGnr(gnrService, getNextLine("장르 이름 넣으셈"));
//		deleteGnr(gnrService, getNextInt("지울 id 넣어"));
//		readAllGnr(gnrService);
//		updateGnr(gnrService, getNextInt("수정 아이디"), getNextLine("수정 내용"));
//	}
	public static void main(String[] args){
		NaverMv nm = new NaverMv();
		boolean createResult = false;
		
		GnrService gnrService = new GnrServiceImpl();
		GnrVO gnrVO = new GnrVO();
		gnrVO.setGnrNm("범죄");
//		createResult = gnrService.createGnr(gnrVO);
//		System.out.println("장르 등록 " + createResult);
//		
		NtnService ntnService = new NtnServiceImpl();
		NtnVO ntnVO = new NtnVO();
		ntnVO.setNtnNm("대한민국");
//		createResult = ntnService.createNtn(ntnVO);
//		System.out.println("국가 등록 " + createResult);
//		
		MvPplService mvPplService = new MvPplServiceImpl();
		MvPplVO mvPplVO = new MvPplVO();
		mvPplVO.setPrflPht("Profile Photo URL");
		mvPplVO.setNm("최지영");
		mvPplVO.setRlNm(null);
//		createResult = mvPplService.createMyPpl(mvPplVO);
//		System.out.println("영화인 등록 " + createResult);
//		
		CmpnService cmpnService = new CmpnServiceImpl();
		CmpnVO cmpnVO = new CmpnVO();
		cmpnVO.setCmpnNm("(주)누리픽쳐스");
//		createResult = cmpnService.createCmpn(cmpnVO);
//		System.out.println("회사 등록 " + createResult);
//		
		CmmnCdService cmmnCdService = new CmmnCdServiceImpl();
		CmmnCdVO cmmnCdVO = new CmmnCdVO();
		cmmnCdVO.setCdId("001_01");
		cmmnCdVO.setCdNm("상영중");
		cmmnCdVO.setPrcdncCdId(null);
//		createResult = cmmnCdService.createCmmnCd(cmmnCdVO);
//		System.out.println("공통코드 등록 " + createResult);
		
		MvService mvService = new MvServiceImpl();
		MvVO mvVO = new MvVO();
		mvVO.setMvTtl("새로운 영화");
		mvVO.setEngTtl("New Movie");
		mvVO.setScrnStt("001_01");
		mvVO.setScrnTm(120);
		mvVO.setOpngDt("20230308");
		mvVO.setGrd("002_04");
		mvVO.setPstr("URL");
		mvVO.setSmr("줄거리");
		
		List<GnrVO> gnrList = new ArrayList<>();
//		GnrVO gnrVO = new GnrVO();
		gnrVO.setGnrId(26);
		gnrList.add(gnrVO);
		mvVO.setGnrList(gnrList);
		
		List<NtnVO> ntnList = new ArrayList<>();
//		NtnVO ntnVO = new NtnVO();
		ntnVO.setNtnId(26);
		ntnList.add(ntnVO);
		mvVO.setNtnList(ntnList);
		
		List<PrdcPrtcptnCmpnVO> cmpnList = new ArrayList<>();
		PrdcPrtcptnCmpnVO prdcPrtcptnCmpnVO = new PrdcPrtcptnCmpnVO();
		prdcPrtcptnCmpnVO.setCmpnId("CO-20230308-00002");
		prdcPrtcptnCmpnVO.setDstrbtn("006_001");
		cmpnList.add(prdcPrtcptnCmpnVO);
		
		prdcPrtcptnCmpnVO.setCmpnId("CO-20230308-00002");
		prdcPrtcptnCmpnVO.setDstrbtn("006_002");
		cmpnList.add(prdcPrtcptnCmpnVO);

		mvVO.setCmpnList(cmpnList);
		
		List<PrdcPrtcptnPplVO> mvPplList = new ArrayList<>();
		PrdcPrtcptnPplVO prdcPrtcptnPplVO = new PrdcPrtcptnPplVO();
		prdcPrtcptnPplVO.setMvPplId("PD-20230308-00006");
		prdcPrtcptnPplVO.setRol("005_02");
		prdcPrtcptnPplVO.setDtlRol(null);
		mvPplList.add(prdcPrtcptnPplVO);
		mvVO.setMvPplList(mvPplList);
		
//		mvService.createMv(mvVO);	
		
		PhtService phtService = new PhtServiceImpl();
		PhtVO phtVO = new PhtVO();
//		phtVO.setMvId("MV-20230309-00030");
//		phtVO.setPhtTp("003_01");
//		phtVO.setThmbnlPht("URL");
//		phtVO.setOrgnlPht("OriginalPhoto");
//		createResult = phtService.createPht(phtVO);
//		System.out.println("사진 등록 " + createResult);
//		
		VdService vdService = new VdServiceImpl();
		VdVO vdVO = new VdVO();
//		vdVO.setMvId("MV-20230309-00030");
//		vdVO.setVdTp("004_01");
//		vdVO.setVdTtl("리뷰 예고편");
//		vdVO.setThmbnl("URL");
//		vdVO.setVdUrl("Video Url");
//		createResult = vdService.creatdVd(vdVO);
//		System.out.println("동영상 등록 " + createResult);
//		
		RtngService rtngService = new RtngServiceImpl();
		RtngVO rtngVO = new RtngVO();
//		rtngVO.setMvId("MV-20230309-00030");
//		rtngVO.setRtng(3);
//		rtngVO.setRtngCntnt("이거 본 걸 비밀로 해야돼서 대외비임");
//		rtngVO.setRtngWrtr("kkkk");
//		createResult = rtngService.createRtngDAO(rtngVO);
//		System.out.println("평점 등록 " + createResult);
//		
		FmsLnService fmsLnService = new FmsLnServiceImpl();
		FmsLnVO fmsLnVO = new FmsLnVO();
//		fmsLnVO.setMvId("MV-20230309-00030");
//		fmsLnVO.setMvPplId("PD-20230308-00006");
//		fmsLnVO.setFmsLn("예수님입니다, 부활 하셨거든");
//		fmsLnVO.setXplntn(null);
//		fmsLnVO.setRgstPplNm("yoog");
//		createResult = fmsLnService.createFmsLn(fmsLnVO);
//		System.out.println("명대사 등록 " + createResult);
		
//		gnrVO.setGnrId(2);
//		gnrVO.setGnrNm("스릴러");
//		gnrService.updateGnr(gnrVO);
		
//		cmpnVO.setCmpnId("CO-20230308-00002");
//		cmpnVO.setCmpnNm("유니버설 픽쳐스");
//		cmpnService.updateCmpn(cmpnVO);
		
//		mvPplVO.setPrflPht("URL");
//		mvPplVO.setNm("호두");
//		mvPplVO.setMvPplId("PD-20230308-00006");
//		mvPplService.updateMyPpl(mvPplVO);
		
//		ntnVO.setNtnId(2);
//		ntnVO.setNtnNm("프랑스");
//		ntnService.updateNtn(ntnVO);
		
//		phtVO.setPhtTp("003_10");
//		phtVO.setThmbnlPht("URL");
//		phtVO.setOrgnlPht("원본사진");
//		phtVO.setPhtId("PT-20230309-00001");
//		phtService.updatePht(phtVO);
		
//		rtngVO.setRtng(5);
//		rtngVO.setRtngCntnt("정말 재미있어요!");
//		rtngVO.setRtngId("MR-20230309-00001");
//		rtngService.updateRtngDAO(rtngVO);
		
//		fmsLnVO.setMvPplId("PD-20230308-00006");
//		fmsLnVO.setFmsLn("동작그만 밑장빼기냐");
//		fmsLnVO.setFmsLnId("FL-20230309-00001");
//		fmsLnService.updateFmsLn(fmsLnVO);
		
//		vdVO.setVdTp("004_02");
//		vdVO.setVdTtl("대외비 영상");
//		vdVO.setThmbnl("썸네일 링크");
//		vdVO.setVdUrl("동영상 링크");
//		vdVO.setMvId("VD-20230309-00002");
//		vdService.updateVd(vdVO);
		
		
//		mvVO.setMvId("MV-20230309-00029");
//		mvVO.setMvTtl("수정된 영화");
//		mvVO.setEngTtl("Updated");
//		mvService.updateMv(mvVO);
		
//		gnrService.deleteGnr(2);
//		ntnService.deleteNtn(2);
//		mvPplService.deleteMyPpl("PD-20230308-00006");
//		cmpnService.deleteCmpn("CO-20230308-00002");
//		phtService.deletePht("PT-20230309-00001");
//		vdService.deleteVd("VD-20230309-00002");
//		rtngService.deleteRtng("MR-20230309-00003");
//		fmsLnService.deleteFmsLn("FL-20230309-00001");
		
//		mvService.deleteMv("MV-20230309-00042");
		
		List<CmmnCdVO> readCmmnCdList = cmmnCdService.readAllCmmnCd();
		for (CmmnCdVO cmmnCd: readCmmnCdList) {
			System.out.println(cmmnCd.getCdId());
			System.out.println(cmmnCd.getCdNm());
			System.out.println(cmmnCd.getPrcdncCdId());
			System.out.println("=======================");
		}
		
		List<CmpnVO> readCmpnList = cmpnService.readAllCmpn();
		for (CmpnVO cmpn: readCmpnList) {
			System.out.println(cmpn.getCmpnId());
			System.out.println(cmpn.getCmpnNm());
			System.out.println("=======================");
		}
		
		List<FmsLnVO> readFmList = fmsLnService.readAllFmsLn();
		for (FmsLnVO fmsln : readFmList) {
			System.out.println(fmsln.getFmsLn());
			System.out.println(fmsln.getMvId());
			System.out.println(fmsln.getMvPplId());
			System.out.println(fmsln.getXplntn());
			System.out.println(fmsln.getRgstTm());
			System.out.println(fmsln.getRgstPplNm());
			System.out.println(fmsln.getRcmmndCnt());
			System.out.println("=====================");
		}
		
		List<GnrVO> readGnrList = gnrService.readAllGnr();
		for (GnrVO gnr : readGnrList) {
			System.out.println(gnr.getGnrId());
			System.out.println(gnr.getGnrNm());
			System.out.println("======================");
		}
		
		List<MvPplVO> readMvPplList = mvPplService.readAllMyPpl();
		for (MvPplVO mvppl : readMvPplList) {
			System.out.println(mvppl.getMvPplId());
			System.out.println(mvppl.getPrflPht());
			System.out.println(mvppl.getNm());
			System.out.println(mvppl.getRlNm());
			System.out.println("===============================");
		}
		
		List<NtnVO> readNtnList = ntnService.readAllNtn();
		for (NtnVO ntn : readNtnList) {
			System.out.println(ntn.getNtnId());
			System.out.println(ntn.getNtnNm());
			System.out.println("=================================");
		}
		
		List<PhtVO> readPhtList = phtService.readAllPht();
		for (PhtVO pht : readPhtList) {
			System.out.println(pht.getPhtId());
			System.out.println(pht.getMvId());
			System.out.println(pht.getPhtTp());
			System.out.println(pht.getThmbnlPht());
			System.out.println(pht.getOrgnlPht());
			System.out.println("=================================");
		}
		
		List<RtngVO> readRtngList = rtngService.readAllRtng();
		for (RtngVO rtng : readRtngList) {
			System.out.println(rtng.getRtngId());
			System.out.println(rtng.getMvId());
			System.out.println(rtng.getRtngCntnt());
			System.out.println(rtng.getRtngWrtr());
			System.out.println(rtng.getRtngRgstTm());
			System.out.println(rtng.getLkcnt());
			System.out.println(rtng.getDslkCnt());
			System.out.println("====================================");
		}
		
		List<VdVO> readVdList = vdService.readAllVd();
		for (VdVO vd: readVdList) {
			System.out.println(vd.getVdId());
			System.out.println(vd.getMvId());
			System.out.println(vd.getVdTp());
			System.out.println(vd.getVdTtl());
			System.out.println(vd.getThmbnl());
			System.out.println(vd.getVdPlyCnt());
			System.out.println(vd.getVdUrl());
			System.out.println(vd.getRgstDt());
			System.out.println("=====================================");
		}
		
		List<MvVO> mvList = mvService.readAllMovie();
		for (MvVO mv : mvList) {
			System.out.println(mv.getMvId());
			System.out.println(mv.getMvTtl());
			System.out.println(mv.getEngTtl());
			System.out.println(mv.getScrnStt());
			System.out.println(mv.getOpngDt());
			System.out.println(mv.getGrd());
			System.out.println(mv.getPstr());
			
			List<GnrVO> mvGnrList = mvVO.getGnrList();
			List<NtnVO> mvNtnList = mvVO.getNtnList();
			
			for (GnrVO gnr : mvGnrList) {
				System.out.println(gnr.getGnrId());
				System.out.println(gnr.getGnrNm());
			}
			
			for (NtnVO ntn : mvNtnList) {
				System.out.println(ntn.getNtnId());
				System.out.println(ntn.getNtnNm());
			}
			System.out.println("===============================");
		}
		
		MvVO oneMvVO = mvService.readOneMv("MV-20230310-00055");
		System.out.println(oneMvVO.getMvId());
		System.out.println(oneMvVO.getMvTtl());
		System.out.println(oneMvVO.getEngTtl());
		System.out.println(oneMvVO.getScrnStt());
		System.out.println(oneMvVO.getOpngDt());
		System.out.println(oneMvVO.getGrd());
		System.out.println(oneMvVO.getPstr());
		
		List<GnrVO> mvGnrList = mvVO.getGnrList();
		List<NtnVO> mvNtnList = mvVO.getNtnList();
		
		for (GnrVO gnr : mvGnrList) {
			System.out.println(gnr.getGnrId());
			System.out.println(gnr.getGnrNm());
		}
		
		for (NtnVO ntn : mvNtnList) {
			System.out.println(ntn.getNtnId());
			System.out.println(ntn.getNtnNm());
		}
	}
}
