package com.attornatus.managePeople.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String publicPlace;

    private String CEP;

    private String number;

    private String city;

    private boolean isMainAddress;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private Person person;

    public Address (){}

    public Address(String publicPlace, String CEP, String number, String city, boolean isMainAddress){
        this.publicPlace = publicPlace;
        this.CEP = CEP;
        this.number = number;
        this.city = city;
        this.isMainAddress = isMainAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isMainAddress() {
        return isMainAddress;
    }

    public void setMainAddress(boolean mainAddress) {
        isMainAddress = mainAddress;
    }
}
