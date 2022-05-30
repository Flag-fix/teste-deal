package br.com.confidencecambio.javabasico.dto;


import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Data
public class PessoaIMCDTO {


    private String nome;

    @DecimalMin(value = "3.0", message = "Peso menor que 3kg")
    @DecimalMax(value = "700.0", message = "Peso maior que 700kg")
    private Double peso;

    @DecimalMin(value = "0.1", message = "Altura não pode ser menor que 1cm")
    @DecimalMax(value = "300.0", message = "Altura não pode ser mairo que 300cm")
    private Double altura;

}
