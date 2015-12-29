package com.mbrull;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.mbrull.core.dto.UserDTO;

public class MatcherDTO {

    private MatcherDTO() {
    }

    public static Matcher<UserDTO> getUserMatcher(UserDTO user) {
        return Matchers.allOf(hasProperty("username", is(user.getUsername())),
                hasProperty("email", is(user.getEmail())), hasProperty("password", is(user.getPassword())));
    }
}
