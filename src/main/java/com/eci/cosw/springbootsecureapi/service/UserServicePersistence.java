package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Calificacion;
import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.repositories.CalificacionRepository;
import com.eci.cosw.springbootsecureapi.repositories.ObjetoOfrecidoRepository;
import com.eci.cosw.springbootsecureapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicePersistence implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjetoOfrecidoRepository objetoOfrecidoRepository;


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }



    @Override
    public User getUser(String email) {
        User u = userRepository.findOne(email);
        return u;
    }

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        System.out.println(user.getName());
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public ObjetoOfrecido addObjetoOfrecido( ObjetoOfrecido objetoOfrecido, String email) {
        User cu = userRepository.findOne(email);
        List<ObjetoOfrecido> listob = cu.getObjetoOfrecidoList();
        listob.add(objetoOfrecido);
        cu.setObjetoOfrecidoList(listob);
        userRepository.save(cu);
        return objetoOfrecidoRepository.getLastObjetoOfrecido().get(0) ;
    }
}
