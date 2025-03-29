package com.ccondoproduct.connect.service;

import com.ccondoproduct.connect.model.Ocorrencia;
import com.ccondoproduct.connect.model.StatusOcorrencia;
import com.ccondoproduct.connect.repository.OcorrenciaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository repository;

    public OcorrenciaService(OcorrenciaRepository repository) {
        this.repository = repository;
    }

    public List<Ocorrencia> listarTodas() {
        return repository.findAll();
    }

    public Ocorrencia buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Ocorrência não encontrada"));
    }

    public Ocorrencia criar(Ocorrencia ocorrencia) {
        ocorrencia.setStatus(StatusOcorrencia.PENDENTE);
        return repository.save(ocorrencia);
    }

    public Ocorrencia atualizar(Long id, Ocorrencia ocorrenciaAtualizada) {
        Ocorrencia ocorrencia = buscarPorId(id);
        ocorrencia.setDescricao(ocorrenciaAtualizada.getDescricao());
        ocorrencia.setStatus(ocorrenciaAtualizada.getStatus());
        ocorrencia.setImagemUrl(ocorrenciaAtualizada.getImagemUrl());
        return repository.save(ocorrencia);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
