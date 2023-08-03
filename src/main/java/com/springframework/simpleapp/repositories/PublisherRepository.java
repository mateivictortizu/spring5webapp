package com.springframework.simpleapp.repositories;

import com.springframework.simpleapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
