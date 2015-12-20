package com.mbrull.searchservice;

import java.util.List;

import com.mbrull.entities.User;

public interface UserSearchService {

    List<User> findBySimilarUsername(String username);

}
