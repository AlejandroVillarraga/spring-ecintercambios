package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.*;
import com.eci.cosw.springbootsecureapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
/*
        User prestador = prestamo.getPrestador();
        User solicitante = prestamo.getSolicitante();
        ObjetoOfrecido of = prestamo.getObjetoOfrecido();
        HorariosDisponibles hd = prestamo.getHorariosDisponibles();
        List<HorariosDisponibles> pruebalist = new ArrayList<>();
        of.setHorariosDisponibles(pruebalist);
        Prestamo p = new Prestamo(prestador, solicitante, true, of, hd);*/
        presrepo.save(prestamo);
        return prestamo;
    }

    @Override
    public Prestamo getPrestamo(long id) {
        return presrepo.findOne(id);
    }

    @Override
    public List<Prestamo> getMisSolicitudes(String email) {
        return presrepo.getMisSolicitudes(email);
    }

    @Override
    public List<Prestamo> getMisObjetosPrestados(String email) {
        return presrepo.getMisObjetosPrestados(email);
    }

    @Override
    public Prestamo aprobarPrestamo(long id) {
        Prestamo pres = presrepo.findOne(id);
        pres.setAceptado(true);
        presrepo.save(pres);
        return pres;
    }
}
