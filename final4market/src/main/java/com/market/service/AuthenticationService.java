package com.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import com.market.mapper.MemberMapper;
import com.market.models.Member;
import com.market.dto.MemberDTO;
import javax.crypto.SecretKey;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthenticationService {

    private final MemberMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final SecretKey key;
    private final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

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
            logger.info("비밀번호 일치 여부: {}", isPasswordMatch);

            if (isPasswordMatch) {
                String token = generateJwtToken(member);
                System.out.println(token);
                return token;
            }else {
                logger.warn("{} 아이디와 비밀번호가 일치하지 않습니다", memberId);
            }
        } else {
            logger.warn("아이디가 {}인 회원이 존재하지 않습니다", memberId);
        }
        return null;
    }

    public void updatePassword(String memberId, String newPasswd) {
        String encodedPasswd = passwordEncoder.encode(newPasswd);
        mapper.updatePassword(memberId, encodedPasswd);
    }

    private String generateJwtToken(Member member) {
    	long expirationTimeInMillis = 1000 * 60 * 60 * 24;
        return Jwts.builder()
                .setSubject(member.getMemberId())
                .claim("role", member.getMemberGradeName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMillis)) // 24시간
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
}
