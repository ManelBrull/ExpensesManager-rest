package com.mbrull.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mbrull.EmPersistence;
import com.mbrull.EmPersistenceImpl;
import com.mbrull.repository.CategoryRepository;
import com.mbrull.repository.ExpenseRepository;
import com.mbrull.repository.SubCategoryRepository;
import com.mbrull.repository.UserRepository;
import com.mbrull.searchservice.RepositoryUserSearchService;
import com.mbrull.searchservice.UserSearchService;

@Configuration
public class EmPersistenceConfiguration {

    @Bean
    public UserSearchService repositoryUserSearchService(UserRepository repository) {
        return new RepositoryUserSearchService(repository);
    }

    @Bean
    public EmPersistence emPersistenceImpl(UserRepository repository, UserSearchService searchService,
            CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository,
            ExpenseRepository expenseRepository) {

        return new EmPersistenceImpl(repository, searchService, categoryRepository, subCategoryRepository,
                expenseRepository);
    }

}
