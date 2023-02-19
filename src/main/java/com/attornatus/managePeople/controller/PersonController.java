package com.attornatus.managePeople.controller;

import com.attornatus.managePeople.dto.PersonDto;
import com.attornatus.managePeople.model.Person;
import com.attornatus.managePeople.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody @Valid PersonDto personDto) {
        Person savedPerson = personService.createPerson(personDto.transfer());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> editPersonData(@PathVariable("id")long id, @RequestBody @Valid PersonDto personUpdated) {
        Person editData = personService.editPersonData(id,personUpdated.transfer());
        return ResponseEntity.status(HttpStatus.OK).body(editData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> consultPersonById(@PathVariable("id")long id) {
        Person consultPerson = personService.consultPersonById(id);
        return ResponseEntity.status(HttpStatus.OK).body(consultPerson);
    }

    @GetMapping
    public ResponseEntity<List<Person>> listPerson() {
        List<Person> listPersonAll = personService.listPerson();
        return ResponseEntity.status(HttpStatus.OK).body(listPersonAll);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePersonById(@PathVariable("id")long id) {
        personService.deletePersonById(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

}
