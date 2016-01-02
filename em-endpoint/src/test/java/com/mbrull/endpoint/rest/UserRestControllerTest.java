package com.mbrull.endpoint.rest;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
import com.mbrull.MatcherDTO;
import com.mbrull.TestUtils;
import com.mbrull.commons.test.UnitTest;
import com.mbrull.core.EmCore;
import com.mbrull.core.dto.UserDTO;
import com.mbrull.endpoint.EmEndpointApplication;
import com.mbrull.endpoint.EmEndpointImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/test.properties")
@SpringApplicationConfiguration(classes = EmEndpointApplication.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@WebAppConfiguration
@Category(UnitTest.class)
public class UserRestControllerTest {

    private EmCore core;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private EmEndpointImpl emEndpointImpl;
    private MockMvc mockMvc;
    private TestUtils testUtils = new TestUtils();

    @Before
    public void setup()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        setupCoreMock();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    private void setupCoreMock()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        this.core = mock(EmCore.class);
        Field toMock = emEndpointImpl.getClass().getDeclaredField("core");
        toMock.setAccessible(true);
        toMock.set(emEndpointImpl, core);
    }

    @Test
    public void assertContextIsWorking() {
        Assert.isTrue(true);
    }

    @Test
    public void createUser_created() throws Exception {

        UserDTO user = testUtils.generateValidUserDTO();
        doNothing().when(core).createUser(user);
        mockMvc.perform(
post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(testUtils.toJson(user)))
                .andExpect(status().is(HttpStatus.CREATED.value()));

        verify(core, times(1)).createUser(Mockito.argThat(MatcherDTO.getUserMatcher(user)));
        verifyNoMoreInteractions(core);

    }

    @Test
    public void createUser_nullemail() throws Exception {

        UserDTO user = testUtils.generateValidUserDTO();
        user.setEmail(null);
        mockMvc.perform(
post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(testUtils.toJson(user)))
                .andExpect(status().is(HttpStatus.UNPROCESSABLE_ENTITY.value()));
        verify(core, never()).createUser(user);
        verifyNoMoreInteractions(core);

    }

    @Test
    public void createUser_nullUsername() throws Exception {

        UserDTO user = testUtils.generateValidUserDTO();
        user.setUsername(null);
        mockMvc.perform(
post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(testUtils.toJson(user)))
                .andExpect(status().is(HttpStatus.UNPROCESSABLE_ENTITY.value()));
        verify(core, never()).createUser(user);
        verifyNoMoreInteractions(core);

    }

    @Test
    public void createUser_nullPassword() throws Exception {

        UserDTO user = testUtils.generateValidUserDTO();
        user.setPassword(null);
        mockMvc.perform(
post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(testUtils.toJson(user)))
                .andExpect(status().is(HttpStatus.UNPROCESSABLE_ENTITY.value()));
        verify(core, never()).createUser(user);
        verifyNoMoreInteractions(core);

    }

}
