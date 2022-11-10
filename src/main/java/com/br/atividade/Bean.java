package com.br.atividade;

import javax.faces.view.ViewScoped;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ViewScoped
public class Bean {
    private String name = "Hello World";
    private String description = "Seja bem ghhgyhyh";    
}