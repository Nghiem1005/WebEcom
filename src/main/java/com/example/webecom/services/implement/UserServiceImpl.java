package com.example.webecom.services.implement;

import com.example.webecom.dto.request.UserRequestDTO;
import com.example.webecom.dto.response.AuthResponseDTO;
import com.example.webecom.dto.response.ResponseObject;
import com.example.webecom.dto.response.UserReponseDTO;
import com.example.webecom.entities.Role;
import com.example.webecom.entities.User;
import com.example.webecom.mapper.UserMapper;
import com.example.webecom.repositories.RoleRepository;
import com.example.webecom.repositories.UserRepository;
import com.example.webecom.services.UserService;
import javax.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

  @Autowired private UserRepository userRepository;

  @Autowired private PasswordEncoder passwordEncoder;

  @Autowired private RoleRepository roleRepository;

  @Override
  public AuthResponseDTO findUserByEmailAndPassword(String email, String password) {
    return null;
  }

  @Override
  public ResponseEntity<ResponseObject> saveUser(UserRequestDTO userRequestDTO) {
    User user = mapper.userRequestDTOtoUser(userRequestDTO);
    encodePassword(user);
    //Need custom exception
    Role role = roleRepository.findRoleById(user.getRole().getId()).orElseThrow(() -> new NotFoundException("Could not find any role with ID \" + id"));
    user.setRole(role);
    User userResponse = null;
    try{
      userResponse = userRepository.save(user);
    } catch (RuntimeException e){
      throw new RuntimeException("Failed to save user: " + e.getMessage());
    }
    UserReponseDTO userReponseDTO = mapper.userToUserResponseDTO(userResponse);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseObject(HttpStatus.OK, "Create new feedback successfully!", userReponseDTO));
  }

  private void encodePassword(User user){
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
  }
}
