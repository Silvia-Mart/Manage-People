package com.attornatus.managePeople.repository;

import com.attornatus.managePeople.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
