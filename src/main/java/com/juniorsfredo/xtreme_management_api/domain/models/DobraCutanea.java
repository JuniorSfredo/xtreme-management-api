package com.juniorsfredo.xtreme_management_api.domain.models;

import com.juniorsfredo.xtreme_management_api.domain.models.enums.DobrasCutaneas;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_dobra_cutanea")
@Getter
@Setter
@EqualsAndHashCode
public class DobraCutanea {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DobrasCutaneas dobra;

    private Double mm;

    @ManyToOne
    @JoinColumn(name = "avaliacao_id")
    private Avaliacao avaliacao;
}
