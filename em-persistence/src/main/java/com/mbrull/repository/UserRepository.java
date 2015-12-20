package com.mbrull.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mbrull.entities.User;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    Optional<User> findByUsernameIgnoreCase(String username);

    Optional<User> findById(Long id);

}