package com.ccondoproduct.connect.controller;

import com.ccondoproduct.connect.model.Ocorrencia;
import com.ccondoproduct.connect.service.OcorrenciaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ocorrencia> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Ocorrencia buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Ocorrencia criar(@RequestBody Ocorrencia ocorrencia) {
        return service.criar(ocorrencia);
    }

    @PutMapping("/{id}")
    public Ocorrencia atualizar(@PathVariable Long id, @RequestBody Ocorrencia ocorrencia) {
        return service.atualizar(id, ocorrencia);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

