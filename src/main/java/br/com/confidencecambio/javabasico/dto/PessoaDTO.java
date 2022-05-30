package br.com.confidencecambio.javabasico.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PessoaDTO {


    @NotBlank(message = "Nome da Pessoa Não pode ser Vazio")
    @NotNull(message = "Nome da Pessoa Não pode ser Nulo")
    private String nome;

}
