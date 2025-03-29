package com.ccondoproduct.connect.service;

import com.ccondoproduct.connect.model.Agendamento;
import com.ccondoproduct.connect.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<Agendamento> listarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return agendamentoRepository.findByDataBetween(inicio, fim);
    }

    public Agendamento criar(Agendamento agendamento) {
        if (agendamento.getData() == null) {
            throw new IllegalArgumentException("A data do agendamento é obrigatória.");
        }
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento atualizar(Long id, Agendamento agendamentoAtualizado) {
        return agendamentoRepository.findById(id)
                .map(agendamento -> {
                    agendamento.setArea(agendamentoAtualizado.getArea());
                    agendamento.setSolicitante(agendamentoAtualizado.getSolicitante());
                    agendamento.setTelefone(agendamentoAtualizado.getTelefone());
                    agendamento.setData(agendamentoAtualizado.getData());
                    return agendamentoRepository.save(agendamento);
                })
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }

    public Map<LocalDate, List<Agendamento>> obterAgendamentosPorDia() {
        return agendamentoRepository.findAll().stream()
                .collect(Collectors.groupingBy(Agendamento::getData));
    }

    public Map<String, Long> obterEstatisticas() {
        return agendamentoRepository.findAll().stream()
                .collect(Collectors.groupingBy(a -> a.getArea().name(), Collectors.counting()));
    }

    public List<Agendamento> listarPorDia(LocalDate data) {
        return agendamentoRepository.findByData(data);  // Alteração para utilizar o método correto
    }

}
