package br.com.confidencecambio.javabasico.service.impl;

import br.com.confidencecambio.javabasico.models.PessoaModel;
import br.com.confidencecambio.javabasico.service.ImcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static br.com.confidencecambio.javabasico.util.Utils.calculaIMC;


@Service
public class ImcServiceImpl implements ImcService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImcServiceImpl.class);

    @Override
    public PessoaModel calcularImc(PessoaModel pessoa) {
        LOGGER.info("Realizando calculo do IMC da pessoa: {}", pessoa.getNome());
        if (pessoa.getPeso() != 0.0 & pessoa.getAltura() != 0.0) {
            pessoa.setImc(calculaIMC(pessoa));
        }
        return pessoa;
    }
}
