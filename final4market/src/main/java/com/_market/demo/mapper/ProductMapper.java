package com._market.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

	String selectAllMypage();

}
