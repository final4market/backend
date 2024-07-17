package com.market.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.market.dto.MemberDTO;
import com.market.dto.ProfileImageDTO;

@Mapper
public interface MemberMapper {

	List<MemberDTO> selectAllMembers();

	List<MemberDTO> searchMembers(Map<String, String> params);

	int updateMember(MemberDTO dto);

	int deleteMember(String memberId);

	List<ProfileImageDTO> selectAllProfileImage();

}
