package com.market.mapper;

import java.util.List;
import java.util.Map;


import com.market.dto.MemberDTO;
import com.market.dto.MemberProfileDTO;
import com.market.dto.ReviewDTO;
import com.market.dto.StoreDTO;

import org.apache.ibatis.annotations.Mapper;


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

	List<MemberProfileDTO> selectMemberProfile(int memberProfileNo);

	List<MemberDTO> selectMemberNick(String memberId);

	List<ReviewDTO> selectMemberScore(String memberId);
}