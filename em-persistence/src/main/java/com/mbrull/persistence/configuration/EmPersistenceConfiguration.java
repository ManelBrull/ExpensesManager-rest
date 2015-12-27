package com.mbrull.persistence.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mbrull.persistence.EmPersistence;
import com.mbrull.persistence.EmPersistenceImpl;
import com.mbrull.persistence.repository.CategoryRepository;
import com.mbrull.persistence.repository.ExpenseRepository;
import com.mbrull.persistence.repository.SubcategoryRepository;
import com.mbrull.persistence.repository.UserRepository;
import com.mbrull.persistence.searchservice.RepositoryUserSearchService;
import com.mbrull.persistence.searchservice.UserSearchService;

@Configuration
public class EmPersistenceConfiguration {

    @Bean
    public UserSearchService repositoryUserSearchService(UserRepository repository) {
        return new RepositoryUserSearchService(repository);
    }

    @Bean
    public EmPersistence emPersistenceImpl(UserRepository repository, UserSearchService searchService,
            CategoryRepository categoryRepository, SubcategoryRepository subCategoryRepository,
            ExpenseRepository expenseRepository) {

        return new EmPersistenceImpl(repository, searchService, categoryRepository, subCategoryRepository,
                expenseRepository);
    }

}
