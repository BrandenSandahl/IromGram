package com.theironyard.services;

import com.theironyard.entities.Photo;
import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by branden on 3/15/16 at 11:22.
 */
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
    List<Photo> findAllByRecipient(User recipient);
}
