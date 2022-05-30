package br.com.confidencecambio.javabasico.util;

import br.com.confidencecambio.javabasico.dto.PessoaDTO;
import br.com.confidencecambio.javabasico.models.PessoaModel;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Locale;

public class Utils {


    public static Double calculaIMC(PessoaModel imc) {
        var peso = imc.getPeso() / Math.pow(imc.getAltura(), 2);
        return (double) Math.round(peso);
    }

    public static String[] separarNome(String nome) {
        String[] output = nome.split(" ");
        return output;
    }

    private static boolean validaEspacoInicioFim(String nome) {
        return !nome.startsWith(" ") & !nome.endsWith(" ");
    }

    public static Object retornaPrimeiroNome(Object obj) {
        var pessoa = new PessoaDTO();
        BeanUtils.copyProperties(obj, pessoa);
        if (validaEspacoInicioFim(pessoa.getNome())) {
            var valores = separarNome(pessoa.getNome());
            pessoa.setNome(valores[0]);
            return pessoa;
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome com espaço no início ou no fim");
        }
    }

    public static Object retornaUltimoNome(Object obj) {
        var pessoa = new PessoaDTO();
        BeanUtils.copyProperties(obj, pessoa);
        if (validaEspacoInicioFim(pessoa.getNome())) {
            var valores = separarNome(pessoa.getNome());
            var nome = new StringBuilder();
            for (int i = 0; i < valores.length; i++) {
                if (i != 0) {
                    if(valores[i].length() > 3){
                        nome.append(valores[i]);
                        if (i + 1 != valores.length) {
                            nome.append(" ");
                        }
                    }
                }
            }
            pessoa.setNome(String.valueOf(nome));
            return pessoa;
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome com espaço no início ou no fim");
        }
    }


    public static Object retornaNomeCaixaAlta(Object obj) {
        var pessoa = new PessoaDTO();
        BeanUtils.copyProperties(obj, pessoa);
        if (validaEspacoInicioFim(pessoa.getNome())) {
            var caixaAlta = pessoa.getNome().toUpperCase(Locale.ROOT);
            pessoa.setNome(caixaAlta);
            return pessoa;
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome com espaço no início ou no fim");
        }
    }

    public static Object retornaNomeAbreviado(Object obj) {
        var pessoa = new PessoaDTO();
        BeanUtils.copyProperties(obj, pessoa);
        if (validaEspacoInicioFim(pessoa.getNome())) {
            var valores = separarNome(pessoa.getNome());
            var nome = new StringBuilder();
            for (int i = 0; i < valores.length; i++) {
                if (i == 1) {
                    nome.append(valores[i].charAt(0)).append(".");
                } else {
                    nome.append(valores[i]);
                }
                if (i + 1 != valores.length) {
                    nome.append(" ");
                }

            }
            pessoa.setNome(String.valueOf(nome));
            return pessoa;
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome com espaço no início ou no fim");
        }
    }


}
