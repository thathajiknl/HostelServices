package com.tss.sessionmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tss.hostelmanagement.HostelManagementServicesApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HostelManagementServicesApplication.class)
@WebAppConfiguration
public class HostelManagementServicesApplicationTests {

	@Test
	public void contextLoads() {
	}

}
