package com.juniorsfredo.xtreme_management_api.domain.repositories;

import com.juniorsfredo.xtreme_management_api.domain.models.Avaliacao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvalicaoRepository extends JpaRepository<Avaliacao, Long> {

    @Query("select av from Avaliacao av join fetch av.aluno a where a.id = ?1 order by av.data desc")
    List<Avaliacao> find2UltimasAvaliacoesByAlunoId(Long alunoId, Pageable pageable);

    @Query("select av from Avaliacao av join fetch av.aluno a where a.id = ?1")
    List<Avaliacao> findAvaliacoesByAlunoId(Long alunoId);


}
