package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import com.eci.cosw.springbootsecureapi.service.ObjetoOfrecidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "objetosOfrecidos" )
public class ObjetoOfrecidoController {

    @Autowired
    ObjetoOfrecidoService objetoOfrecidoService;

    @CrossOrigin
    @RequestMapping( value = "/getAll", method = RequestMethod.GET )
    public List<ObjetoOfrecido> getAllObjetosOfrecidos() {
        return objetoOfrecidoService.getAllObjetos();
    }

    @CrossOrigin
    @RequestMapping( value = "/byName/{name}", method = RequestMethod.GET )
    public List<ObjetoOfrecido> getObjetoByName(@PathVariable String name) {
        return objetoOfrecidoService.getObjetoByName(name);
    }

}
