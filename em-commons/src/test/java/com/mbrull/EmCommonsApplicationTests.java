package com.mbrull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mbrull.commons.EmCommonsApplication;
import com.mbrull.commons.test.IntegrationTest;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EmCommonsApplication.class)
@WebAppConfiguration
@Category(IntegrationTest.class)
public class EmCommonsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
