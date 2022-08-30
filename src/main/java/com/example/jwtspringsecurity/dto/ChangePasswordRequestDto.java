package com.example.jwtspringsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//비밀번호 수정시 사용하는 dto
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequestDto {
  private String email;
  private String exPassword;
  private String newPassword;
}
