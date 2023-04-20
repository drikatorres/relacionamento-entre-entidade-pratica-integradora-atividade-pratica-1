package com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.service;


import com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.model.Instrutor;
import com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.repository.InstrutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrutorService {
    private final InstrutorRepository instrutorRepository;

    public InstrutorService(InstrutorRepository instrutorRepository) {
        this.instrutorRepository = instrutorRepository;
    }

    public List<Instrutor> encontrarTodosInstrutores() {
        return instrutorRepository.findAll();
    }

    public Optional<Instrutor> encontrarInstrutorPorId(Integer id) {
        return instrutorRepository.findById(id);
    }

    public Instrutor salvarInstrutor(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public void deletarInstrutor(Instrutor instrutor) {
        if (instrutor != null) {
            instrutorRepository.delete(instrutor);
        }
    }
}
