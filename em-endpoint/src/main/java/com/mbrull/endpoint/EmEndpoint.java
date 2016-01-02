package com.mbrull.endpoint;

import com.mbrull.core.dto.UserDTO;

public interface EmEndpoint {

    public long createUser(UserDTO userToCreate);

    public UserDTO getUser(Long id);

}
