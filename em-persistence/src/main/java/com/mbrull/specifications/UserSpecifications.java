package com.mbrull.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.mbrull.entities.User;
import com.mbrull.entities.User_;

public final class UserSpecifications {

    private UserSpecifications() {
    }

    public static Specification<User> usernameLike(String username) {
          return (root, query, cb) -> { 
              return cb.like(root.get(User_.username), username); 
        };
      }

}
