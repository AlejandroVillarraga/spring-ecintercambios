package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.*;
import com.eci.cosw.springbootsecureapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamosRepository presrepo;

    @Autowired
    UserRepository userrepo;

    @Autowired
    ObjetoRepository objetorepo;

    @Autowired
    ObjetoOfrecidoRepository objeOfretorepo;

    @Autowired
    HorariosDisponiblesRepository horrepo;

    @Override
    public Prestamo savePrestamo(Prestamo prestamo ) {
        System.out.println("Entro Al SERVICEEEEEEEEEEEEEEEEEE");

        User prestador = prestamo.getPrestador();
        User solicitante = prestamo.getSolicitante();
        ObjetoOfrecido of = prestamo.getObjetoOfrecido();
        HorariosDisponibles hd = prestamo.getHorariosDisponibles();
        Prestamo p = new Prestamo(prestador, solicitante, true, of, hd);
        presrepo.save(p);
        return p;
    }

    @Override
    public Prestamo getPrestamo(long id) {
        return presrepo.findOne(id);
    }
}
