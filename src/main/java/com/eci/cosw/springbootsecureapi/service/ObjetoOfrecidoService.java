package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;

import java.util.List;

public interface ObjetoOfrecidoService {

    List<ObjetoOfrecido> getAllObjetos();

    List<ObjetoOfrecido> getObjetoByName(String name);

}
