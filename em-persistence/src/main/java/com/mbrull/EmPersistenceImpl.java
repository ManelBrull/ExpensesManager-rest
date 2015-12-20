package com.mbrull;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbrull.entities.User;
import com.mbrull.repository.UserRepository;
import com.mbrull.searchservice.UserSearchService;

public class EmPersistenceImpl implements EmPersistence {

    private final UserRepository repository;
    private final UserSearchService searchService;

    @Autowired
    public EmPersistenceImpl(UserRepository repository, UserSearchService searchService) {
        this.repository = repository;
        this.searchService = searchService;
    }

    public Long countUsers() {
        return repository.count();
    }

    public Optional<User> getUser(Long id) {
        return repository.findById(id);
    }

    public List<User> findUsersWithSimiliarUsername(String username) {
        List<User> entries = searchService.findBySimilarUsername(username);
        return entries;
    }

    public void createUser(User user) {
        if (repository.findByUsernameIgnoreCase(user.getUsername()).isPresent()) {
            return;
        }
        repository.save(user);
    }

    public Page<User> getUsers(Pageable pageRequest) {
        return repository.findAll(pageRequest);
    }
}
