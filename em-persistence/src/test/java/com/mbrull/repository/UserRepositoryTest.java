package com.mbrull.repository;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.util.Assert;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.mbrull.configuration.PersistenceContext;
import com.mbrull.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceContext.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("UserTestData.xml")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findOne_OneEntryFound() {
        Optional<User> userEntry = userRepository.findOne(1L);
        Assert.isTrue(userEntry.isPresent());
        assertThat(userEntry.get(), allOf(
            hasProperty("id", is(1L)),
            hasProperty("username", is("jgordon0")),
                hasProperty("email", is("sclark0@netvibes.com"))
        ));
    }

    @Test
    public void findOne_NoEntryFound() {
        Optional<User> userEntry = userRepository.findOne(100L);
        Assert.isTrue(!userEntry.isPresent());
    }
}
