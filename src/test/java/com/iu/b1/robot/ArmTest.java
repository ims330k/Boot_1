package com.iu.b1.robot;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.head.Header;

@SpringBootTest
class ArmTest {

	@Autowired
	private Header header;
	
	@Test
	void test() throws Exception {
		assertNotNull(header);
	}

}
