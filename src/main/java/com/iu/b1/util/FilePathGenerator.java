package com.iu.b1.util;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FilePathGenerator {

	@Autowired
	private ServletContext servletContext;
	@Autowired
	private ResourceLoader resourceLoader;
	
	public File getUseClassPathResource(String filepath)throws Exception{
		//classPath경로를 받아오기 위해 사용
		//시작 경로의 classPath 구문은 삭제된다.
		//나머지는 resourceLoader와 같다.
		String path="/static/";
		ClassPathResource classPathResource=new ClassPathResource(path);
		File file= new File(classPathResource.getFile(),filepath);
		if(!file.exists()) {
			file.mkdirs();
		}
		System.out.println(file.getAbsolutePath()); 
		return file;
	}
	public File getUseResourceLoader(String filePath) throws Exception{
		String path="classpath:/static/";
		File file=new File(resourceLoader.getResource(path).getFile(), filePath);
		//ResourceLoader는 classpath 경로를 받아오기 위해 사용
		//생성하려는 폴더가 없으면 에러 발생
		//static 경로를 이용해서 file 객체 생성하고
		//하위 폴더를(child) 사용해서 디렉토리 폴더생성 
		if(!file.exists()) {
			file.mkdirs();
		}
		return file;
	}
	
	private File getServletContext() {
		String filePath=servletContext.getRealPath("upload");
		//System.out.println(filePath);
		File file=new File(filePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		return file;
	}
	
}
