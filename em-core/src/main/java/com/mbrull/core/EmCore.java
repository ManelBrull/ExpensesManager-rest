package com.mbrull.core;

import com.mbrull.core.dto.UserDTO;

public interface EmCore {

    public long createUser(UserDTO userToCreate);

    public UserDTO getUser(Long id);

}
