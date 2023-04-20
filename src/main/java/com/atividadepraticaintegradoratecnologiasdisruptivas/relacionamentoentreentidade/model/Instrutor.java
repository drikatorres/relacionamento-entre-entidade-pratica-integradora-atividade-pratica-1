package com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "instrutor")
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "rg")
    private int rg;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nascimento")
    private Date nascimento;
    @Column(name = "titulacao")
    private int titulacao;

    @OneToMany(mappedBy = "instrutor")
    private Set<Turma> turmas;

    public Instrutor() {
    }

    public Instrutor(int id, int rg, String nome, Date nascimento, int titulacao, Set<Turma> turmas) {
        this.id = id;
        this.rg = rg;
        this.nome = nome;
        this.nascimento = nascimento;
        this.titulacao = titulacao;
        this.turmas = turmas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public int getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(int titulacao) {
        this.titulacao = titulacao;
    }

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public String toString() {
        return "Instrutor{" +
                "id=" + id +
                ", rg=" + rg +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", titulacao=" + titulacao +
                ", turmas=" + turmas +
                '}';
    }
}
