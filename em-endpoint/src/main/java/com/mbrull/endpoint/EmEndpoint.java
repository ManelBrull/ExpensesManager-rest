package com.mbrull.endpoint;

import com.mbrull.persistence.entities.User;

public interface EmEndpoint {

    public void createUser(User userToCreate);

}
