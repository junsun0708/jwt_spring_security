package com.example.jwtspringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecurityApplication.class, args);
	}
	
	/**
	 * 
	 * \\
	 참고 : https://bcp0109.tistory.com/301
	 
1. signup (가입)
# Request
POST http://localhost:8080/auth/signup
Content-Type: application/json

{
  "email": "test@test.net",
  "password": "1q2w3e4r"
}

# Response
{
  "email": "test@test.net"
}

2.login (로그인)
# Request
POST http://localhost:8080/auth/login
Content-Type: application/json

{
  "email": "test@test.net",
  "password": "1q2w3e4r"
}

# Response
{
  "grantType": "bearer",
  "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTYxNTExNDI4MH0.43LvabP41Awhicy6YYAYHtDPnxNYpEygtE-DjLaDjNpAxZf01Nx4xE_dGk0V4jBpjwCgKVGKZIMyEeIppwzARQ",
  "refreshToken": "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTU3MTcyODB9.DKqk-EZVT0TJAvvHpSN8nClIHKq-k4KYMHpx-Ltf7V8OB6Og4D_dsYnr3Z4Rw7iR7ckv-ZWMyi5SkheESw-T0g",
  "accessTokenExpiresIn": 1615114280584
}

3. member/me (일반api인증)
# Request
GET http://localhost:8080/member/me
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTYxNTExNDI4MH0.43LvabP41Awhicy6YYAYHtDPnxNYpEygtE-DjLaDjNpAxZf01Nx4xE_dGk0V4jBpjwCgKVGKZIMyEeIppwzARQ

# Response
{
  "email": "test@test.net"
}

4. reissue (재발급)
# Request
POST http://localhost:8080/auth/reissue
Content-Type: application/json

{
  "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTYxNTExNDI4MH0.43LvabP41Awhicy6YYAYHtDPnxNYpEygtE-DjLaDjNpAxZf01Nx4xE_dGk0V4jBpjwCgKVGKZIMyEeIppwzARQ",
  "refreshToken": "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTU3MTcyODB9.DKqk-EZVT0TJAvvHpSN8nClIHKq-k4KYMHpx-Ltf7V8OB6Og4D_dsYnr3Z4Rw7iR7ckv-ZWMyi5SkheESw-T0g"
}

# Response
{
  "grantType": "bearer",
  "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTYxNTExNDM2NX0.5VXa6Cht_DPEEGe7-BrElvsrs7qRXmVnkDdi4Lm3PxZ0vAgqFdirhe5RlE1D-Wc1zaUepBmGhhw-u-oP_-rbKQ",
  "refreshToken": "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTU3MTczNjV9.tZytWyCWkWIYitvT3pa8FSnxilBDMtSevUzKRFK21TGLITf2eLXEwNNS_Q7rylD9uUe3Rx9ZR2NVqE_ZNWxTqg",
  "accessTokenExpiresIn": 1615114365284
}

	 * 
	 */

}
