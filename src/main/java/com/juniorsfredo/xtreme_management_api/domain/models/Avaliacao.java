package com.juniorsfredo.xtreme_management_api.domain.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_avaliacao")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Avaliacao {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double peso;

    private Double percentualDeGordura;

    private Double imc;

    private String observacao;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(mappedBy = "avaliacao")
    private List<DobraCutanea> dobrasCutaneas = new ArrayList<>();
}
