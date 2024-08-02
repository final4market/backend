package com.market.service;

import com.market.mapper.MemberMapper;
import com.market.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private MemberMapper memberMapper;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Member member = memberMapper.getMemberByIdWithPassword(memberId);
        if (member == null) {
            throw new UsernameNotFoundException(memberId + " 아이디를 찾을 수 없습니다");
        }
        return new CustomUserDetails(member);
    }
}
