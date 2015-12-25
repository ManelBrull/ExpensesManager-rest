package com.mbrull.repository;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;
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
import com.mbrull.EmPersistenceMain;
import com.mbrull.entities.Category;
import com.mbrull.entities.Subcategory;
import com.mbrull.test.IntegrationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/test.properties")
@SpringApplicationConfiguration(classes = EmPersistenceMain.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("/CategoriesData.xml")
@org.junit.experimental.categories.Category(IntegrationTest.class)
public class CategoriesRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubcategoryRepository subCategoryRepository;

    @Test
    public void findOne_OneCategoryFound() {
        Optional<Category> entry = categoryRepository.findOne(1L);
        assertThat(entry.isPresent(), is(true));
        assertThat(entry.get(), allOf(
                hasProperty("id", is(1L)),
                hasProperty("name", is("Survival"))));
    }
    
    @Test
    public void findOne_OneSubCategoryFound() {
        Optional<Subcategory> entry = subCategoryRepository.findOne(1L);
        assertThat(entry.isPresent(), is(true));
        assertThat(entry.get(), allOf(hasProperty("id", is(1L)), hasProperty("name", is("Grorceries"))));
        assertThat(entry.get().getCategory(), allOf(hasProperty("id", is(1L)), hasProperty("name", is("Survival"))));
    }
    
}
