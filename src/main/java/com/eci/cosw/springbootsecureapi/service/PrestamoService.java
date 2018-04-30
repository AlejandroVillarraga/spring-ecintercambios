package com.eci.cosw.springbootsecureapi.service;


import com.eci.cosw.springbootsecureapi.model.Prestamo;

public interface PrestamoService {

    Prestamo savePrestamo(Prestamo prestamo );

    Prestamo getPrestamo(long id);

}
