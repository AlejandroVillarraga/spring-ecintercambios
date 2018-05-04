package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import com.eci.cosw.springbootsecureapi.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrestamosRepository extends JpaRepository<Prestamo, Long> {

    @Query("SELECT p from Prestamo p WHERE p.solicitante.email=?1 ORDER BY p.aceptado ASC")
    public List<Prestamo> getMisSolicitudes(String email);

    @Query("SELECT p from Prestamo p WHERE p.prestador.email=?1 ORDER BY p.aceptado ASC")
    public List<Prestamo> getMisObjetosPrestados(String email);

    @Query("SELECT p from Prestamo p ORDER BY p.aceptado ASC")
    public List<Prestamo> getAllPrestamos();






}
