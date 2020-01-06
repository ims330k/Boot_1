package com.iu.b1.notice;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
//	@GetMapping("noticeWrite")
//	public ModelAndView noticeWrite(Model model) {
//		//1.
//		//model.addAttribute("noticeVO", new NoticeVO());
//		
//		//2.
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("noticeVO", new NoticeVO());
//		return mv;
//		
//		//3.
//		//public ModelAndView noticeWrite(@ModelAttribute(name="boardVO")NoticeVO noticeVO) {
//		//boardVO라는 이름으로 noticeVO를 집어넣는다.
//	}
	
	@GetMapping("noticeWrite")
	public void noticeWrite() {
		
	}
	
	//4.컨트롤러 내부에서 공통적으로 보내주기
	@ModelAttribute(name = "noticeVO")
	public NoticeVO getNoticeVO() {
		return new NoticeVO();
		//notice controller에서 url이 실행되기 전에 이 메서드 먼저 실행.
		//그다음에 나머지 일반적인 url매핑하는 메서드 실행
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(@Valid NoticeVO noticeVO, BindingResult bindingResult, MultipartFile[] files)throws Exception{
		ModelAndView mv=new ModelAndView();
		
		if(bindingResult.hasErrors()) {			
			//검증된 결과물이 bindingResult로 들어온다.
			//에러가 있다면 form으로 이동
			mv.addObject("noticeVO", noticeVO);
			mv.setViewName("notice/noticeWrite");
		}
		else {
			int result=noticeService.boardWrite(noticeVO, files);
			
			String msg="write fail";
			if(result>0) {
				//success
				msg="write success";
			}
			else {
				//fail
			}
			mv.addObject("message", msg);
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
}
