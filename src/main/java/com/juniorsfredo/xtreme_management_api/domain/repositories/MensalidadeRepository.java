package com.juniorsfredo.xtreme_management_api.domain.repositories;

import com.juniorsfredo.xtreme_management_api.domain.models.Mensalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long> {

    @Query("SELECT m FROM Mensalidade m " +
            "JOIN FETCH m.aluno a " +
            "JOIN FETCH m.plano p " +
            "WHERE a.id = ?1 " +
            "ORDER BY m.dataVencimento DESC"
    )
    List<Mensalidade> findMensalidadeByAlunoId(Long alunoId);
}
