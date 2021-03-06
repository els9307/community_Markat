package com.community.util;

import org.springframework.stereotype.Service;

@Service("pageAction")
public class pagingAction {
	public String paging(int count,int pageSize, int currentPage,String word) {
		System.out.println("pageAction="+word);
		String file = "javascript:page";
		int pageCount = count/pageSize + (count%pageSize==0?0:1);
		int pageBlock = 3;
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage + pageBlock-1;
		if(endPage>pageCount) endPage = pageCount;
		StringBuffer sb = new StringBuffer();
		//정적 클래스보다 동적클래스로 처리해주면 문자열을 동적으로 변화시켜 줄 수 있음
		//string 정적 클래스 사용시 과부화가 많이 걸림
		
		if(count>0) {
			//이전
			if(startPage>pageBlock) {
				sb.append("<a class='button disabled' href="+file+"(");
				sb.append((startPage-pageBlock)+","+"'"+word+"'"+")");
				sb.append(">[이전]</a>");
				//localhost > pageNum= 1 or 2 & word = '검색어값'
			}
			//페이지
			for (int i = startPage;i<=endPage;i++) {
				if(i==currentPage) {
					sb.append("["+i+"]");
				}else {
					sb.append("<a href="+file+"(");
					sb.append(i+","+"'"+word+"'"+")");
					sb.append(">["+i+"]</a>");
				}
			}
			//다음
			if(endPage<pageCount) {
				sb.append("<a href="+file+"(");
				sb.append((startPage+pageBlock)+","+"'"+word+"'"+")");
				sb.append(">[다음]</a>");
			}
		}

		return sb.toString();
	}
}
