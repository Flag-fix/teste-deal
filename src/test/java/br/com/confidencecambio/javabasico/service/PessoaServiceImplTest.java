package br.com.confidencecambio.javabasico.service;


import br.com.confidencecambio.javabasico.models.PessoaModel;
import br.com.confidencecambio.javabasico.service.impl.ImcServiceImpl;
import br.com.confidencecambio.javabasico.service.impl.PessoaServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PessoaServiceImplTest {

    private PessoaServiceImpl service;

    @Before
    public void init() {
        service = new PessoaServiceImpl();
    }


    @Test
    public void quandoRetornaPrimeiroNome() {
        var pessoaRequest = new PessoaModel();
        var pessoaResponse = new PessoaModel();
        pessoaRequest.setNome("Jose Silva Amarildo");
        var retorno = service.primeiroNome(pessoaRequest);
        BeanUtils.copyProperties(retorno, pessoaResponse);
        assertEquals("Jose", pessoaResponse.getNome());
    }

    @Test
    public void quandoRetornaUltimoNome() {
        var pessoaRequest = new PessoaModel();
        var pessoaResponse = new PessoaModel();
        pessoaRequest.setNome("Jose Silva Amarildo");
        var retorno = service.ultimoNome(pessoaRequest);
        BeanUtils.copyProperties(retorno, pessoaResponse);
        assertEquals("Silva Amarildo", pessoaResponse.getNome());
    }

    @Test
    public void quandoRetornaNomeCaixaAlta() {
        var pessoaRequest = new PessoaModel();
        var pessoaResponse = new PessoaModel();
        pessoaRequest.setNome("Jose Silva Amarildo");
        var retorno = service.nomeCaixaAlta(pessoaRequest);
        BeanUtils.copyProperties(retorno, pessoaResponse);
        assertEquals("JOSE SILVA AMARILDO", pessoaResponse.getNome());
    }

    @Test
    public void quandoRetornaNomeAbreviado() {
        var pessoaRequest = new PessoaModel();
        var pessoaResponse = new PessoaModel();
        pessoaRequest.setNome("Jose Silva Amarildo");
        var retorno = service.nomeAbreviado(pessoaRequest);
        BeanUtils.copyProperties(retorno, pessoaResponse);
        assertEquals("Jose S. Amarildo", pessoaResponse.getNome());
    }


}