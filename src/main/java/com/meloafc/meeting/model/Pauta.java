package com.meloafc.meeting.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pauta")
public class Pauta implements BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="assunto")
    private String assunto;

    @Column(name="inicio_votacao")
    private LocalDateTime inicioVotacao;

    @Column(name="duracao_votacao_minutos")
    private Long duracaoVotacaoMinutos;

}
