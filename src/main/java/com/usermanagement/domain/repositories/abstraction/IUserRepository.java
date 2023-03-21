package com.usermanagement.domain.repositories.abstraction;

import com.usermanagement.domain.entities.User;


import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;


public interface IUserRepository {
    CompletableFuture<List<User>> getAll();
    CompletableFuture<User> getUserById(UUID id);
    void createUser(User user);
    void  updateUser(User user);
    void deleteUser(UUID id);


}
