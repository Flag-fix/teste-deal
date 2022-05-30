package br.com.confidencecambio.javabasico.service.impl;

import br.com.confidencecambio.javabasico.dto.PessoaDTO;
import br.com.confidencecambio.javabasico.service.PessoaService;
import org.springframework.stereotype.Service;

import static br.com.confidencecambio.javabasico.util.Utils.*;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Override
    public Object primeiroNome(Object obj) {
        return retornaPrimeiroNome(obj);
    }

    @Override
    public Object ultimoNome(Object obj) {
        return retornaUltimoNome(obj);
    }

    @Override
    public Object nomeCaixaAlta(Object obj) {
        return retornaNomeCaixaAlta(obj);
    }

    @Override
    public Object nomeAbreviado(Object obj) {
        return retornaNomeAbreviado(obj);
    }
}
