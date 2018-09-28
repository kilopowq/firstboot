package com.kilopo.kwitter.repository;

import com.kilopo.kwitter.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
