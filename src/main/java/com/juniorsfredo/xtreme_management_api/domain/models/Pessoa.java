package com.juniorsfredo.xtreme_management_api.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public class Pessoa {

    @Column(nullable = false)
    private String nome;

    private String cpf;

    private Double altura;

    private Double peso;

    private LocalDate dataNascimento;

    private String endereco;
}
