package com.br.zup.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.br.zup.models.Jogadores;

@Repository
public interface JogadoresRepository extends CrudRepository<Jogadores, Integer> {

}
