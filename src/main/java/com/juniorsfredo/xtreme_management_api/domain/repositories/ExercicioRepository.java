package com.juniorsfredo.xtreme_management_api.domain.repositories;

import com.juniorsfredo.xtreme_management_api.domain.models.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

    @Query("select ex from Exercicio ex JOIN ex.treinos tr where tr.id = ?1")
    List<Exercicio> findExerciciosByTreinoId(Long id);
}
