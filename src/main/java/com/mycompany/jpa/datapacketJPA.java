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
@Table(name = "datapacket")
public class datapacketJPA implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    
    @Column(name= "latitud", nullable = false)
    private float latitud;
    
     @Column(name= "longitud", nullable = false)
    private float longitud;
     
    @Column(name= "distancia", nullable = false)
    private float distancia;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "datapacket{" + "latitud=" + latitud + ", longitud=" + longitud + ", distancia=" + distancia + '}';
    }
    
    
    
     
}
