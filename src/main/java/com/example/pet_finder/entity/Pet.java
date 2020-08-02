package com.example.pet_finder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pet implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPet;
    private String name;
    private String breed;
    private Integer age;
    private String weight;
    private String city;

    @ManyToOne
    @JoinColumn(name="ID_LOGIN_USER")
    private LoginUsers idUser;

    public LoginUsers getIdUser() {
        return this.idUser;
    }

    public void setIdUser(LoginUsers idUser) {
        this.idUser = idUser;
    }

    public Integer getIdPet() {
        return this.idPet;
    }

    public void setIdPet(Integer idPet) {
        this.idPet = idPet;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}