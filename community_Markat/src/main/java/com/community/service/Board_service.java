package com.community.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.community.mapper.Board_Mapper;
import com.community.vo.CM_BOARD;

@Service("b_service")
public class Board_service {

	@Resource(name = "b_mapper")
	public Board_Mapper b_mapper;
	
	
	public void Board_Insert(CM_BOARD board) {
		b_mapper.Board_Insert(board);
	}
	public void Board_Update(CM_BOARD board) {
		b_mapper.Board_Update(board);
	}
	public void report_count(String b_num) {
		b_mapper.report_count(b_num);
	}
	public void up_PopularCount(String b_num) {
		b_mapper.up_PopularCount(b_num);
	}
	public void down_PopularCount(String b_num) {
		b_mapper.down_PopularCount(b_num);
	}
	public List<CM_BOARD> TableList(int startRow,int endRow,String word){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow",endRow);
		map.put("word",word);
		return b_mapper.TableList(map); 
	}
	public int TableCount(String word) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("word", word);
		int count = b_mapper.TableCount(map);
		return count;
	}
	
	public CM_BOARD TableDtailView(String b_num) {
		return b_mapper.TableDtailView(b_num);
	}
}
