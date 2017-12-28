package com.zou.utils;

import java.util.ArrayList;

public class DataUtils <E>{
	//将一个大的list分割成几个小的list
	public ArrayList<E> pagingData(ArrayList<E> list,int num,int page){
		ArrayList<E> newlist=new ArrayList<>();
		for (int i = (page-1)*num; i < page*num&&i<list .size(); i++) {
			newlist.add(list.get(i));
		}
		return newlist;
	}
	//生成一个导航栏
	public StringBuffer createBar(ArrayList<E> list,int num,int page,String method){
		StringBuffer bar=new StringBuffer();
		int pages=(list.size()-1)/num+1;
		if (page>1) {
			bar.append("<a href='"+method+"?page="+(page-1)+"'>上一页           </a>");
		}
		for (int i = 1; i <= pages; i++) {
			if (i==page) {
				bar.append("["+i+"]");
			} else {
				bar.append("<a href='"+method+"?page="+i+"'>"+i+"</a>");
			}
			bar.append("     ");
		}
		if (page<pages) {
			bar.append("<a href='"+method+"?page="+(page+1)+"'>    下一页</a>");
		}
		
		return bar;
	}
	//数据异常处理的方法
	public int Conver2Int(String sdata,int n){
		int data=n;
		try {
			data=Integer.parseInt(sdata);
			if (data<=0) {
				throw new Exception();
			}
		} catch (Exception e) {
			data=n;
		}
		return data;
	}
}
