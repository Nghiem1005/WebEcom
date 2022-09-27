package com.example.webecom.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 320, nullable = false, unique = true)
  @Pattern(regexp = ("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"), message = "Invalid email")
  @Size(max = 30, min = 10, message = "Invalid mail size")
  private String email;

  @Column(name = "enable")
  private boolean enable;

  @Column(name = "name", length = 45, nullable = false)
  @NotNull(message = "Name is required")
  private String name;

  @Column(name = "phone", nullable = false, unique = false)
  @Size(max = 12, min = 9, message = "Invalid phone size")
  @NotNull(message = "Phone is required")
  private String phone;

  @Column(name = "password", nullable = false)
  @NotNull(message = "Password is required")
  private String password;

  @Column(name = "images", length = 45)
  private String images;

  @ManyToOne(optional = true)
  @JoinColumn(name = "role_id")
  private Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authorities =new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
    return authorities;
  }

  @Override
  public String getUsername() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enable;
  }
}
