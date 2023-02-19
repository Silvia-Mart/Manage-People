package com.attornatus.managePeople.service;

import com.attornatus.managePeople.exception.EntityException;
import com.attornatus.managePeople.model.Person;
import com.attornatus.managePeople.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public Person editPersonData(Long id,Person person) {
        person.setId(id);
        return personRepository.save(person);
    }

    @Transactional
    public Person consultPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        }else{
            throw new EntityException("Id person not found!");
        }
    }

    @Transactional
    public List<Person> listPerson() {
        return personRepository.findAll();
    }

    @Transactional
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }
}
