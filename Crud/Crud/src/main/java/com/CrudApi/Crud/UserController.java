package com.CrudApi.Crud;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;


    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


   public ResponseEntity<?> updateUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.updateUser(userRequestDTO);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<UserResponseDTO> getUser(Long id) {
        return ResponseEntity.ok().build();
    }


}
