package com.mbrull.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbrull.persistence.entities.User;

public interface EmPersistence {

    public long createUser(User user);

    public Page<User> getUsers(Pageable pageRequest);

    public void initDatabase();

    public Long countUsers();

    public Optional<User> getUser(Long id);

    public List<User> findUsersWithSimiliarUsername(String username);

}
