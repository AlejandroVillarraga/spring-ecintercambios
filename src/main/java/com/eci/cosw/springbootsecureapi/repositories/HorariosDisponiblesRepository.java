package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.HorariosDisponibles;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorariosDisponiblesRepository extends JpaRepository<HorariosDisponibles, Long> {


}
