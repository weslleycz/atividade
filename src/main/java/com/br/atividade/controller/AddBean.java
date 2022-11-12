package com.br.atividade.controller;

import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
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
public class AddBean {
    private String nome;
    private String cpf;

    @Autowired
    private IPessoaRepository repository;

    public void process() throws IOException {
        System.out.println(nome);
        System.out.println(cpf);
        try {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setCpf(cpf);
            repository.save(pessoa);
            this.nome = "";
            this.cpf = "";
            FacesContext.getCurrentInstance().getExternalContext().redirect("/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Message Content."));
        }
    }
}

//HomeBean