package com.community.mapper;

import org.springframework.stereotype.Repository;
import com.community.vo.CM_USERINFO;

@Repository("c_mapper")
public interface user_Mapper {
	public int idChk(CM_USERINFO userinfo);
	
	public void UserJoin(CM_USERINFO userinfo);
	
	public CM_USERINFO UserLogin(CM_USERINFO userinfo);
	
	public CM_USERINFO UserInformation(CM_USERINFO userinfo);
	
	public void UserUpdate(CM_USERINFO userinfo);


	
}
