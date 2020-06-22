package com.openwebinars.estructura.repositorios;

import com.openwebinars.estructura.entidades.UnaEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnRepositorio extends CrudRepository<UnaEntidad, Long> {

}
