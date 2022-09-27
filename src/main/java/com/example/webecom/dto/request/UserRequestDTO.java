package com.example.webecom.dto.request;

import com.example.webecom.entities.Role;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDTO {
  private String name;
  @NotNull(message="An email is required!")
  @Size(message="Invalid size.", max = 320, min=10)
  @Pattern(regexp=("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"), message = "Invalid email")
  private String email;
  private String phone;
  private String password;
  private boolean enable;
  private int role;
}
