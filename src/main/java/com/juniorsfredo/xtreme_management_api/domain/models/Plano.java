package com.juniorsfredo.xtreme_management_api.domain.models;

import com.juniorsfredo.xtreme_management_api.domain.models.enums.TiposPlanos;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_plano")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TiposPlanos plano;

    private Double valor;

    @OneToMany(mappedBy = "plano")
    private List<Mensalidade> mensalidades = new ArrayList<>();
}
