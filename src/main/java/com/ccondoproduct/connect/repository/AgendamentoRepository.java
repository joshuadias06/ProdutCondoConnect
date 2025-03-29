package com.ccondoproduct.connect.repository;

import com.ccondoproduct.connect.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByDataBetween(LocalDate inicio, LocalDate fim);
    List<Agendamento> findByData(LocalDate data);
}
