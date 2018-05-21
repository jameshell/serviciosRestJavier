/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author james
 */
@Entity
@Table(name = "dog")
public class dogJPA implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    
    @Column(name= "breed", nullable = false)
    private String breed;
    
    @Column(name= "personality", nullable = false)
    private String personality;
    
    @Column(name= "energy", nullable = false)
    private String energy;
    
    @Column(name= "descripcion", nullable = false)
    private String description;
    
    @Column(name= "picture", nullable = true)
    private String picture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "dogJPA{" + "id=" + id + ", breed=" + breed + ", personality=" + personality + ", energy=" + energy + ", description=" + description + ", picture=" + picture + '}';
    }

}
