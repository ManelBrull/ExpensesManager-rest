package com.mbrull.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbrull.persistence.entities.Category;
import com.mbrull.persistence.entities.Subcategory;
import com.mbrull.persistence.entities.User;
import com.mbrull.persistence.repository.CategoryRepository;
import com.mbrull.persistence.repository.ExpenseRepository;
import com.mbrull.persistence.repository.SubcategoryRepository;
import com.mbrull.persistence.repository.UserRepository;
import com.mbrull.persistence.searchservice.UserSearchService;

public class EmPersistenceImpl implements EmPersistence {

    private final UserRepository userRepository;
    private final UserSearchService searchService;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subCategoryRepository;
    private final ExpenseRepository expenseRepository;

    @Autowired
    public EmPersistenceImpl(UserRepository repository, UserSearchService searchService,
            CategoryRepository categoryRepository, SubcategoryRepository subCategoryRepository,
            ExpenseRepository expenseRepository) {

        this.userRepository = repository;
        this.searchService = searchService;
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.expenseRepository = expenseRepository;
    }

    public Long countUsers() {
        return userRepository.count();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findOne(id);
    }

    public List<User> findUsersWithSimiliarUsername(String username) {
        List<User> entries = searchService.findBySimilarUsername(username);
        return entries;
    }

    public long createUser(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public Page<User> getUsers(Pageable pageRequest) {
        return userRepository.findAll(pageRequest);
    }

    public void initDatabase() {
        Category survival = new Category("Survival");
        Category leisureAndVice = new Category("Leisure and vice");
        Category culture = new Category("Culture");
        Category extras = new Category("Extras");

        categoryRepository.save(survival);
        categoryRepository.save(leisureAndVice);
        categoryRepository.save(culture);
        categoryRepository.save(extras);

        
        Subcategory grorceries = new Subcategory("Grorceries", survival);
        Subcategory health = new Subcategory("Health", survival);
        Subcategory transport = new Subcategory("Transport", survival);

        subCategoryRepository.save(grorceries);
        subCategoryRepository.save(health);
        subCategoryRepository.save(transport);

        Subcategory bar = new Subcategory("Bars", leisureAndVice);
        Subcategory restaurants = new Subcategory("Restaurants", leisureAndVice);
        Subcategory fastFood = new Subcategory("Fast food", leisureAndVice);
        Subcategory party = new Subcategory("Party", leisureAndVice);
        Subcategory tobacco = new Subcategory("Tobacco", leisureAndVice);
        Subcategory alcohol = new Subcategory("Alcohol", leisureAndVice);
        Subcategory clothes = new Subcategory("Clothes", leisureAndVice);

        subCategoryRepository.save(bar);
        subCategoryRepository.save(restaurants);
        subCategoryRepository.save(fastFood);
        subCategoryRepository.save(party);
        subCategoryRepository.save(tobacco);
        subCategoryRepository.save(alcohol);
        subCategoryRepository.save(clothes);

        Subcategory books = new Subcategory("Books", culture);
        Subcategory music = new Subcategory("Music", culture);
        Subcategory shows = new Subcategory("Shows", culture);

        subCategoryRepository.save(books);
        subCategoryRepository.save(music);
        subCategoryRepository.save(shows);

        Subcategory travel = new Subcategory("Travel", extras);
        Subcategory gift = new Subcategory("Gift", extras);
        Subcategory home = new Subcategory("Home", extras);

        subCategoryRepository.save(travel);
        subCategoryRepository.save(gift);
        subCategoryRepository.save(home);
    }
}
