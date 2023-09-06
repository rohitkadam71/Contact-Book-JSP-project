package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.user;

public class UserDao {
	private Connection con;
	public UserDao(Connection con) {
		this.con = con;
	}
	
	public boolean userRegister(user userd) {
		boolean result = false;
		try {
			String sql = "insert into user (name,email,password) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userd.getName());
			ps.setString(2, userd.getEmail());
			ps.setString(3, userd.getPassword());
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				result = true;
			}else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public user loginUser(String email, String password) {
		user result = null;
		
		try {
			String sql = "select * from user where email = ? and password = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				result = new user();
				result.setId(rs.getInt(1));
				result.setName(rs.getString(2));
				result.setEmail(rs.getString(3));
				result.setPassword(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
}
