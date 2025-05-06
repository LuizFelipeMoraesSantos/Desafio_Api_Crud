package com.CrudApi.Crud;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    public void createUser(UserRequestDTO userRequestDTO) {
        UserModel user = new UserModel();
    }
    public void deleteUser(Long id) {
    }

    public void updateUser(UserRequestDTO userRequestDTO) {
    }

    public List<UserResponseDTO> listarTodos() {
        return null;
    }

    public UserResponseDTO cadastrar(UserRequestDTO dto) {
        return null;
    }

    public UserResponseDTO buscarPorId(Long id) {
        return null;
    }

    public void deletar(Long id) {
        return;
    }

    public UserResponseDTO atualizar(Long id, UserRequestDTO dto) {
        return null;
    }
}