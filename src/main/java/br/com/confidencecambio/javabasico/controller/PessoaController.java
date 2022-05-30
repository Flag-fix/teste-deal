package br.com.confidencecambio.javabasico.controller;


import br.com.confidencecambio.javabasico.dto.PessoaDTO;
import br.com.confidencecambio.javabasico.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa")
@AllArgsConstructor
public class PessoaController {

    final PessoaService pessoaService;

    @PostMapping("/primeiroNome")
    ResponseEntity<Object> primeiroNome(@RequestBody @Valid PessoaDTO pessoaDTO) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(pessoaService.primeiroNome(pessoaDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
        }
    }

    @PostMapping("/ultimoNome")
    ResponseEntity<Object> ultimoNome(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.ultimoNome(pessoaDTO));
    }

    @PostMapping("/caixaAlta")
    ResponseEntity<Object> caixaAlta(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.nomeCaixaAlta(pessoaDTO));
    }

    @PostMapping("/abreviado")
    ResponseEntity<Object> abreviado(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.nomeAbreviado(pessoaDTO));
    }


}