package com.juniorsfredo.xtreme_management_api.domain.repositories;

import com.juniorsfredo.xtreme_management_api.domain.models.Avaliacao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AvalicaoRepository extends JpaRepository<Avaliacao, Long> {

    @Query("select av from Avaliacao " +
            "av join fetch av.aluno a " +
            "where av.status = 'CONCLUIDO' " +
            "and a.id = ?1 " +
            "order by av.data desc")
    List<Avaliacao> find2UltimasAvaliacoesByAlunoId(Long alunoId, Pageable pageable);

    @Query("select av from Avaliacao av " +
            "join fetch av.aluno a " +
            "where a.id = ?1 " +
            "and av.status = 'CONCLUIDO'")
    List<Avaliacao> findAvaliacoesByAlunoId(Long alunoId);

    @Query("select 1 from Avaliacao a where a.data > ?1 and a.data < ?2")
    Optional<Integer> existsAvaliacaoBetween2Datas(LocalDateTime dataInicio, LocalDateTime dataFim);


}
