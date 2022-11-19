package com.br.atividade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.atividade.model.Dependente;

/**
 * IDependente
 */
@Repository
public interface IDependenteRepository extends CrudRepository<Dependente, Long> {
    // ArrayList<Dependente> findByPessoa(Pessoa Pessoa);
}