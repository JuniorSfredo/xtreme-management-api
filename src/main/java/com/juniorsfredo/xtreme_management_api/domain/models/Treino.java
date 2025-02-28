package com.juniorsfredo.xtreme_management_api.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.juniorsfredo.xtreme_management_api.domain.models.enums.Musculos;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_treino")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Treino {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Musculos nome;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_treino_exercicio",
               joinColumns = @JoinColumn(name = "treino_id"),
               inverseJoinColumns = @JoinColumn(name = "exercicio_id")
    )
    private List<Exercicio> exercicios = new ArrayList<>();
}
