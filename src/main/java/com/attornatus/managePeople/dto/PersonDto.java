package com.attornatus.managePeople.dto;

import com.attornatus.managePeople.model.Person;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public class PersonDto {

    @NotBlank
    private String name;

    @NotNull
    @PastOrPresent
    private Date birthDate;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String telephone;

    public Person transfer() {
        return new Person(name,birthDate,email,telephone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
