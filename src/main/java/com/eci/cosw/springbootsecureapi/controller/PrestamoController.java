package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import com.eci.cosw.springbootsecureapi.model.Prestamo;
import com.eci.cosw.springbootsecureapi.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "prestamo" )
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;


    @CrossOrigin
    @RequestMapping(value = "/savePrestamo", method = RequestMethod.POST)
    public ResponseEntity<?> addObjetoOfrecido(@RequestBody Prestamo prestamo) {
        System.out.println("Entro Al CONTROLLLEEEEEEEEEEEEEEEEEEER");
        return new ResponseEntity<>(prestamoService.savePrestamo(prestamo), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @RequestMapping( value = "/getPrestamo/{id}", method = RequestMethod.GET )
    public Prestamo getPrestamo(@PathVariable long id) {

        return prestamoService.getPrestamo(id);
    }


}
