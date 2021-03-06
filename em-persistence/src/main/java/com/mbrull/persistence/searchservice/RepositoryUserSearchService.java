package com.mbrull.persistence.searchservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.mbrull.persistence.entities.User;
import com.mbrull.persistence.repository.UserRepository;
import com.mbrull.persistence.specifications.UserSpecifications;

public class RepositoryUserSearchService implements UserSearchService {

    private final UserRepository repository;

    @Autowired
    public RepositoryUserSearchService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findBySimilarUsername(String username) {
        Specification<User> spec = UserSpecifications.usernameLike(username);
        List<User> entries = repository.findAll(spec);
        return entries;
    }

}
