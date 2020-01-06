package com.iu.b1.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;

@Service
public class NoticeService {

	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	
	@Transactional
	public int boardWrite(NoticeVO noticeVO,MultipartFile[] files)throws Exception{
		int result=noticeMapper.boardWrite(noticeVO);
		File file=filePathGenerator.getUseClassPathResource("notice");
		List<NoticeFilesVO> list = new ArrayList<>();
		for(int i=1; i<files.length;i++) {
			NoticeFilesVO noticeFilesVO=new NoticeFilesVO();
			String filename=fileSaver.save(file, files[i]);
			noticeFilesVO.setNum(noticeVO.getNum());
			noticeFilesVO.setFname(filename.substring(0, 6));
			noticeFilesVO.setOname(files[i].getOriginalFilename());
			//mapper 호출
			//result=noticeMapper.boardFileWrite(noticeFilesVO);
			list.add(noticeFilesVO);
		}
		noticeMapper.boardFileWrite(list);
		return result;
	}
	
	
}
