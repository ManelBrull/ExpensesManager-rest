package com.mbrull.core;

import org.springframework.beans.factory.annotation.Autowired;

import com.mbrull.persistence.EmPersistence;
import com.mbrull.persistence.entities.User;

public class EmCoreImpl implements EmCore {

    private final EmPersistence persistence;

    @Autowired
    public EmCoreImpl(EmPersistence persistence) {
        this.persistence = persistence;
    }

    public void createUser(User userToCreate) {
        persistence.createUser(userToCreate);
    }

}
