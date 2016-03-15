package com.theironyard.services;

import com.theironyard.entities.Photo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by branden on 3/15/16 at 11:22.
 */
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
