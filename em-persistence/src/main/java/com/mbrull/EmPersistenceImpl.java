package com.mbrull;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.mbrull.entities.User;
import com.mbrull.repository.UserRepository;
import com.mbrull.specifications.UserSpecifications;

public class EmPersistenceImpl implements EmPersistence {

    @Autowired
    UserRepository repository;

    public Long countUsers() {
        return repository.count();
    }

    public Optional<User> getUser(Long id) {
        return repository.findById(id);
    }

    public List<User> findUsersWithSimiliarUsername(String username) {
        Specification<User> spec = UserSpecifications.usernameLike(username);
        List<User> entries = repository.findAll(spec);
        return entries;
    }

    public void createUser(User user) {
        if (repository.findByUsernameIgnoreCase(user.getUsername()).isPresent()) {
            return;
        }
        repository.save(user);
    }
}
