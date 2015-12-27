package com.mbrull.persistence.searchservice;

import java.util.List;

import com.mbrull.persistence.entities.User;

public interface UserSearchService {

    List<User> findBySimilarUsername(String username);

}
