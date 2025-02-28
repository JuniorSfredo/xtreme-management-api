package com.juniorsfredo.xtreme_management_api.domain.services;

import com.juniorsfredo.xtreme_management_api.domain.models.Exercicio;
import com.juniorsfredo.xtreme_management_api.domain.repositories.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    public List<Exercicio> getExerciciosByTreinoId(Long treinoId) {
        return exercicioRepository.findExerciciosByTreinoId(treinoId);
    }
}
