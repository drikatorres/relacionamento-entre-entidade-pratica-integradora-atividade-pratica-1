package com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.controller;

import com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.model.Instrutor;
import com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @GetMapping
    public ResponseEntity<List<Instrutor>> listarTodosInstrutores() {
        List<Instrutor> instrutores = instrutorService.encontrarTodosInstrutores();
        if (instrutores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(instrutores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> buscarInstrutorPorId(@PathVariable Integer id) {
        Optional<Instrutor> instrutor = instrutorService.encontrarInstrutorPorId(id);
        return instrutor.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Instrutor> salvarInstrutor(@RequestBody Instrutor instrutor) {
        Instrutor instrutorSalvo = instrutorService.salvarInstrutor(instrutor);
        return new ResponseEntity<>(instrutorSalvo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrutor> atualizarInstrutor(@PathVariable Integer id, @RequestBody Instrutor instrutorAtualizado) {
        Optional<Instrutor> instrutor = instrutorService.encontrarInstrutorPorId(id);
        if (instrutor.isPresent()) {
            instrutorAtualizado.setId(id);
            Instrutor instrutorSalvo = instrutorService.salvarInstrutor(instrutorAtualizado);
            return new ResponseEntity<>(instrutorSalvo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarInstrutor(@PathVariable Integer id) {
        Optional<Instrutor> instrutor = instrutorService.encontrarInstrutorPorId(id);
        if (instrutor.isPresent()) {
            instrutorService.deletarInstrutor(instrutor.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
