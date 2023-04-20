package com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.service;

import com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.model.Turma;
import com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<Turma> encontrarTodasTurmas() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> buscarTurmaPorId(Integer id) {
        return turmaRepository.findById(id);
    }

    public Turma salvarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void deletarTurma(Turma turma) {
        if (turma != null) {
            turmaRepository.delete(turma);
        }
    }
}
