package com.usermanagement.infrastructure.persistence;

import com.usermanagement.domain.entities.User;
import com.usermanagement.domain.repositories.abstraction.IUserRepository;
import com.usermanagement.infrastructure.services.abstraction.IEmailGenerator;
import com.usermanagement.infrastructure.services.abstraction.IPasswordGenerator;
import com.usermanagement.infrastructure.services.abstraction.IUserGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private  IUserGenerator userGenerator;
    @Autowired
    private  IPasswordGenerator passwordGenerator;
    @Autowired
    private  IEmailGenerator emailGenerator;


    private Map<UUID,User> users = new HashMap<>();

    @Override
    public CompletableFuture<List<User>> getAll() {

        return CompletableFuture.supplyAsync( () -> {
            List<User> generatedUsers = userGenerator.generateRandomUsers(3).join();
            for(User user : generatedUsers){
                user.Password = passwordGenerator.generateRandomPassword(10).join();
                user.Email = emailGenerator.generateRandomEmail(10,20).join();
            }
            generatedUsers.forEach(usr -> users.put(usr.Id,usr));
            return new ArrayList<>(users.values());
        });



    }

    @Override
    public CompletableFuture<User> getUserById(UUID id) {
        return CompletableFuture.supplyAsync( () -> {
            return users.get(id);
        });

    }

    @Override
    public void createUser(User user) {
        user.Id = UUID.randomUUID();
        users.put(user.Id,user);
    }

    @Override
    public void updateUser(User user) {
        if (users.containsKey(user.Id)) {
            users.put(user.Id, user);
        }
    }

    @Override
    public void deleteUser(UUID id) {
        if (users.containsKey(id)) {
            users.remove(id);
        }
    }
}
