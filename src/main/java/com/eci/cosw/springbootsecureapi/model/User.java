package com.eci.cosw.springbootsecureapi.model;

import com.eci.cosw.springbootsecureapi.repositories.CalificacionRepository;
import com.eci.cosw.springbootsecureapi.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Entity
@Table(name = "User" )
public class User
{

    private int calificacion;

    private String email;

    private String password;

    private String firstname;

    private String lastname;

    private String username;

    private String genero;

    private List<ObjetoOfrecido> objetoOfrecidoList;

    private int celular;

    private int numeroDeOpiniones;

    @Autowired
    CalificacionRepository calirepo;


    public User()
    {
    }

    public User(String email, String password, String firstname, String lastname, String username, List<ObjetoOfrecido> objetoOfrecidoList, String genero, int celular, int numeroDeOpiniones) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.objetoOfrecidoList = objetoOfrecidoList;
        this.genero=genero;
        this.celular=celular;
        this.numeroDeOpiniones=numeroDeOpiniones;
    }

    @Column(name = "numero_opiniones", nullable = false)
    public int getNumeroDeOpiniones() {
        return numeroDeOpiniones;
    }

    public void setNumeroDeOpiniones(int numeroDeOpiniones) {
        this.numeroDeOpiniones = numeroDeOpiniones;
    }

    @Column(name = "celular", nullable = false)
    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Column(name = "genero", nullable = false)
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Column(name = "calificacion", nullable = false)
    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @JsonIgnore
    @OneToMany(mappedBy="user",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    public List<ObjetoOfrecido> getObjetoOfrecidoList() {
        return objetoOfrecidoList;
    }

    public void setObjetoOfrecidoList(List<ObjetoOfrecido> objetoOfrecidoList) {
        this.objetoOfrecidoList = objetoOfrecidoList;
    }

    @Id
    @Column(name = "email", nullable = false)
    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    @Column(name = "firstname", nullable = false)
    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname( String firstname )
    {
        this.firstname = firstname;
    }

    @Column(name = "lastname", nullable = false)
    public String getLastname()
    {
        return lastname;
    }

    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }

    @Column(name = "username", nullable = false)
    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }


}
