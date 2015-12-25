package com.mbrull.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.util.Assert;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.mbrull.EmPersistenceMain;
import com.mbrull.entities.User;
import com.mbrull.test.IntegrationTest;

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
        assertThat(userEntry.get().getId(), is(1L));
    }

    @Test
    public void findOne_NoEntryFound() {
        Optional<User> userEntry = userRepository.findOne(100L);
        Assert.isTrue(!userEntry.isPresent());
    }
}
