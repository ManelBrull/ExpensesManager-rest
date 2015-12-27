package com.mbrull.persistence.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.mbrull.persistence.entities.User;
import com.mbrull.persistence.entities.User_;

public final class UserSpecifications {

    private UserSpecifications() {
    }

    public static Specification<User> usernameLike(String username) {
        String likePattern = getLikePattern(username);
          return (root, query, cb) -> { 
            return cb.like(root.<String> get(User_.username), likePattern);
        };
      }

    private static String getLikePattern(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return "%";
        }
        return "%" + searchTerm + "%";
    }

}
