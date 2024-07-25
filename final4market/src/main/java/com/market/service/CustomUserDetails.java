package com.market.service;

import com.market.models.Member;
import com.market.models.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Member member;

    public CustomUserDetails(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = "ROLE_USER"; // 기본 role
        switch (member.getMemberGrade()) {
            case 0:
                role = "ROLE_ADMIN";
                break;
            case 2:
                role = "ROLE_BLOCKED";
                break;
        }
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return member.getMemberPasswd();
    }

    @Override
    public String getUsername() {
        return member.getMemberId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return member.getMemberGrade() != 2; // 차단된회원 (ROLE_BLOCKED)
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public String getMemberId() {
        return member.getMemberId();
    }

    public int getMemberGrade() {
        return member.getMemberGrade();
    }
}
