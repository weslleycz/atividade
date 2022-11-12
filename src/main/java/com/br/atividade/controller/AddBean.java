package com.br.atividade.controller;

import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RequestScoped
@ManagedBean
public class AddBean {
    private String nome;
    private String cpf;
    public void process() throws IOException {
        System.out.println(nome);
        System.out.println(cpf);
        this.nome = "";
        this.cpf = "";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Message Content."));
        }
    }
}