package com.iu.b1.notice;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NoticeMapper {
//mapper스캔하기 위해서 @Mapper
	
	public int boardWrite(NoticeVO noticeVO)throws Exception;
	//public int boardFileWrite(NoticeFilesVO noticeFilesVO)throws Exception;
	public int boardFileWrite(List<NoticeFilesVO> noticeFilesVOs)throws Exception;
	
}
