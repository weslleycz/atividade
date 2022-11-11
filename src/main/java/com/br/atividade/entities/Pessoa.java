package com.br.atividade.entities;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RequestScoped
@ManagedBean
public class Pessoa {
    private int id;
    private String nome;
    private Dependente dependente;

    public void process(){
        System.out.println(nome);
   }
}
