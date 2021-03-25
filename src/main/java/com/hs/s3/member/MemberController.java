package com.hs.s3.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	// ----------------------------------- memberDelete
	// -------------------------------------------------------------------
	@RequestMapping(value = "memberDelete")
	public void memberDelete() throws Exception {
		
	}
	
	@RequestMapping(value="memberDelete", method = RequestMethod.POST)
	public String memberDelete(MemberDTO memberDTO, HttpSession session) throws Exception {
		int result = memberService.memberDelete(memberDTO);
		session.invalidate();
		return "redirect:../";
	}
	
	// ----------------------------------- memberPage
	// -------------------------------------------------------------------
	@RequestMapping(value = "memberPage")
	public void memberPage() throws Exception{
		
	}
	
	// ----------------------------------- memberLogout
	// -------------------------------------------------------------------
	@RequestMapping(value = "memberLogout", method = RequestMethod.GET)
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}

	// ----------------------------------- memberLogin
	// -------------------------------------------------------------------
	@RequestMapping(value = "memberLogin")
	public void memberLogin() throws Exception {

	}

	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		memberDTO = memberService.memberLogin(memberDTO);
		session.setAttribute("member", memberDTO);
		return "redirect:../";
	}

	// ----------------------------------- memberJoin
	// -------------------------------------------------------------------
	@RequestMapping(value = "memberJoin")
	public void memberJoin() throws Exception {

	}

	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO) throws Exception {
		int result = memberService.memberJoin(memberDTO);

		return "redirect:../";
	}

}
