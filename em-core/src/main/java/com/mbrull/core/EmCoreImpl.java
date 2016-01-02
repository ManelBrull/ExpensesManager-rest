package com.mbrull.core;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mbrull.core.dto.UserDTO;
import com.mbrull.persistence.EmPersistence;
import com.mbrull.persistence.entities.User;

public class EmCoreImpl implements EmCore {

    private final EmPersistence persistence;

    @Autowired
    public EmCoreImpl(EmPersistence persistence) {
        this.persistence = persistence;
    }

    public long createUser(UserDTO userToCreate) {
        User user = toUserFrom(userToCreate);
        long idUser = persistence.createUser(user);
        return idUser;
    }

    public UserDTO getUser(Long id) {
        Optional<User> entity = persistence.getUser(id);
        if (!entity.isPresent()) {
            // TODO: Throw exception resource do not exists?
            throw new RuntimeException("user does not exists");
        } else {
            return toUserDTOFrom(entity.get());
        }
    }

    private User toUserFrom(UserDTO userDto) {
        return new User(userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
    }

    private UserDTO toUserDTOFrom(User user) {
        UserDTO dto = new UserDTO();
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setPassword("");
        return dto;
    }
}
