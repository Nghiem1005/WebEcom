package com.example.webecom.controller;

import com.example.webecom.dto.request.UserRequestDTO;
import com.example.webecom.dto.response.ResponseObject;
import com.example.webecom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
  @Autowired private UserService userService;
  @PostMapping(value = "")
  public ResponseEntity<ResponseObject> createUser(@ModelAttribute UserRequestDTO userRequestDTO){
    return userService.saveUser(userRequestDTO);
  }

}
