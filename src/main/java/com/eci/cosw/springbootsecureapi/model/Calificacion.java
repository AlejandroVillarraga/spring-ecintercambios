package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "Calificacion" )
public class Calificacion {

    long id;
    int calificacion;
    User user;

    public Calificacion(int calificacion, User user) {
        this.calificacion = calificacion;
        this.user = user;
    }

    public Calificacion() {
    }

    @Column(name = "calificacion", nullable = false)
    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="user_email", referencedColumnName="email", nullable=true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
