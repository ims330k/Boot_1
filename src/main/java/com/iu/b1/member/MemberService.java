package com.iu.b1.member;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MemberFilesMapper memberFilesMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	
	
	public int memberJoin (MemberVO memberVO, MultipartFile files)throws Exception{
		memberMapper.memberJoin(memberVO);
		File file=filePathGenerator.getUseResourceLoader("upload");
		String fileName=fileSaver.save(file, files);
		System.out.println(fileName);
		MemberFilesVO memberFilesVO=new MemberFilesVO();
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFname(fileName);
		memberFilesVO.setOname(files.getOriginalFilename());
		int result=memberFilesMapper.memberFilesInsert(memberFilesVO);
		return result;
	}
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception{
		memberVO=memberMapper.memberLogin(memberVO);
		return memberVO;
	}
	
	public MemberFilesVO selectFiles(MemberVO memberVO)throws Exception{
		MemberFilesVO memberFilesVO=memberFilesMapper.selectFiles(memberVO);
		return memberFilesVO;
	}
	
	public MemberFilesVO selectMemberFiles(MemberFilesVO memberFilesVO)throws Exception{
		return memberFilesMapper.selectMemberFiles(memberFilesVO);
	}

	public boolean memberJoinValidate(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		boolean check=false;	//true=err , false=ok
		//annotation 검증 결과
		if(bindingResult.hasErrors()) {
			check=true;
		}
		
		//password 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			check=true;
			bindingResult.rejectValue("pw2", "memberVO.getPw().notEqual");
										//form의 path명, properties의 키값
		}
		return check;
	}
	
}
