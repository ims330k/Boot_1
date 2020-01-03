package com.iu.b1.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("memberFileDown")
	public ModelAndView memberFileDown(MemberFilesVO memberFilesVO) throws Exception{
		MemberFilesVO memFiles=new MemberFilesVO();
		ModelAndView mv=new ModelAndView();
		memFiles=memberService.selectMemberFiles(memberFilesVO);
		if(memFiles != null)	{
			mv.addObject("memberFiles", memFiles);
			mv.addObject("path", "upload");
			mv.setViewName("fileDown");
		}
		else {
			mv.addObject("message", "no img files");
			mv.addObject("path", "./mypage");
			mv.setViewName("common/result");
		}
		return mv;
	}
	@GetMapping("memberJoin")
	public String memberJoin()throws Exception{
		return "member/memberJoin";
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(@Valid MemberVO memberVO,BindingResult bindingResult,MultipartFile file)throws Exception{
		int result=memberService.memberJoin(memberVO, file);
		String message="Join fail";
		String path="../";
		if(result>0) {
			message="Join Success";
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path", path);
		return mv;
	}
	
	@ModelAttribute
	public MemberVO  getMemberVO()throws Exception{
		return new MemberVO();
		//이 컨트롤러의 모든 메서드에 멤버를 담아서 전달해줌.
		//그래서 각각 메서드의 매개변수에 memberVO를 작성시킬 필요가 없음.
	}
	@GetMapping("memberLogin")
	public void memberLogin()throws Exception{
		
	}

	@PostMapping("memberLogin")
	public ModelAndView memberLogin2(MemberVO memberVO, HttpSession session)throws Exception{
		
		memberVO=memberService.memberLogin(memberVO);
		String message="login success : "+memberVO.getName()+"님";
		String path="../";
		session.setAttribute("member", memberVO);
		//MemberFilesVO memberFilesVO=memberService.selectFiles(memberVO);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path", path);
		return mv;
	}
	
	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession session) throws Exception{
		ModelAndView mv =new ModelAndView();
		if(session != null) {
			//loged in
			MemberVO memberVO=(MemberVO)session.getAttribute("member");
			MemberFilesVO memberFilesVO=memberService.selectFiles(memberVO);
			mv.addObject("memberFile", memberFilesVO);
			mv.setViewName("member/mypage");
		}
		else {
			String msg="로그인이 필요합니다.";
			String path="./memberLogin";
			
			mv.setViewName("common/result");
			mv.addObject("message", msg);
			mv.addObject("path", path);
		}
		return mv;
	}
	
	@GetMapping("memberLogOut")
	public void memberLogOut(HttpSession session)throws Exception{
		 session.invalidate();
	}
}
