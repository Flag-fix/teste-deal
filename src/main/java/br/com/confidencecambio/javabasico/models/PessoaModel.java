package br.com.confidencecambio.javabasico.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaModel {

    private String nome;

    private Double peso;

    private Double altura;

    private Double imc;

}
