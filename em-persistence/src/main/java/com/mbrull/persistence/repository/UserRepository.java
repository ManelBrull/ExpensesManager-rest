package com.mbrull.persistence.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mbrull.persistence.entities.User;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    Optional<User> findByUsernameIgnoreCase(String username);

}