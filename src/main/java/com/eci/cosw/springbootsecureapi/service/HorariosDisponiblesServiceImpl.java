package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.HorariosDisponibles;
import com.eci.cosw.springbootsecureapi.repositories.HorariosDisponiblesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorariosDisponiblesServiceImpl implements HorariosDisponiblesService{

    @Autowired
    HorariosDisponiblesRepository hodirepo;

    @Override
    public HorariosDisponibles getHorarioById(long id) {
        return hodirepo.findOne(id);
    }
}
