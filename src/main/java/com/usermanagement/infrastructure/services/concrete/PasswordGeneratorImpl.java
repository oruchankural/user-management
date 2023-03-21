package com.usermanagement.infrastructure.services.concrete;

import com.usermanagement.infrastructure.services.abstraction.IPasswordGenerator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Repository
public class PasswordGeneratorImpl implements IPasswordGenerator {
    @Override
    public CompletableFuture<String> generateRandomPassword(int lengthOfPassword) {
        final String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return CompletableFuture.supplyAsync( () -> {
            Random random = new Random();
            StringBuilder stringBuilder = new StringBuilder(lengthOfPassword);
            for (int i = 0 ; i <lengthOfPassword;i++){
                stringBuilder.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
            }
            return stringBuilder.toString();
        });
    }
}
