package com.CrudApi.Crud;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponseDTO cadastrar(UserRequestDTO dto) {
        validarDados(dto);

        User user = new User();
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(passwordEncoder.encode(dto.getSenha()));
        user.setDataNascimento(dto.getDataNascimento());
        user.setTelefone(dto.getTelefone());
        user.setEndereco(dto.getEndereco());
        user.setCidade(dto.getCidade());
        user.setEstado(dto.getEstado());
        user.setAtivo(dto.getAtivo());

        User salvo = repository.save(user);
        return toResponseDTO(salvo);
    }

