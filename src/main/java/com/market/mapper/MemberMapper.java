package com.market.mapper;

import java.util.List;
import java.util.Map;

import com.market.dto.MemberAddressDTO;
import com.market.dto.MemberDTO;
import com.market.dto.MyPageMyInfoDTO;
import com.market.dto.MyPageProfileDTO;
import com.market.dto.MyPageReceivedReviewDTO;
import com.market.dto.MemberProfileDTO;
import com.market.dto.MyPageFollowListDTO;
import com.market.dto.ReviewDTO;
import com.market.dto.SellerPageFollowListDTO;
import com.market.dto.SellerPageProfileDTO;
import com.market.dto.SellerPageReceivedReviewDTO;
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

	String getAdminNickname(String memberId);

	Member getMemberWithGradeName(@Param("memberId") String memberId);

	Member getMemberByIdWithPassword(@Param("memberId") String memberId);

	String findMemberIdByNameAndPhone(@Param("memberName") String memberName,
			@Param("memberPhoneNo") String memberPhoneNo);

	int countMembersById(String memberId);

	void insertMember(Member member);

	List<MemberDTO> checkMemberMatch(Map<String, String> params);

	Member getMemberById(String memberId);

	void updateMemberEntity(Member member);

	List<StoreDTO> storeInfo(String memberId);

	int profileNo(String memberId);

	String profilePath(int profileNo);

	List<String> buyerProfileNo(List<String> buyerIds);

	List<Map<String, Object>> buyerProfilePath(List<String> buyerProfileNo);

	List<MemberDTO> selectAllMembers1();

	List<MemberDTO> searchMembers1(Map<String, String> params);

	int updateMember1(MemberDTO dto);

	int deleteMember1(String memberId);

	int insertFollow(Map<String, Object> map);

	int deleteFollow(Map<String, Object> map);

	List<MemberAddressDTO> selectMemberAddress(String memberId);

	int insertMemberAddress(MemberAddressDTO dto);

	int currentAddressNO();

	int deleteMemberAddress(int memberAddressNo);

	int changeMainAddressExisting(MemberAddressDTO dto);

	int changeMainAddressNew(MemberAddressDTO dto);

	List<String> selectFollowStatus(String memberId);

	List<MyPageProfileDTO> myPageProfile(String memberId);

	List<MyPageMyInfoDTO> myPageMyInfo(String memberId);

	int updateMyInfo(MyPageMyInfoDTO dto);

	List<MyPageReceivedReviewDTO> myPageReceivedReview(String memberId);

	List<MyPageFollowListDTO> myPageFollowList(String memberId);

	List<SellerPageProfileDTO> sellerPageProfile(String sellerId);

	List<SellerPageReceivedReviewDTO> sellerPageReceivedReview(String sellerId);

	List<SellerPageFollowListDTO> sellerPageFollowList(String sellerId);
}