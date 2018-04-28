package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import com.eci.cosw.springbootsecureapi.repositories.ObjetoOfrecidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetoOfrecidoServicePersistence implements ObjetoOfrecidoService {

    @Autowired
    ObjetoOfrecidoRepository obofrerepo;

    @Override
    public List<ObjetoOfrecido> getAllObjetos() {
        return obofrerepo.findAll();
    }

    @Override
    public List<ObjetoOfrecido> getObjetoByNameLogueado(String name, String currentUser) {
        return obofrerepo.getObjetoByNameLogueado(name, currentUser);
    }

    @Override
    public List<ObjetoOfrecido> getObjetoByName(String name) {
        return obofrerepo.getObjetoOfrecidoByName(name);
    }
}
