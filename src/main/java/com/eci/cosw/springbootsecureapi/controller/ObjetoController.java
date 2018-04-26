package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import com.eci.cosw.springbootsecureapi.service.ObjetoOfrecidoService;
import com.eci.cosw.springbootsecureapi.service.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "objeto" )
public class ObjetoController {

    @Autowired
    private ObjetoService objetoService;

    @CrossOrigin
    @RequestMapping( value = "/getAll", method = RequestMethod.GET )
    public List<Objeto> getObjetos() {
        return objetoService.getAllObjetos();
    }



}
