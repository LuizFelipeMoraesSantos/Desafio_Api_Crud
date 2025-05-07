package com.CrudApi.Crud;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    public void createUser(UserRequestDTO userRequestDTO) {
        UserModel user = new UserModel();
    }
    public void deleteUser(Long id) {
    }

    public void updateUser(UserRequestDTO userRequestDTO) {
    }

    */
    public List<UserResponseDTO> listarTodos() {

        List<UserModel> usuarios = userRepository.findAll();

        if (usuarios == null || usuarios.isEmpty()) {
            return List.of();
        }
        return usuarios.stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getData(),
                        user.getTelefone(),
                        user.getEndereco(),
                        user.getCidade(),
                        user.getEstado(),
                        user.getAtivo()
                ))
                .collect(Collectors.toList());
    }

    /*
    public UserResponseDTO cadastrar(UserRequestDTO dto) {
        return null;
    }

    */

    public UserResponseDTO cadastrar(UserRequestDTO dto) {

        UserModel user = new UserModel();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getSenha());
        user.setData(dto.getDataNascimento());
        user.setTelefone(dto.getTelefone());
        user.setEndereco(dto.getEndereco());
        user.setCidade(dto.getCidade());
        user.setEstado(dto.getEstado());
        user.setAtivo(dto.getAtivo());

        user = userRepository.save(user);

        // Retorna a resposta no formato DTO
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getData(),
                user.getTelefone(),
                user.getEndereco(),
                user.getCidade(),
                user.getEstado(),
                user.getAtivo()
        );
    }

    public UserResponseDTO buscarPorId(Long id) {
        UserModel usuario = userRepository.findById(id).orElse(null);

        if (usuario == null) {
            return null;  // Ou você pode lançar uma exceção personalizada para quando o usuário não for encontrado
        }

        // Mapeando o UserModel para UserResponseDTO
        return new UserResponseDTO(
                usuario.getId(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getData(),
                usuario.getTelefone(),
                usuario.getEndereco(),
                usuario.getCidade(),
                usuario.getEstado(),
                usuario.getAtivo()
        );
    }

    public void deletar(Long id) {
        userRepository.deleteById(id);
    }

    public UserResponseDTO atualizar(Long id, UserRequestDTO dto) {
        UserModel usuario = userRepository.findById(id).orElse(null);

        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado para o id: " + id);
        }

        usuario.setName(dto.getName());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setData(dto.getDataNascimento());
        usuario.setTelefone(dto.getTelefone());
        usuario.setEndereco(dto.getEndereco());
        usuario.setCidade(dto.getCidade());
        usuario.setEstado(dto.getEstado());
        usuario.setAtivo(dto.getAtivo());

        usuario = userRepository.save(usuario);

        return new UserResponseDTO(
                usuario.getId(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getData(),
                usuario.getTelefone(),
                usuario.getEndereco(),
                usuario.getCidade(),
                usuario.getEstado(),
                usuario.getAtivo()
        );
    }

}