package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.HorariosDisponibles;
import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import com.eci.cosw.springbootsecureapi.repositories.ObjetoOfrecidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public ObjetoOfrecido createObjetoOfrecido(ObjetoOfrecido of) {
        return obofrerepo.save(of);
    }

    @Override
    public ObjetoOfrecido agregarHorario(HorariosDisponibles horariosDisponibles) {
        System.out.println(" AQUIIIII");
        ObjetoOfrecido objetoOfrecido = obofrerepo.getLastObjetoOfrecido().get(0);
        horariosDisponibles.setObjetoOfrecido(objetoOfrecido);

        List<HorariosDisponibles> listHd = new ArrayList<>();
        if(objetoOfrecido.getHorariosDisponibles().size()!=0){
            listHd = objetoOfrecido.getHorariosDisponibles();
        }
        listHd.add(horariosDisponibles);
        objetoOfrecido.setHorariosDisponibles(listHd);
        obofrerepo.save(objetoOfrecido);
        return objetoOfrecido;
    }

    @Override
    public ObjetoOfrecido getObjetoById(long id) {
        return obofrerepo.findOne(id);
    }
}
