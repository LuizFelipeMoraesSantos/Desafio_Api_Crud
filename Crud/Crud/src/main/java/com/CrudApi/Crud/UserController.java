package com.CrudApi.Crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
//A url Precisa ser referente ao que ta sendo trabalhando, e no plural
@RequestMapping("/users")
public class UserController {
// Não se coloca /caminho para Post ou Get de um endpoint, o proprio RequestMapping principal ja deve servir, apenas troca o verbo http
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public ResponseEntity<Void> cadastrar(@RequestBody UserRequestDTO dto) {
        UserResponseDTO userResponse = service.cadastrar(dto);
        // Supondo que o ID do usuário tenha sido gerado no cadastro
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userResponse.getId())
                .toUri();
        return ResponseEntity.created(location).build(); // N pode retornar Body, apenas o location e e o codigo http

    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> atualizar(@PathVariable Long id,
                                                     @RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
