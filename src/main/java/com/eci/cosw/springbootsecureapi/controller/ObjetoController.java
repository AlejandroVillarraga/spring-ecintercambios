package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.ObjetoOfrecidoService;
import com.eci.cosw.springbootsecureapi.service.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @RequestMapping( value = "/{name}", method = RequestMethod.GET )
    public Objeto getObjetoByName(@PathVariable String name) {
        return objetoService.getObjetoByName(name);
    }









}
