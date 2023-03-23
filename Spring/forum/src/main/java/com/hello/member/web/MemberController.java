package com.hello.member.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.member.Service.MemberService;
import com.hello.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
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
		
		boolean isSucess = memberService.createNewMember(memberVO);
		
		System.out.println("회원 등록 성공 여부: " + isSucess);
		
		return "redirect:/member/regist";
	}
}
