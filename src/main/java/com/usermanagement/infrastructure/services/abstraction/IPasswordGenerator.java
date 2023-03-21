package com.usermanagement.infrastructure.services.abstraction;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


public interface IPasswordGenerator {

    CompletableFuture<String> generateRandomPassword(int lengthOfPassword);
}
