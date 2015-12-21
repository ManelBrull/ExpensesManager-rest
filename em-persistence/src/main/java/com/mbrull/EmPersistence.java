package com.mbrull;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbrull.entities.User;

public interface EmPersistence {

    public Long countUsers();

    public Optional<User> getUser(Long id);

    public List<User> findUsersWithSimiliarUsername(String username);

    public void createUser(User user);

    public Page<User> getUsers(Pageable pageRequest);

    public void initDatabase();

}
