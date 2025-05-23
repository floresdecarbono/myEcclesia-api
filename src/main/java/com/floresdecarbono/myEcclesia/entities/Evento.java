package com.floresdecarbono.myEcclesia.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.floresdecarbono.myEcclesia.entities.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_EVENTOS")
public class Evento {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime dataInicio;
    @Column(nullable = false)
    private LocalDateTime dataFinal;

    @OneToOne
    private Endereco local;

    private Integer tipo;

    @ManyToMany
    @JoinTable(name = "TB_ENVOLVIDOS_EVENTOS", joinColumns = @JoinColumn(name = "eventos_id"), inverseJoinColumns = @JoinColumn(name = "escalados_id"))
    private Set<User> escalados = new HashSet<>();

    public Evento() {}

    public Evento(UUID id, String nome, LocalDateTime dataInicio, LocalDateTime dataFinal, Endereco local, TipoEvento tipo) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.local = local;
        setTipo(tipo);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Endereco getLocal() {
        return local;
    }

    public void setLocal(Endereco local) {
        this.local = local;
    }

    public TipoEvento getTipo() {
        return TipoEvento.valueOf(tipo);
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo.getCode();
    }

    public Set<User> getEscalados() {
        return escalados;
    }

    public void setEscalados(Set<User> escalados) {
        this.escalados = escalados;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(id, evento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
