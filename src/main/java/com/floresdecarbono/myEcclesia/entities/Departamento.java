package com.floresdecarbono.myEcclesia.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_DEPARTAMENTOS")
public class Departamento implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "lider_id")
    private User lider;

    private Set<User> membros = new HashSet<>();

    public Departamento() {}

    public Departamento(UUID id, String nome, User lider) {
        this.id = id;
        this.nome = nome;
        this.lider = lider;
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

    public User getLider() {
        return lider;
    }

    public void setLider(User lider) {
        this.lider = lider;
    }

    public Set<User> getMembros() {
        return membros;
    }

    public void setMembros(Set<User> membros) {
        this.membros = membros;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
