package com.community.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.community.vo.CM_BOARD;


@Repository("b_mapper")
public interface Board_Mapper {
	
	public void Board_Insert(CM_BOARD board);
	
	public void Board_Update(CM_BOARD board);

	public void report_count(String b_num);
	
	public void up_PopularCount(String b_num);
	
	public void down_PopularCount(String b_num);
	
	public List<CM_BOARD> TableList(HashMap<String, Object> map);
	
	public int TableCount(HashMap<String, Object> map);
	
	public CM_BOARD TableDtailView(String b_num);
}
