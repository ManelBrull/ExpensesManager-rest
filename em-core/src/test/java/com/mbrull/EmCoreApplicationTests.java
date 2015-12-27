package com.mbrull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mbrull.commons.test.IntegrationTest;
import com.mbrull.core.EmCoreApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/test.properties")
@SpringApplicationConfiguration(classes = EmCoreApplication.class)
@WebAppConfiguration
@Category(IntegrationTest.class)
public class EmCoreApplicationTests {

	@Test
	public void contextLoads() {
	}

}
