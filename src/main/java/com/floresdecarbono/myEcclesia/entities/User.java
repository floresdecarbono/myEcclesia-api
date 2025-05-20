package com.floresdecarbono.myEcclesia.entities;

import com.floresdecarbono.myEcclesia.entities.enums.Cargo;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String cpf;
    private String email;
    private String password;

    private Integer cargo;

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
