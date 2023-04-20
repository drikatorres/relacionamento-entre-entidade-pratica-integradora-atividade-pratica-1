package com.atividadepraticaintegradoratecnologiasdisruptivas.relacionamentoentreentidade.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "horario")
    private Time horario;
    @Column(name = "duracao")
    private int duracao;
    @Column(name = "data inicio")
    private Date dataInicio;
    @Column(name = "data fim")
    private Date dataFim;
    @ManyToOne
    @JoinColumn(name = "id_instrutor", referencedColumnName = "id")
    @Column(name = "instrutor")
    private Instrutor instrutor;

    public Turma() {
    }

    public Turma(int id, Time horario, int duracao, Date dataInicio, Date dataFim, Instrutor instrutor) {
        this.id = id;
        this.horario = horario;
        this.duracao = duracao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.instrutor = instrutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", horario=" + horario +
                ", duracao=" + duracao +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", instrutor=" + instrutor +
                '}';
    }
}
