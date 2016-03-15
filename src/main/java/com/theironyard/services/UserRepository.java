package com.theironyard.services;

import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by branden on 3/15/16 at 11:21.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}
