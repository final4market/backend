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
        switch (member.getMemberGrade()) {
            case 1: // 관리자
                return Collections.singletonList(new SimpleGrantedAuthority(Role.ROLE_ADMIN.name()));
            case 0: // 일반회원
                return Collections.singletonList(new SimpleGrantedAuthority(Role.ROLE_USER.name()));
            case 2: // 차단된회원
                return Collections.singletonList(new SimpleGrantedAuthority(Role.ROLE_BLOCKED.name()));
            default:
                return Collections.singletonList(new SimpleGrantedAuthority(Role.ROLE_USER.name()));
        }
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
