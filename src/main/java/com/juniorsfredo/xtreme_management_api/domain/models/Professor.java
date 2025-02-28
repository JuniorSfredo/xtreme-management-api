package com.juniorsfredo.xtreme_management_api.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_professor")
@Getter
@Setter
public class Professor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataContratacao;
    private Double salario;

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<Treino> treinos = new ArrayList<>();

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<Avaliacao> avaliacoes = new ArrayList<>();
}
