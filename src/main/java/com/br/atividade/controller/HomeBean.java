package com.br.atividade.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.atividade.model.Pessoa;
import com.br.atividade.repository.IPessoaRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RequestScoped
@ManagedBean
@Component
public class HomeBean {
    private List<Pessoa> lista = new ArrayList<Pessoa>();
    @Autowired
    private IPessoaRepository repository;

    public void getPessoas() throws IOException {
        List<Pessoa> pessoas = (List<Pessoa>) repository.findAll();
        this.lista = pessoas;
        FacesContext.getCurrentInstance().getExternalContext().redirect("/?");
    }
}
