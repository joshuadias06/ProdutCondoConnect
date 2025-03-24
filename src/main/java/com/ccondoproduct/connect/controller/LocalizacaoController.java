package com.ccondoproduct.connect.controller;

import com.ccondoproduct.connect.model.Localizacao;
import com.ccondoproduct.connect.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/localizacoes") // Agora a URL será /localizacoes
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Localizacao cadastrarEndereco(@RequestBody Localizacao localizacao) {
        return localizacaoService.salvar(localizacao);
    }

    @GetMapping("/ultima")
    public ResponseEntity<Localizacao> obterUltimaLocalizacao() {
        Optional<Localizacao> ultimaLocalizacao = Optional.ofNullable(localizacaoService.buscarUltimaLocalizacao());

        return ultimaLocalizacao
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}