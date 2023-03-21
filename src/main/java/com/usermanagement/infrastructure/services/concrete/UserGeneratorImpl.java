package com.usermanagement.infrastructure.services.concrete;
import com.usermanagement.domain.entities.User;
import com.usermanagement.infrastructure.services.abstraction.IUserGenerator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Repository
public class UserGeneratorImpl implements IUserGenerator {
    @Override
    public CompletableFuture<List<User>> generateRandomUsers(int userCount) {
        return CompletableFuture.supplyAsync( () -> {
            List<User> generatedUsers = new ArrayList<>();
            Random random = new Random();
            for(int i = 1 ; i < userCount + 1 ; i++){
                User user = new User();
                user.Email = String.format("han%d@gmail.com",i);
                user.Id = UUID.randomUUID();
                user.FirstName = String.format("Han - %d",i);
                user.LastName = String.format("Kural - %d",i);
                user.Password = String.format("%d.%d-%d",i,i + 1,(i + 1) * (i + 2));
                user.Salary = 1000 + random.nextDouble() * (5000 - 1000);
                generatedUsers.add(user);
            }
            return generatedUsers;
        });
    }
}
