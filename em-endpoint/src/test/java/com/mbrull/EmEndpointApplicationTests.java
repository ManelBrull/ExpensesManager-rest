package com.mbrull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mbrull.commons.test.IntegrationTest;
import com.mbrull.endpoint.EmEndpointApplicationMain;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EmEndpointApplicationMain.class)
@WebAppConfiguration
@Category(IntegrationTest.class)
public class EmEndpointApplicationTests {

	@Test
	public void contextLoads() {
	}

}
