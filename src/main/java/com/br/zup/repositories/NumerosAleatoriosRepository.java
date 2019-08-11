package com.br.zup.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.models.NumeroAleatorio;

@Repository
public interface NumerosAleatoriosRepository extends CrudRepository<NumeroAleatorio, Integer> {

}
