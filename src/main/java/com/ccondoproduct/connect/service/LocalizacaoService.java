package com.ccondoproduct.connect.service;

import com.ccondoproduct.connect.model.Localizacao;
import com.ccondoproduct.connect.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public Localizacao salvar(Localizacao localizacao) {
        return localizacaoRepository.save(localizacao);
    }

    public Localizacao buscarUltimaLocalizacao() {
        return localizacaoRepository.findAll().stream().reduce((first, second) -> second).orElse(null);
    }
}
