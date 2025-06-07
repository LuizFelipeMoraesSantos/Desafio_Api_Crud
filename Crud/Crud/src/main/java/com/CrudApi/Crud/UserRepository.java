package com.CrudApi.Crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {


    UserModel findByEmail(String email);
    UserModel findByTelefone(String telefone);
    UserModel findBySenha(String senha);

    List<UserModel> findByNome(String nome);
    List<UserModel> findByCidade(String cidade);
    List<UserModel> findByEstado(String estado);
    List<UserModel> findByEndereco(String endereco);

}
