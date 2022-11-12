package com.br.atividade.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.atividade.repository.IPessoaRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RequestScoped
@ManagedBean
@Component
public class HomeBean {

    @Autowired
    private IPessoaRepository repository;
    private String nome = "weslley";

    public void process() throws IOException {
        System.out.println(repository.findAll().toString());
    }

}
