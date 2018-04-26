package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "Prestamo" )
public class Prestamo {

    long id;
    User prestador;
    User solicitante;
    Boolean aceptado;
    ObjetoOfrecido objetoOfrecido;
    HorariosDisponibles horariosDisponibles;

    public Prestamo(User prestador, User solicitante, Boolean aceptado, ObjetoOfrecido objetoOfrecido, HorariosDisponibles horariosDisponibles) {
        this.prestador = prestador;
        this.solicitante = solicitante;
        this.aceptado = aceptado;
        this.objetoOfrecido = objetoOfrecido;
        this.horariosDisponibles = horariosDisponibles;
    }

    public Prestamo() {
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
    @JoinColumn(name="prestador", referencedColumnName="email", nullable=true)
    public User getPrestador() {
        return prestador;
    }

    public void setPrestador(User prestador) {
        this.prestador = prestador;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="solicitante", referencedColumnName="email", nullable=true)
    public User getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(User solicitante) {
        this.solicitante = solicitante;
    }

    @Column(name = "aceptado", nullable = false)
    public Boolean getAceptado() {
        return aceptado;
    }

    public void setAceptado(Boolean aceptado) {
        this.aceptado = aceptado;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="objeto_ofrecido", referencedColumnName="id", nullable=true)
    public ObjetoOfrecido getObjetoOfrecido() {
        return objetoOfrecido;
    }

    public void setObjetoOfrecido(ObjetoOfrecido objetoOfrecido) {
        this.objetoOfrecido = objetoOfrecido;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="horarios_disponibles", referencedColumnName="id", nullable=true)
    public HorariosDisponibles getHorariosDisponibles() {
        return horariosDisponibles;
    }

    public void setHorariosDisponibles(HorariosDisponibles horariosDisponibles) {
        this.horariosDisponibles = horariosDisponibles;
    }
}
