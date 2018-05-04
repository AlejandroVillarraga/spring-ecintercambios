package com.eci.cosw.springbootsecureapi.service;


import com.eci.cosw.springbootsecureapi.model.Prestamo;

import java.util.List;

public interface PrestamoService {

    Prestamo savePrestamo(Prestamo prestamo );

    Prestamo getPrestamo(long id);

    List<Prestamo> getMisSolicitudes(String email);

    List<Prestamo> getMisObjetosPrestados(String email);

    Prestamo aprobarPrestamo(long id);

    List<Prestamo> getAllSolicitudes();



}
