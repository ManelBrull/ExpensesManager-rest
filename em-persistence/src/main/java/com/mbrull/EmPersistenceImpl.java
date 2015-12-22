package com.mbrull;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbrull.entities.Category;
import com.mbrull.entities.SubCategory;
import com.mbrull.entities.User;
import com.mbrull.repository.CategoryRepository;
import com.mbrull.repository.ExpenseRepository;
import com.mbrull.repository.SubCategoryRepository;
import com.mbrull.repository.UserRepository;
import com.mbrull.searchservice.UserSearchService;

public class EmPersistenceImpl implements EmPersistence {

    private final UserRepository userRepository;
    private final UserSearchService searchService;
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final ExpenseRepository expenseRepository;

    @Autowired
    public EmPersistenceImpl(UserRepository repository, UserSearchService searchService,
            CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository,
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

    public void createUser(User user) {
        if (userRepository.findByUsernameIgnoreCase(user.getUsername()).isPresent()) {
            return;
        }
        userRepository.save(user);
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

        
        SubCategory grorceries = new SubCategory("Grorceries", survival);
        SubCategory health = new SubCategory("Health", survival);
        SubCategory transport = new SubCategory("Transport", survival);

        subCategoryRepository.save(grorceries);
        subCategoryRepository.save(health);
        subCategoryRepository.save(transport);

        SubCategory bar = new SubCategory("Bars", leisureAndVice);
        SubCategory restaurants = new SubCategory("Restaurants", leisureAndVice);
        SubCategory fastFood = new SubCategory("Fast food", leisureAndVice);
        SubCategory party = new SubCategory("Party", leisureAndVice);
        SubCategory tobacco = new SubCategory("Tobacco", leisureAndVice);
        SubCategory alcohol = new SubCategory("Alcohol", leisureAndVice);
        SubCategory clothes = new SubCategory("Clothes", leisureAndVice);

        subCategoryRepository.save(bar);
        subCategoryRepository.save(restaurants);
        subCategoryRepository.save(fastFood);
        subCategoryRepository.save(party);
        subCategoryRepository.save(tobacco);
        subCategoryRepository.save(alcohol);
        subCategoryRepository.save(clothes);

        SubCategory books = new SubCategory("Books", culture);
        SubCategory music = new SubCategory("Music", culture);
        SubCategory shows = new SubCategory("Shows", culture);

        subCategoryRepository.save(books);
        subCategoryRepository.save(music);
        subCategoryRepository.save(shows);

        SubCategory travel = new SubCategory("Travel", extras);
        SubCategory gift = new SubCategory("Gift", extras);
        SubCategory home = new SubCategory("Home", extras);

        subCategoryRepository.save(travel);
        subCategoryRepository.save(gift);
        subCategoryRepository.save(home);
    }
}
