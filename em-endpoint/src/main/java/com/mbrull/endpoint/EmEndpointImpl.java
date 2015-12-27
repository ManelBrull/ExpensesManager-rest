package com.mbrull.endpoint;

import org.springframework.beans.factory.annotation.Autowired;

import com.mbrull.core.EmCore;
import com.mbrull.core.dto.UserDTO;

public class EmEndpointImpl implements EmEndpoint {

    private final EmCore core;

    @Autowired
    public EmEndpointImpl(EmCore core) {
        this.core = core;
    }

    public void createUser(UserDTO userToCreate) {
        core.createUser(userToCreate);
    }

}
