package com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.controller;

import com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.model.Turma;
import com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.service.TurmaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public ResponseEntity<List<Turma>> listarTurmas() {
        List<Turma> turmas = turmaService.encontrarTodasTurmas();
        if (turmas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(turmas);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarTurmaPorId(@PathVariable Integer id) {
        Optional<Turma> turma = turmaService.buscarTurmaPorId(id);
        return turma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Turma> criarTurma(@RequestBody Turma turma) {
        Turma turmaSalva = turmaService.salvarTurma(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizarTurma(@PathVariable Integer id, @RequestBody Turma turma) {
        Optional<Turma> turmaExistente = turmaService.buscarTurmaPorId(id);
        if (turmaExistente.isPresent()) {
            Turma turmaAtualizada = turmaExistente.get();
            turmaAtualizada.setDuracao(turma.getDuracao());
            turmaAtualizada.setHorario(turma.getHorario());
            turmaAtualizada.setDataInicio(turma.getDataInicio());
            turmaAtualizada.setDataFim(turma.getDataFim());
            turmaAtualizada.setInstrutor(turma.getInstrutor());
            turmaService.salvarTurma(turmaAtualizada);
            return ResponseEntity.ok(turmaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Integer id) {
        Optional<Turma> turma = turmaService.buscarTurmaPorId(id);
        if (turma.isPresent()) {
            turmaService.deletarTurma(turma.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
