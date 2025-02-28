package com.juniorsfredo.xtreme_management_api.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_exercicio")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Exercicio {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer qtdSeries;

    private Integer minRepeticoes;

    private Integer maxRepeticoes;

    @JsonIgnore
    @ManyToMany(mappedBy = "exercicios")
    private List<Treino> treinos = new ArrayList<>();
}
