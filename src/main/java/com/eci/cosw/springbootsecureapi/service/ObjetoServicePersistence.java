package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.repositories.ObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetoServicePersistence implements ObjetoService {

    @Autowired
    ObjetoRepository objrepo;

    @Override
    public List<Objeto> getAllObjetos() {
        return objrepo.findAll();
    }
}
