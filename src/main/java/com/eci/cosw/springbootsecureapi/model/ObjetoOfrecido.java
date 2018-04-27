package com.eci.cosw.springbootsecureapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "Objeto_Ofrecido" )
public class ObjetoOfrecido {

    long id;
    List<HorariosDisponibles> horariosDisponibles;
    User user;
    Objeto objeto_ofrecido;
    String descripcion;
    int precio;


    public ObjetoOfrecido(List<HorariosDisponibles> horariosDisponibles, User user, Objeto objeto_ofrecido, String descripcion, int precio) {
        this.horariosDisponibles = horariosDisponibles;
        this.user = user;
        this.objeto_ofrecido = objeto_ofrecido;
        this.descripcion=descripcion;
        this.precio=precio;
    }

    public ObjetoOfrecido() {
    }

    @Column(name = "precio", nullable = false)
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Column(name = "descripcion", nullable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="objeto", referencedColumnName="name", nullable=true)
    public Objeto getObjeto_ofrecido() {
        return objeto_ofrecido;
    }

    public void setObjeto_ofrecido(Objeto objeto_ofrecido) {
        this.objeto_ofrecido = objeto_ofrecido;
    }


    @OneToMany(mappedBy="objetoOfrecido",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    public List<HorariosDisponibles> getHorariosDisponibles() {
        return horariosDisponibles;
    }

    public void setHorariosDisponibles(List<HorariosDisponibles> horariosDisponibles) {
        this.horariosDisponibles = horariosDisponibles;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="user", referencedColumnName="email", nullable=true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
