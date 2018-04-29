package com.eci.cosw.springbootsecureapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "Horarios_Disponibles" )
public class HorariosDisponibles {

    long id;
    String dia;
    String hora_inicio;
    String hora_fin;
    ObjetoOfrecido objetoOfrecido;

    public HorariosDisponibles(String dia, String hora_inicio, String hora_fin, ObjetoOfrecido objetoOfrecido) {
        this.dia = dia;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.objetoOfrecido = objetoOfrecido;
    }

    public HorariosDisponibles(String dia, String hora_inicio, String hora_fin) {
        this.dia = dia;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public HorariosDisponibles() {
    }

    @JsonIgnore
    @ManyToOne(cascade=ALL)
    @JoinColumn(name="objeto_ofrecido", referencedColumnName="id", nullable=true)
    public ObjetoOfrecido getObjetoOfrecido() {
        return objetoOfrecido;
    }

    public void setObjetoOfrecido(ObjetoOfrecido objetoOfrecido) {
        this.objetoOfrecido = objetoOfrecido;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "dia", nullable = false)
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Column(name = "hora_inicio", nullable = false)
    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    @Column(name = "hora_fin", nullable = false)
    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

}
