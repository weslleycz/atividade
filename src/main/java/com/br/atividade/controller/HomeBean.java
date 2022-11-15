package com.br.atividade.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private static final Class<? extends Optional> Optional = null;
    private ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
    @Autowired
    private IPessoaRepository repository;

    private String cpf;

    public void getPessoas() throws IOException {
        this.cpf = "";
        List<Pessoa> pessoas = (List<Pessoa>) repository.findAll();
        this.lista = (ArrayList<Pessoa>) pessoas;
        FacesContext.getCurrentInstance().getExternalContext().redirect("/?");
    }

    public void getPessoasCPF() throws IOException {
        System.out.println(cpf);
        if (cpf != "") {
            ArrayList<Pessoa> pessoas = repository.findByCpf(cpf);
            if (pessoas.size() != 0) {
                this.lista = pessoas;
                FacesContext.getCurrentInstance().getExternalContext().redirect("/??");
            } else {
                ArrayList<Pessoa> listaVoid = new ArrayList<Pessoa>();
                this.lista = listaVoid;
                FacesContext.getCurrentInstance().getExternalContext().redirect("/??");
            }
        } else {
            getPessoas();
        }
    }
}
