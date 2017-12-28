package com.zou.utils;

import java.util.ArrayList;

public class DataUtils <E>{
	//��һ�����list�ָ�ɼ���С��list
	public ArrayList<E> pagingData(ArrayList<E> list,int num,int page){
		ArrayList<E> newlist=new ArrayList<>();
		for (int i = (page-1)*num; i < page*num&&i<list .size(); i++) {
			newlist.add(list.get(i));
		}
		return newlist;
	}
	//����һ��������
	public StringBuffer createBar(ArrayList<E> list,int num,int page,String method){
		StringBuffer bar=new StringBuffer();
		int pages=(list.size()-1)/num+1;
		if (page>1) {
			bar.append("<a href='"+method+"?page="+(page-1)+"'>��һҳ           </a>");
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
			bar.append("<a href='"+method+"?page="+(page+1)+"'>    ��һҳ</a>");
		}
		
		return bar;
	}
	//�����쳣����ķ���
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
