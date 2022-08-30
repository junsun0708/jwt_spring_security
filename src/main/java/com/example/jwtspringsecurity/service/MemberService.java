package com.example.jwtspringsecurity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.jwtspringsecurity.dto.MemberResponseDto;
import com.example.jwtspringsecurity.entity.Member;
import com.example.jwtspringsecurity.repository.MemberRepository;
import com.example.jwtspringsecurity.util.SecurityUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  @Transactional(readOnly = true)
  public MemberResponseDto getMemberInfo(String email) {
    return memberRepository.findByEmail(email).map(MemberResponseDto::of)
        .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
  }

  // 현재 SecurityContext 에 있는 유저 정보 가져오기
  @Transactional(readOnly = true)
  public MemberResponseDto getMyInfo() {
    return memberRepository.findById(SecurityUtil.getCurrentMemberId()).map(MemberResponseDto::of)
        .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
  }

  @Transactional
  public MemberResponseDto changeMemberNickname(String email, String nickname) {
    Member member = memberRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
    member.setNickname(nickname);
    return MemberResponseDto.of(memberRepository.save(member));
  }

  @Transactional
  public MemberResponseDto changeMemberPassword(String exPassword,
      String newPassword) {
    Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId())
        .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
    if (!passwordEncoder.matches(exPassword, member.getPassword())) {
      throw new RuntimeException("비밀번호가 맞지 않습니다");
    }
    member.setPassword(passwordEncoder.encode((newPassword)));
    return MemberResponseDto.of(memberRepository.save(member));
  }
}
