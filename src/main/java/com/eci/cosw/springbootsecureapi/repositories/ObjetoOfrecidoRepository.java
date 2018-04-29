package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjetoOfrecidoRepository extends JpaRepository<ObjetoOfrecido, Long> {


    @Query("SELECT o from ObjetoOfrecido o where o.objeto_ofrecido.name=?1 AND o.user.username<>?2 ORDER BY o.user.calificacion DESC")
    public List<ObjetoOfrecido> getObjetoByNameLogueado(String name, String username);

    @Query("SELECT o from ObjetoOfrecido o where o.objeto_ofrecido.name=?1 ORDER BY o.user.calificacion DESC")
    public List<ObjetoOfrecido> getObjetoOfrecidoByName(String name);

    @Query("SELECT o from ObjetoOfrecido o ORDER BY o.id DESC")
    public List<ObjetoOfrecido> getLastObjetoOfrecido();





}
