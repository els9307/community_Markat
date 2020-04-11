package com.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.mapper.user_Mapper;
import com.community.vo.CM_USERINFO;

@Service
public class CM_Service {

	@Autowired
	public user_Mapper c_mapper;
	
	
	public int idChk(CM_USERINFO userinfo) {
		int result = c_mapper.idChk(userinfo);
		return result;
	}
	public void UserJoin(CM_USERINFO userinfo) {
		c_mapper.UserJoin(userinfo);
	}
	public CM_USERINFO UserLogin(CM_USERINFO userinfo) {
		return c_mapper.UserLogin(userinfo);
	}
	public CM_USERINFO UserInformation(CM_USERINFO userinfo) {
		return c_mapper.UserInformation(userinfo);
	}
	public void UserUpdate(CM_USERINFO userinfo) {
		c_mapper.UserUpdate(userinfo);
	}
	
}
