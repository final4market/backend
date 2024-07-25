package com.market.mapper;

import java.util.List;
import java.util.Map;

import com.market.dto.MemberAddressDTO;
import com.market.dto.MemberDTO;
import com.market.dto.MyPageProfileDTO;
import com.market.dto.StoreDTO;
import com.market.models.Member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
	List<MemberDTO> selectAllMembers();

	List<MemberDTO> searchMembers(Map<String, String> params);

	int updateMember(MemberDTO dto);

	int deleteMember(String memberId);

	List<StoreDTO> storeInfo(String memberId);

	int profileNo(String memberId);

	String profilePath(int profileNo);

	List<String> buyerProfileNo(List<String> buyerIds);

	List<Map<String, Object>> buyerProfilePath(List<String> buyerProfileNo);

	MyPageProfileDTO myPageProfile(String memberId);

	List<MemberDTO> selectAllMembers1();

	List<MemberDTO> searchMembers1(Map<String, String> params);

	int updateMember1(MemberDTO dto);

	int deleteMember1(String memberId);

	Member getMemberWithGradeName(@Param("memberId") String memberId);

	void insertMember(Member member);

	Member getMemberByIdWithPassword(@Param("memberId") String memberId);

	void updatePassword(@Param("memberId") String memberId, @Param("memberPasswd") String memberPasswd);

	int insertFollow(Map<String, Object> map);

	int deleteFollow(Map<String, Object> map);

	List<MemberAddressDTO> selectMemberAddress(String memberId);
}