package com.ccondoproduct.connect.service;

import com.ccondoproduct.connect.model.Agendamento;
import com.ccondoproduct.connect.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    public List<Agendamento> listarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return agendamentoRepository.findByDataHoraBetween(inicio, fim);
    }

    public Agendamento criar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento atualizar(Long id, Agendamento agendamentoAtualizado) {
        return agendamentoRepository.findById(id)
                .map(agendamento -> {
                    agendamento.setArea(agendamentoAtualizado.getArea());
                    agendamento.setSolicitante(agendamentoAtualizado.getSolicitante());
                    agendamento.setTelefone(agendamentoAtualizado.getTelefone());
                    agendamento.setDataHora(agendamentoAtualizado.getDataHora());
                    agendamento.setConfirmado(agendamentoAtualizado.isConfirmado());
                    return agendamentoRepository.save(agendamento);
                })
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }

    public Map<String, Long> obterEstatisticas() {
        return agendamentoRepository.findAll().stream()
                .collect(Collectors.groupingBy(a -> a.getArea().name(), Collectors.counting()));
    }
}
