package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Calificacion;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "calificacion" )
public class CalificacionController {


    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/addCalificacion", method = RequestMethod.POST)
    public ResponseEntity<?> newUser(@RequestBody Calificacion calificacion) {
        return new ResponseEntity<>(userService.addCalificacion(calificacion), HttpStatus.ACCEPTED);
    }


}
