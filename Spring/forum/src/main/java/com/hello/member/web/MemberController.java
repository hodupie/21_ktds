package com.hello.member.web;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.common.Util.StringUtil;
import com.hello.member.Service.MemberService;
import com.hello.member.vo.MemberVO;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/member/login")
	public String viewLoginPage() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String doLogin(MemberVO memberVO, HttpSession session, Model model) {
		// 파라미터 검증
		if (memberVO.getEmail() == null || memberVO.getEmail().length() == 0) {
			throw new RuntimeException("email은 필수값입니다.");
		}

		if (memberVO.getPassword() == null || memberVO.getPassword().length() == 0) {
			throw new RuntimeException("password는 필수값입니다.");
		}
		
		// 1. 로그인 처리
		// 1-1. 회원 데이터 조회
		MemberVO memberData = memberService.readOneMemberByEmailAndPassword(memberVO);
		// 1-2. 회원 데이터가 있는지 확인
		if (memberData != null) {
			// 로그인 성공 및 세션에 데이터 저장
			session.setAttribute("__USER_SESSION_DATA__", memberData);
		}
		else {
			// 로그인 실패
			model.addAttribute("errorCode", "NOT_FOUND_USER");
			return "member/login";
		}
		
		// 2. 로그인 실패 시 (이메일 또는 비밀번호가 틀렸을 때) 처리
		
		return "redirect:/topics";
	}
	
	@GetMapping("/member/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/regist")
	public String viewMemberRegistPage() {
		return "member/regist";
	}
	
	
//	파라미터를 받아오는 방법 1: 고전적인 방법
//	@PostMapping("/member/regist")
//	public String doMemberRegist(HttpServletRequest request) { //HttpServletRequest: HTTP 프로토콜 요청에 대한 정보
//		// 파라미터 받아오기
//		String email = request.getParameter("email");
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//
//		MemberVO member = new MemberVO();
//		member.setEmail(email);
//		member.setName(name);
//		member.setPassword(password);
//		
//		boolean isSuccess = memberService.createNewMember(member);
//		
//		System.out.println("회원등록 성공여부: " + isSuccess);
//		
//		return "redirect:/member/regist"; // /forum/member/regist로 URL을 이동시킨다 -> GetMapping 다시 호출됨
//	}
	
	
//	 파라미터를 받아오는 방법 2: @RequestParam을 통해 받아오기
//	@PostMapping("/member/regist")
//	public String doMemberRegist(@RequestParam String email,
//								  @RequestParam("name") String nm,
//								  @RequestParam("password") String pwd) {
//		
//		MemberVO member = new MemberVO();
//		member.setEmail(email);
//		member.setName(nm);
//		member.setPassword(pwd);
//		
//		boolean isSuccess = memberService.createNewMember(member);		
//		System.out.println("회원등록 성공여부: " + isSuccess);
//		
//		if (!isSuccess) {
//			return "redirect:http://naver.com";
//		}
//		
//		return "redirect:/member/regist";
//	}

	// 파라미터를 받아오는 방법 3
	@PostMapping("/member/regist")
	public String doMemberRegist(MemberVO memberVO) {
		
		String email = memberVO.getEmail();
		String name = memberVO.getName();
		String password = memberVO.getPassword();
		String passwordConfirm = memberVO.getPasswordConfirm();
		
		if (StringUtil.isEmpty(email)) {
			throw new RuntimeException("email은 필수 값입니다.");
		}
		if (StringUtil.isEmpty(name)) {
			throw new RuntimeException("name은 필수 값입니다.");
		}
		if (StringUtil.isEmpty(password)) {
			throw new RuntimeException("password은 필수 값입니다.");
		}
		if (StringUtil.isEmpty(passwordConfirm)) {
			throw new RuntimeException("passwordConfirm은 필수 값입니다.");
		}
		if (StringUtil.isExceedLength(email, 100)) {
			throw new RuntimeException("email은 100글자까지 작성할 수 있습니다.");
		}
		if (StringUtil.isExceedLength(name, 10)) {
			throw new RuntimeException("name은 10글자까지 작성할 수 있습니다.");
		}
		if (StringUtil.isExceedLength(password, 100)) {
			throw new RuntimeException("password은 100글자까지 작성할 수 있습니다.");
		}
		if (StringUtil.isExceedLength(passwordConfirm, 100)) {
			throw new RuntimeException("passwordConfirm은 100글자까지 작성할 수 있습니다.");
		}
		
		if (!StringUtil.isMatchTo(password, passwordConfirm)) {
			throw new RuntimeException("password가 일치하지 않습니다.");
		}
		
		
		boolean isSuccess = memberService.createNewMember(memberVO);
		
//		System.out.println("회원 등록 성공 여부: " + isSuccess);
		
		logger.debug("회원 등록 성공 여부: {}", isSuccess);
		
		return "redirect:/member/regist";
	}
}
