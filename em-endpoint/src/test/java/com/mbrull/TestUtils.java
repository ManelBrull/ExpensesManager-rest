package com.mbrull;

import com.google.gson.Gson;
import com.mbrull.core.dto.UserDTO;

public class TestUtils {

    public UserDTO generateValidUserDTO() {
        UserDTO user = new UserDTO();
        user.setEmail("jjohnston2@latimes.com");
        user.setPassword("229990378-X");
        user.setUsername("jsimmons2");
        return user;
    }

    public String toJson(UserDTO user) {
        Gson gson = new Gson();
        return gson.toJson(user);
    }

}
