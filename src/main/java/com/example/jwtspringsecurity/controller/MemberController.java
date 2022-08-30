package com.example.jwtspringsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jwtspringsecurity.dto.ChangePasswordRequestDto;
import com.example.jwtspringsecurity.dto.MemberRequestDto;
import com.example.jwtspringsecurity.dto.MemberResponseDto;
import com.example.jwtspringsecurity.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
  private final MemberService memberService;

  @GetMapping("/me")
  public ResponseEntity<MemberResponseDto> getMyMemberInfo() {
    return ResponseEntity.ok(memberService.getMyInfo());
  }

  @GetMapping("/{email}")
  public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable String email) {
    return ResponseEntity.ok(memberService.getMemberInfo(email));
  }

  @PostMapping("/nickname")
  public ResponseEntity<MemberResponseDto> setMemberNickname(
      @RequestBody MemberRequestDto request) {
    return ResponseEntity
        .ok(memberService.changeMemberNickname(request.getEmail(), request.getNickname()));
  }

  @PostMapping("/password")
  public ResponseEntity<MemberResponseDto> setMemberPassword(
      @RequestBody ChangePasswordRequestDto request) {
    return ResponseEntity
        .ok(memberService.changeMemberPassword(request.getExPassword(), request.getNewPassword()));
  }
}
