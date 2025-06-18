package com.floresdecarbono.myEcclesia.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.floresdecarbono.myEcclesia.entities.enums.Cargo;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_USERS")
public class User extends RepresentationModel<User> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    private Integer cargo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "lider", fetch = FetchType.LAZY)
    private Set<Departamento> liderandos = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "escalados", fetch = FetchType.LAZY)
    private Set<Evento> escalas = new HashSet<>();

    public User() {}

    public User(UUID id, String username, String cpf, String email, String password, Cargo cargo) {
        this.id = id;
        this.username = username;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        setCargo(cargo);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cargo getCargo() {
        return Cargo.valueOf(cargo);
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo.getCode();
    }

    public Set<Departamento> getLiderandos() {
        return liderandos;
    }

    public void setLiderandos(Set<Departamento> liderandos) {
        this.liderandos = liderandos;
    }

    public Set<Evento> getEscalas() {
        return escalas;
    }

    public void setEscalas(Set<Evento> escalas) {
        this.escalas = escalas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
