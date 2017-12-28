package com.zou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zou.bean.Shoe;
import com.zou.inf.DaoInf;
import com.zou.utils.DBUtils;





public class ShoeDao implements DaoInf<Shoe>{

	@Override
	public boolean inserData(Shoe data) {
		boolean flag = false;
		Connection connection = null;
		PreparedStatement psta = null;		
		try {
			connection = DBUtils.getConnection();
			String sql = "INSERT INTO tb_shoe VALUES(?,?,?,?)";
			psta = connection.prepareStatement(sql);
			psta.setInt(1, data.getShoe_id());
			psta.setDouble(2, data.getShoe_size());
			psta.setString(3, data.getShoe_type());
			psta.setDouble(4, data.getShoe_price());			
			int n = psta.executeUpdate();
			if (n>0) {
				flag = true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBUtils.release(psta, connection);
		return flag;
	}

	@Override
	public boolean deleteData(int id) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			con = DBUtils.getConnection();
			String sql = "DELETE FROM tb_shoe WHERE shoe_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);		
			int n = ps.executeUpdate();
			if (n>0) {
				flag = true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBUtils.release(rs, ps, con);
		return flag;
	}

	@Override
	public boolean deleteData(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Shoe> selectAllData() {
		ArrayList<Shoe> list=new ArrayList<>();
		Connection con=DBUtils.getConnection();
		Statement sm=null;
		ResultSet rs=null;
		try {
			sm=con.createStatement();
			String sql="SELECT * FROM tb_shoe";
			rs = sm.executeQuery(sql);
			//5、处理结果集
			while(rs.next()){
				Shoe temp_shoe = new Shoe();
				temp_shoe.setShoe_id(rs.getInt(1));
				temp_shoe.setShoe_size(rs.getDouble(2));
				temp_shoe.setShoe_type(rs.getString(3));
				temp_shoe.setShoe_price(rs.getDouble(4));
				list.add(temp_shoe);
			}
			DBUtils.release(rs, sm, con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtils.release(rs, sm, con);
			
			
		}return list;
	}

	@Override
	public Shoe selectDataById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shoe selectDataById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateData(Shoe data) {
		boolean flag = false;
		Connection connection = null;
		PreparedStatement psta = null;		
		try {
			connection = DBUtils.getConnection();
			String sql = "UPDATE tb_shoe SET shoe_size=?,shoe_type=? shoe_price=?WHERE shoe_id=?";
			psta = connection.prepareStatement(sql);
			psta.setDouble(1, data.getShoe_size());	
			psta.setString(1, data.getShoe_type());	
			psta.setDouble(1, data.getShoe_price());	
			psta.setInt(1, data.getShoe_id());	
			int n = psta.executeUpdate();
			if (n>0) {
				flag = true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBUtils.release(psta, connection);	
		return flag;
	}

}
