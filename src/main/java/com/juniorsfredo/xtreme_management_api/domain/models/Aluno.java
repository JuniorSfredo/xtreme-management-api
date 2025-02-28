package com.juniorsfredo.xtreme_management_api.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_aluno")
@Getter
@Setter
public class Aluno extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean ativo;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "aluno")
    private List<Treino> treinos = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    private List<Mensalidade> mensalidades = new ArrayList<>();
}
