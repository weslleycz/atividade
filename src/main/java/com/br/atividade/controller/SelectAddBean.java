
package com.br.atividade.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.atividade.model.Dependente;
import com.br.atividade.model.Pessoa;
import com.br.atividade.repository.IDependenteRepository;
import com.br.atividade.repository.IPessoaRepository;

import lombok.Getter;
import lombok.Setter;

/**
 * SelectAddBean
 */
@Getter
@Setter
@RequestScoped
@ManagedBean
@Component
public class SelectAddBean {

    @Autowired
    private IPessoaRepository repositoryPessoa;
    private IDependenteRepository repositoryDependente;
    private ArrayList<Dependente> dependentes = new ArrayList<Dependente>();

    private String nome;
    private String cpf;
    private Long id;

    private String nomeDependente;
    private Date dataDeNascimento;

    public void selectPessoa(Long id) throws IOException {
        Optional<Pessoa> pessoa = repositoryPessoa.findById(id);
        if (pessoa.isPresent()) {
            this.nome = pessoa.get().getNome();
            this.cpf = pessoa.get().getCpf();
            this.id = pessoa.get().getId();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/edit");
        }
    }

    public void putPessoas(Long id) {
        Optional<Pessoa> pessoa = repositoryPessoa.findById(id);
        Pessoa upidate = pessoa.get();
        upidate.setCpf(cpf);
        upidate.setNome(nome);
        repositoryPessoa.save(upidate);
    }

    public void selectDependente() {
        if (dataDeNascimento.before(new Date())) {
            Dependente dependente = new Dependente();
            dependente.setDataDeNascimento(dataDeNascimento);
            dependente.setNome(nomeDependente);
            System.out.println(dependente.getClass());
            //repositoryDependente.save(dependente);
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Data de nascimento não valida."));
        }
    }

}