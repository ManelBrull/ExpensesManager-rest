package com.mbrull.endpoint.rest;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.mbrull.TestUtils;
import com.mbrull.commons.test.UnitTest;
import com.mbrull.core.EmCore;
import com.mbrull.core.EmCoreImpl;
import com.mbrull.core.dto.UserDTO;
import com.mbrull.endpoint.EmEndpointApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/test.properties")
@SpringApplicationConfiguration(classes = EmEndpointApplication.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@WebAppConfiguration
@Category(UnitTest.class)
public class UserRestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private EmCore mockCoreImpl = mock(EmCoreImpl.class);
    private TestUtils testUtils = new TestUtils();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void assertContextIsWorking() {
        Assert.isTrue(true);
    }

    @Test
    public void createUser_created() throws Exception {

        UserDTO user = testUtils.generateValidUserDTO();
        doNothing().when(mockCoreImpl).createUser(user);
        mockMvc.perform(
                post("/user/create").contentType(MediaType.APPLICATION_JSON_UTF8).content(testUtils.toJson(user)))
                .andExpect(status().is(HttpStatus.CREATED.value()));
        verify(mockCoreImpl, times(1)).createUser(user);
        verifyNoMoreInteractions(mockCoreImpl);

    }



}
