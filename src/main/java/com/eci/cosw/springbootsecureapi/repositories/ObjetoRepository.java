package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetoRepository  extends JpaRepository<Objeto, String> {
}
