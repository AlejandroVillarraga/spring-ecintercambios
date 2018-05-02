package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.Calificacion;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CalificacionRepository  extends JpaRepository<Calificacion, Long> {


    @Query("SELECT AVG(c) from Calificacion c WHERE c.user.email=?1")
    public int getCalificacionPromedioByEmail(String email);


}
