package com.example.webecom.dto.response;

import com.example.webecom.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserReponseDTO {
  private Integer id;
  private String name;
  private String email;
  private String phone;
  private boolean enable;
  private Role role;
}
