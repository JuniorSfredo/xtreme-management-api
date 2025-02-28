package com.juniorsfredo.xtreme_management_api.domain.models;

import com.juniorsfredo.xtreme_management_api.domain.models.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_mensalidade")
@Getter
@Setter
@EqualsAndHashCode
public class Mensalidade {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataVencimento;

    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;
}
