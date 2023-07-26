package com.cpan228.clothes_warehouse.repository;

import com.cpan228.clothes_warehouse.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
