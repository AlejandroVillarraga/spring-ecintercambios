package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Objeto")
public class Objeto {

    String name;
    String image;

    public Objeto(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Objeto() {
    }

    @Id
    @Column(name = "name", nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "image", nullable = true)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
