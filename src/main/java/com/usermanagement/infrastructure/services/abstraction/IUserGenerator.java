package com.usermanagement.infrastructure.services.abstraction;
import com.usermanagement.domain.entities.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public interface IUserGenerator {
    CompletableFuture<List<User>> generateRandomUsers(int userCount);
}
