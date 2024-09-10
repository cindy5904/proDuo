package org.example.authentificationservice.repository;

import org.example.authentificationservice.entity.UserApp;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAppRepository extends CrudRepository<UserApp, Long> {
    Optional<UserApp> findByEmail(String email);
}
