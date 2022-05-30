package br.com.confidencecambio.javabasico.controller;

import br.com.confidencecambio.javabasico.dto.PessoaIMCDTO;
import br.com.confidencecambio.javabasico.models.PessoaModel;
import br.com.confidencecambio.javabasico.service.ImcService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/imc")
@AllArgsConstructor
public class ImcController {

    final ImcService imcService;

    @PostMapping
    public ResponseEntity<Object> getImc(@RequestBody @Valid PessoaIMCDTO imcDTO) {
        var pessoaNova = new PessoaModel();
        BeanUtils.copyProperties(imcDTO, pessoaNova);
        return ResponseEntity.status(HttpStatus.OK).body(imcService.calcularImc(pessoaNova));
    }
}
