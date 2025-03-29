package com.ccondoproduct.connect.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ocorrencias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusOcorrencia status;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private String imagemUrl;

    private String morador;
}
