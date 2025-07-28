package org.example.repository;

import org.example.entity.jpa.Example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ExampleRepository extends CrudRepository<Example, Long> {
    List<Example> findByMessage(String message);
    Example findById(long id);
}
