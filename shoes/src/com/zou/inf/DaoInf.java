package com.zou.inf;

import java.util.ArrayList;

public interface DaoInf<E> {

	public boolean inserData(E data);
	

	public boolean deleteData(int id);
	public boolean deleteData(String id);
	
	
	public ArrayList<E> selectAllData();
	
	public E selectDataById(int id);
	public E selectDataById(String id);
	

	public boolean updateData(E data);
}
