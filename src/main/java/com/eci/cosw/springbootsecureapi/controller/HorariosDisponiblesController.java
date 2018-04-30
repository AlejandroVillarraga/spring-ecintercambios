package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.HorariosDisponibles;
import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.HorariosDisponiblesService;
import com.eci.cosw.springbootsecureapi.service.ObjetoOfrecidoService;
import com.eci.cosw.springbootsecureapi.service.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "horariosDisponibles" )
public class HorariosDisponiblesController {

    @Autowired
    private HorariosDisponiblesService horarioService;


    @CrossOrigin
    @RequestMapping( value = "/getById/{id}", method = RequestMethod.GET )
    public HorariosDisponibles getObjetoByName(@PathVariable long id) {
        return horarioService.getHorarioById(id);
    }

}
