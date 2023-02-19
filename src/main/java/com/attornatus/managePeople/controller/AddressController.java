package com.attornatus.managePeople.controller;

import com.attornatus.managePeople.dto.AddressDto;
import com.attornatus.managePeople.model.Address;
import com.attornatus.managePeople.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/person/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createdAddress(@RequestBody @Valid AddressDto addressDto) {
        Address savedAddress = addressService.createdAddress(addressDto.transfer(), addressDto.getPersonId());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Address>> listAddressPerson(@PathVariable("id")long id) {
        List<Address> addressList = addressService.listAddressPerson(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressList);
    }

    @GetMapping("/main/{id}")
    public ResponseEntity<Address> consultMainAddressPersonById(@PathVariable("id")long id) {
        Address consultMainAddress = addressService.mainAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(consultMainAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> editAddressPerson(@PathVariable("id")long id,
                                                     @RequestBody @Valid AddressDto addressDto) {
        Address editAddress = addressService.editAddressPerson(id,addressDto.transfer(),addressDto.getPersonId());
        return ResponseEntity.status(HttpStatus.OK).body(editAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity editAddressPerson(@PathVariable("id")long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

}
