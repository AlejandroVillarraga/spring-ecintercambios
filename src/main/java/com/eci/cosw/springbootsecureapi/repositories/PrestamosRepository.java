package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamosRepository extends JpaRepository<Prestamo, Long> {
}
