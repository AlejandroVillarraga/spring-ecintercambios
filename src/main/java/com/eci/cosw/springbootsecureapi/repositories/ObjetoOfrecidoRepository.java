package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjetoOfrecidoRepository extends JpaRepository<ObjetoOfrecido, Long> {


    @Query("SELECT o from ObjetoOfrecido o where o.objeto_ofrecido.name=?1")
    public List<ObjetoOfrecido> getObjetoOfrecidoByName(String name);



}
