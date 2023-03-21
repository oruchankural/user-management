package com.usermanagement.infrastructure.services.concrete;

import com.usermanagement.infrastructure.services.abstraction.IEmailGenerator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
@Repository
public class EmailGeneratorImpl implements IEmailGenerator {
    @Override
    public CompletableFuture<String> generateRandomEmail(int minUsernameLength, int maxUsernameLength) {

        final String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789_.-";
        final String[] domains = {"gmail.com","yahoo.com","hotmail.com"};

        return CompletableFuture.supplyAsync( () -> {
            ThreadLocalRandom randomizer = ThreadLocalRandom.current();
            StringBuilder stringBuilder = new StringBuilder();

            int length = randomizer.nextInt(maxUsernameLength - minUsernameLength + 1) + minUsernameLength;
            for (int i = 0; i < length; i++) {
                stringBuilder.append(allowedChars.charAt(randomizer.nextInt(allowedChars.length())));
            }
            stringBuilder.append("@");
            stringBuilder.append(domains[randomizer.nextInt(domains.length)]);
            return  stringBuilder.toString();
        });

    }
}
