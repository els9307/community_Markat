package com.community.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.community.mapper.Home_Mapper;
import com.community.vo.CM_BOARD;

@Service("h_service")
public class Home_service {
	
	@Resource(name="h_mapper")
	private Home_Mapper h_mapper;

	
	public List<CM_BOARD> IndexList(){
		List<CM_BOARD> board = h_mapper.IndexList();
		return board;
	}
}
