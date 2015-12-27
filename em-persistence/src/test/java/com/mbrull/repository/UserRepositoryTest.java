package com.mbrull.repository;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.mbrull.commons.test.IntegrationTest;
import com.mbrull.persistence.EmPersistenceMain;
import com.mbrull.persistence.entities.User;
import com.mbrull.persistence.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/test.properties")
@SpringApplicationConfiguration(classes = EmPersistenceMain.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("/UserTestData.xml")
@Category(IntegrationTest.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findOne_OneEntryFound() {
        Optional<User> userEntry = userRepository.findOne(1L);
        assertThat(userEntry.isPresent(), is(true));
        assertThat(userEntry.get(), allOf(
                hasProperty("id", is(1L)),
                hasProperty("username", is("jgordon0")),
                hasProperty("email", is("sclark0@netvibes.com"))));
    }

    @Test
    public void findOne_NoEntryFound() {
        Optional<User> userEntry = userRepository.findOne(100L);
        assertThat(userEntry.isPresent(), is(false));
    }

    @Test
    public void findall_PageableRequest() {
        Page<User> userEntries = userRepository.findAll(new PageRequest(0, 2));
        assertThat(userEntries.getContent().size(), is(2));
    }
}
