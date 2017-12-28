package com.zou.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import com.zou.bean.User;
import com.zou.inf.DaoInf;
import com.zou.utils.DBUtils;




public class UserDao implements DaoInf<User>{

	@Override
	public boolean inserData(User data) {
		Random random=new Random();
		int id=random.nextInt();
		Connection con = DBUtils.getConnection();
		PreparedStatement psm = null;
		int rs = 0;
		try {
					
			String sql="INSERT INTO tb_user VALUES (?,?,?);";
			psm = con.prepareStatement(sql);
			psm.setInt(1, id);
			psm.setString(2, data.getUser_name());
			psm.setString(3, data.getUser_password());
			
			rs = psm.executeUpdate();
			DBUtils.release(psm, con);
			if (rs>0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtils.release(psm, con);
			return false;
		}
	}

	@Override
	public boolean deleteData(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteData(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<User> selectAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectDataById(int id) {
		return null;
	}

	@Override
	public User selectDataById(String id) {
		Connection con = DBUtils.getConnection();
		PreparedStatement psm = null;
		ResultSet rs = null;
		User user = null;
		try {					
			String sql="SELECT * FROM tb_user WHERE user_name=?";
			psm = con.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			while(rs.next()){
				user = new User();
				user.setUser_name(rs.getString(1));
				user.setUser_password(rs.getString(2));
			}
			DBUtils.release(rs, psm, con);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtils.release(rs,psm, con);
			return null;
		}
	}

	@Override
	public boolean updateData(User data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
