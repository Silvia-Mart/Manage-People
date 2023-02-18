package com.attornatus.managePeople.service;

import com.attornatus.managePeople.model.Address;
import com.attornatus.managePeople.model.Person;
import com.attornatus.managePeople.repository.AddressRepository;
import com.attornatus.managePeople.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public Address createdAddress(Address address, Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()){
            Person person = optionalPerson.get();
            address.setPerson(person);
            return addressRepository.save(address);
        }

        throw new RuntimeException("errro");
    }

    @Transactional
    public List<Address> listAddressPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()){
            Person person = optionalPerson.get();
            List<Address> personAddress = person.getAddress();
            return personAddress;
        }
        throw new RuntimeException("errro");
    }

    @Transactional
    public Address mainAddress(Long id) {
        return addressRepository.findByPersonIdAndIsMainAddress(id, true);
    }

    @Transactional
    public Address editAddressPerson(Long id, Address address,Long idPerson) {
        Optional<Person> optionalPerson = personRepository.findById(idPerson);
        if(optionalPerson.isPresent()){
            Person person = optionalPerson.get();
            address.setId(id);
            address.setPerson(person);
            return addressRepository.save(address);
        }
        throw new RuntimeException("errro");
    }

    @Transactional
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}