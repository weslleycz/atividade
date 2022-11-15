package com.br.atividade.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.atividade.model.Pessoa;

@Repository
public interface IPessoaRepository extends CrudRepository<Pessoa, Long> {
    ArrayList<Pessoa> findByCpf(String cpf);
}
