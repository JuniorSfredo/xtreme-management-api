package com.juniorsfredo.xtreme_management_api.domain.repositories;

import com.juniorsfredo.xtreme_management_api.domain.models.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TreinoRepository extends JpaRepository<Treino, Long> {

    @Query("select t from Treino t left join fetch t.aluno a left join fetch t.professor p where a.id = :id")
    List<Treino> findTreinosByAlunoId(Long id);
}
