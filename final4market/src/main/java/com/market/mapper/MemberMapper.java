package com.market.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.StoreDTO;

@Mapper
public interface MemberMapper {

	List<StoreDTO> storeInfo(String memberId);

	int profileNo(String memberId);

	String profilePath(int profileNo);

	List<String> buyerProfileNo(List<String> buyerIds);

	List<Map<String, Object>> buyerProfilePath(List<String> buyerProfileNo);


}
