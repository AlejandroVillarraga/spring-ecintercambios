package com.eci.cosw.springbootsecureapi.model;

import com.eci.cosw.springbootsecureapi.repositories.CalificacionRepository;
import com.eci.cosw.springbootsecureapi.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigInteger;
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

    private String name;

    private String username;

    private String genero;

    private List<ObjetoOfrecido> objetoOfrecidoList;

    private BigInteger celular;

    private int numeroDeOpiniones;

    @Autowired
    CalificacionRepository calirepo;


    public User()
    {
    }

    public User(String email, String password, String name , String username, List<ObjetoOfrecido> objetoOfrecidoList,
                String genero, BigInteger celular, int numeroDeOpiniones) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.username = username;
        this.objetoOfrecidoList = objetoOfrecidoList;
        this.genero=genero;
        this.celular=celular;
        this.numeroDeOpiniones=numeroDeOpiniones;
    }

    public User(String email, String password, String name , String username,
                String genero, BigInteger celular) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.username = username;
        this.genero=genero;
        this.celular=celular;
    }

    @Column(name = "numero_opiniones", nullable = false)
    public int getNumeroDeOpiniones() {
        return numeroDeOpiniones;
    }

    public void setNumeroDeOpiniones(int numeroDeOpiniones) {
        this.numeroDeOpiniones = numeroDeOpiniones;
    }

    @Column(name = "celular", nullable = false)
    public BigInteger getCelular() {
        return celular;
    }

    public void setCelular(BigInteger celular) {
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

    @Column(name = "name", nullable = false)
    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
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
