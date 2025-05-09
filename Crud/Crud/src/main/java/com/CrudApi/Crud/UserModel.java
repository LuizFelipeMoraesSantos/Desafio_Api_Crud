package com.CrudApi.Crud;

import jakarta.persistence.*;
import java.time.LocalDate;
// Crie sem o nome "model" na entidade
@Entity
@Table(name = "tb_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // n tinha, precisa ter a strategy pra gerar essa regra no db
    private Long id;
    private String name;
    private String email;
    private String senha;
    private LocalDate data;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;
    private Boolean ativo;

    public UserModel(String name, String email, String senha,
                     LocalDate data, String telefone, String endereco,
                     String cidade, String estado, Boolean ativo) {
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.data = data;  // Corrigido para 'data'
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.ativo = ativo;
    }

    public UserModel() {}

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getData() {
        return data;  // Corrigido para 'data'
    }

    public void setData(LocalDate data) {
        this.data = data;  // Corrigido para 'data'
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
