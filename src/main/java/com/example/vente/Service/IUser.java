package com.example.vente.Service;

import com.example.vente.Entity.UserEntity;
import com.example.vente.request.user.createUserReq;
import com.example.vente.request.user.updateUserReq;

import java.util.Optional;

public interface IUser {
    UserEntity save(createUserReq user);
    void delete(int id);
    Optional<UserEntity> getUser(int id);
    UserEntity update(updateUserReq user);

}
