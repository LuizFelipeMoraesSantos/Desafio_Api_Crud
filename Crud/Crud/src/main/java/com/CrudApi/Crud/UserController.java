package com.CrudApi.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public ResponseEntity<String> createUser(UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<String> deleteUser(Long id) {
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<String> updateUser(UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<UserResponseDTO> getUser(Long id) {
        return ResponseEntity.ok().build();
    }



}
