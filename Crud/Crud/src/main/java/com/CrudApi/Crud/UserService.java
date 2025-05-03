package com.CrudApi.Crud;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void createUser(UserRequestDTO userRequestDTO) {
        UserModel user = new UserModel();
    }
    public void deleteUser(Long id) {
    }
    public void updateUser(UserRequestDTO userRequestDTO) {
    }

}