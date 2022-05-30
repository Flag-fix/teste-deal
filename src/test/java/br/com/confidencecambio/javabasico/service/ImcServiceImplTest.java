package br.com.confidencecambio.javabasico.service;


import br.com.confidencecambio.javabasico.models.PessoaModel;
import br.com.confidencecambio.javabasico.service.impl.ImcServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ImcServiceImplTest {

    private ImcServiceImpl service;

    @Before
    public void init() {
        service = new ImcServiceImpl();
    }


    @Test
    public void quandoPassarPesoAbaixoDe1QueroErro() {
        var pessoa = new PessoaModel();
        pessoa.setAltura(1.83);
        pessoa.setPeso(0.0);
        Double peso = 0.0;
        var valorInvalido = service.calcularImc(pessoa);
        assertEquals(peso, valorInvalido.getPeso());
    }

    @Test
    public void quandoPassarPessoaModelIMCValido() {
        var pessoa = new PessoaModel();
        pessoa.setAltura(1.83);
        pessoa.setPeso(83.0);
        Double imc = 25.0;
        var valorValido = service.calcularImc(pessoa);
        assertEquals(imc, valorValido.getImc());
    }

    @Test
    public void quandoPesoforMenorOuIgualZeroIMCNUll() {
        var pessoa = new PessoaModel();
        pessoa.setAltura(1.83);
        pessoa.setPeso(0.0);
        var valorValido = service.calcularImc(pessoa);
        assertNull(valorValido.getImc());
    }

    @Test
    public void quandoAlturaforMenorOuIgualZeroIMCNUll() {
        var pessoa = new PessoaModel();
        pessoa.setAltura(0.0);
        pessoa.setPeso(83.0);
        var valorValido = service.calcularImc(pessoa);
        assertNull(valorValido.getImc());
    }

}