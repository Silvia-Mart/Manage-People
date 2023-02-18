package com.attornatus.managePeople.dto;

import com.attornatus.managePeople.model.Address;

import javax.validation.constraints.NotBlank;

public class AddressDto {
    @NotBlank
    private String publicPlace;
    @NotBlank
    private String CEP;
    @NotBlank
    private String number;
    @NotBlank
    private String city;
    @NotBlank
    private boolean mainAddress;

    private Long personId;

    public Address transfer() {
        return new Address(publicPlace, CEP, number, city, mainAddress);
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(boolean mainAddress) {
        this.mainAddress = mainAddress;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
