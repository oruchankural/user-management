package com.usermanagement.infrastructure.services.abstraction;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


public interface IEmailGenerator {

    CompletableFuture<String> generateRandomEmail(int minUsernameLength , int maxUsernameLength);
}
