package com.br.atividade.entities;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dependente {
    private String uuid;
    private String nome;
    private LocalDate dataDeNascimento;
}
