package com.attornatus.managePeople.service;

import com.attornatus.managePeople.exception.EntityException;
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
            Address addressMain = addressRepository.findByPersonIdAndIsMainAddress(id, true);
            if(addressMain==null || address.isMainAddress() == false) {
                return addressRepository.save(address);
            }else{
                throw new EntityException("Existing primary address!");
            }
        }

        throw new EntityException("Id person not found!");
    }

    @Transactional
    public List<Address> listAddressPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()){
            Person person = optionalPerson.get();
            List<Address> personAddress = person.getAddress();
            return personAddress;
        }
        throw new EntityException("Id person not found!");
    }

    @Transactional
    public Address mainAddress(Long id) {
        return addressRepository.findByPersonIdAndIsMainAddress(id, true);
    }

    @Transactional
    public Address editAddressPerson(Long id, Address address,Long idPerson) {
        Optional<Person> optionalPerson = personRepository.findById(idPerson);
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalPerson.isPresent()){
            if(optionalAddress.isPresent()){
                Person person = optionalPerson.get();
                address.setId(id);
                address.setPerson(person);
                return addressRepository.save(address);
            }else{
                throw new EntityException("Address not found!");
            }
        }
        throw new EntityException("Person not found!");
    }

    @Transactional
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
