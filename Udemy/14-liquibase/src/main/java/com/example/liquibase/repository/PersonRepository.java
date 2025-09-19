package com.example.liquibase.repository;

import com.example.liquibase.Entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("SELECT name FROM Person p WHERE p.name LIKE %:personName")
    String findByName(String personName);
}
