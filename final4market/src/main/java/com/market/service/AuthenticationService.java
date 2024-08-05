package com.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import com.market.config.SecurityConfig;
import com.market.mapper.MemberMapper;
import com.market.models.Member;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthenticationService {

    private final MemberMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final SecretKey key;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    public AuthenticationService(MemberMapper mapper, PasswordEncoder passwordEncoder, @Value("${jwt.secret}") String jwtSecret) {
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder; 
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public Member registerMember(Member member) {
        mapper.insertMember(member);
        return mapper.getMemberWithGradeName(member.getMemberId());
    }

    public String login(String memberId, String memberPasswd) {
        Member member = mapper.getMemberByIdWithPassword(memberId);
        if (member != null) {    	
            boolean isPasswordMatch = passwordEncoder.matches(memberPasswd, member.getMemberPasswd());
            LOGGER.info("비밀번호 일치 여부: {}", isPasswordMatch);

            if (isPasswordMatch) {
                String token = generateJwtToken(member);
                System.out.println(token);
                return token;
            }else {
                LOGGER.warn("{} 아이디와 비밀번호가 일치하지 않습니다", memberId);
            }
        } else {
            LOGGER.warn("아이디가 {}인 회원이 존재하지 않습니다", memberId);
        }
        return null;
    }

    private String generateJwtToken(Member member) {
    	long expirationTimeInMillis = 1000 * 60 * 20;
    	
    	List<String> roles = mapGradeToRoles(member.getMemberGrade());
    	LOGGER.debug("Roles assigned to token: {}", roles);
    	
        return Jwts.builder()
                .setSubject(member.getMemberId())
                .claim("role", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMillis)) // 5분
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
    
    private List<String> mapGradeToRoles(int memberGrade) {
        switch (memberGrade) {
            case 0: // 관리자
                return List.of("ROLE_ADMIN");
            case 1: // 일반회원
                return List.of("ROLE_USER");
            case 2: // 차단된회원
                return List.of("ROLE_BLOCKED");
            default:
                return List.of("ROLE_USER");
        }
    }
}
