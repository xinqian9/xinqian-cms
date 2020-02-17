package com.xinqian.cms.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xinqian.cms.domain.Collect;
import com.xinqian.cms.service.CollectService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class CollectServiceImplTest {
	@Autowired
	private CollectService collectService;
	@Test
	public void testIsHttpUrl() {
		Collect collect = new Collect(1, "sdsd", "adssx", 124, new Date());
		collectService.isHttpUrl(collect);
		
		
		
	}

	@Test
	public void testDesc() {
		fail("Not yet implemented");
	}

}
