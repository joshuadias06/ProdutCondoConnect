package com.ccondoproduct.connect.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EspacoCondominio area;

    @Column(nullable = false)
    private String solicitante;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private boolean confirmado = false;
}
