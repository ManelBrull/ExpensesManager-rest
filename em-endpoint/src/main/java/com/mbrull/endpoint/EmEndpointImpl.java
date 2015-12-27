package com.mbrull.endpoint;

import org.springframework.beans.factory.annotation.Autowired;

import com.mbrull.core.EmCore;
import com.mbrull.persistence.entities.User;

public class EmEndpointImpl implements EmEndpoint {

    private final EmCore core;

    @Autowired
    public EmEndpointImpl(EmCore core) {
        this.core = core;
    }

    public void createUser(User userToCreate) {
        core.createUser(userToCreate);
    }

}
