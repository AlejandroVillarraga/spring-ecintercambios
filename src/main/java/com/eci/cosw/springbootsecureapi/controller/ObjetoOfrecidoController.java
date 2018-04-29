package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.HorariosDisponibles;
import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import com.eci.cosw.springbootsecureapi.service.ObjetoOfrecidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @RequestMapping( value = "/byNameLogeado/{name}/{currentUser}", method = RequestMethod.GET )
    public List<ObjetoOfrecido> getObjetoByName(@PathVariable String name, @PathVariable String currentUser) {
        return objetoOfrecidoService.getObjetoByNameLogueado(name, currentUser);
    }

    @CrossOrigin
    @RequestMapping( value = "/byName/{name}", method = RequestMethod.GET )
    public List<ObjetoOfrecido> getObjetoByNameNoLogeado(@PathVariable String name) {
        return objetoOfrecidoService.getObjetoByName(name);
    }


    @CrossOrigin
    @RequestMapping(value = "/registrarObjetoOfrecido", method = RequestMethod.POST)
    public ResponseEntity<?> registrarObjetoOfrecido(@RequestBody ObjetoOfrecido objetoOfrecido) {
        return new ResponseEntity<>(objetoOfrecidoService.createObjetoOfrecido(objetoOfrecido), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @RequestMapping(value = "/agregarHorario", method = RequestMethod.POST)
    public ResponseEntity<?> agregarHorario(@RequestBody HorariosDisponibles horariosDisponibles) {
        System.out.println("Esto es CONTROLLER");
        System.out.println("Esto es CONTROLLER");
        System.out.println(horariosDisponibles);
        System.out.println("Esto es CONTROLLER");
        System.out.println("Esto es CONTROLLER");
        return new ResponseEntity<>(objetoOfrecidoService.agregarHorario(horariosDisponibles), HttpStatus.ACCEPTED);
    }




}
