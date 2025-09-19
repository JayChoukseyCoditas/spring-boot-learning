package com.example.liquibase.controller;

import com.example.liquibase.Entity.Person;
import com.example.liquibase.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class DemoController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("person")
    public String createPerson(@RequestParam String name){
        personRepository.save(new Person(name, "6.7"));

        return personRepository.findByName(name) + "Saved successfully";
    }

    @GetMapping("person")
    public List<Person> getAllPeople(){
        return (List<Person>) personRepository.findAll();
    }

}
