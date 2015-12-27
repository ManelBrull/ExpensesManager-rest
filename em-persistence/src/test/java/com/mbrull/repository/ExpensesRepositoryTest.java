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

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.mbrull.commons.test.IntegrationTest;
import com.mbrull.persistence.EmPersistenceMain;
import com.mbrull.persistence.entities.Expense;
import com.mbrull.persistence.repository.ExpenseRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/test.properties")
@SpringApplicationConfiguration(classes = EmPersistenceMain.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("/ExpensesData.xml")
@Category(IntegrationTest.class)
public class ExpensesRepositoryTest {

    @Autowired
    private ExpenseRepository repository;

    @Test
    public void findOne_OneExpenseFound() {
        Optional<Expense> entry = repository.findOne(1L);
        assertThat(entry.isPresent(), is(true));
    }

    @Test
    public void findOne_OneExpenseNotFound() {
        Optional<Expense> entry = repository.findOne(100L);
        assertThat(entry.isPresent(), is(false));
    }

}
