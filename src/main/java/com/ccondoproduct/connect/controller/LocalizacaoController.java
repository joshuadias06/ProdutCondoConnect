package com.ccondoproduct.connect.controller;

import com.ccondoproduct.connect.model.Localizacao;
import com.ccondoproduct.connect.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @PostMapping
    public Localizacao cadastrarEndereco(@RequestBody Localizacao localizacao) {
        return localizacaoService.salvar(localizacao);
    }

    @GetMapping("/ultima")
    public Localizacao obterUltimaLocalizacao() {
        return localizacaoService.buscarUltimaLocalizacao();
    }
}
