package com.example.webecom.dto.request;

import javax.persistence.Column;
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
public class AuthRequestDTO {
  @Pattern(regexp = ("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"), message = "Invalid email")
  @Size(max = 30, min = 10, message = "Invalid mail size")
  private String email;

  @Size(max = 12, min = 9, message = "Invalid phone size")
  private String phone;

  @NotNull(message = "Password is required")
  private String password;
}
