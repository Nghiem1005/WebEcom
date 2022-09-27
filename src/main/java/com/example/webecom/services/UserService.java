package com.example.webecom.services;

import com.example.webecom.dto.request.UserRequestDTO;
import com.example.webecom.dto.response.AuthResponseDTO;
import com.example.webecom.dto.response.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface UserService {
  AuthResponseDTO findUserByEmailAndPassword(String email, String password);
  ResponseEntity<ResponseObject> saveUser(UserRequestDTO userRequestDTO);
}
