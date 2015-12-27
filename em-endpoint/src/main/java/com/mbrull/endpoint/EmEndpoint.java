package com.mbrull.endpoint;

import com.mbrull.core.dto.UserDTO;

public interface EmEndpoint {

    public void createUser(UserDTO userToCreate);

}
