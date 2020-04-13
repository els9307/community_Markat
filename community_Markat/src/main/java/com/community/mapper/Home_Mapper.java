package com.community.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.community.vo.CM_BOARD;
@Repository("h_mapper")
public interface Home_Mapper {

	
	public List<CM_BOARD> IndexList();
}
