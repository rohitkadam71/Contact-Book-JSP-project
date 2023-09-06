package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.contact;

//import jakarta.servlet.http.HttpSession;

public class ContactDao {
	Connection con;
	
	public ContactDao(Connection con) {
		this.con = con;
	}
	
	public boolean addContact(contact c) {
		boolean result = false;
		try {
			String sql = "insert into contact(name,email,phone,description,userid) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			System.out.println(c.getName());
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhone());
			ps.setString(4, c.getAbout());
			ps.setInt(5, c.getUserId());
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				System.out.println("Contact Details Added Successfully..!");
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<contact> getAllContacts(int uId){
		List<contact> list = new ArrayList<contact>();
		
		try {
			String sql = "select * from contact where userid = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, uId);
			
			ResultSet rs = ps.executeQuery();
			
			contact c = null;
			while(rs.next()) {
				c = new contact();
				
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhone(rs.getString(4));
				c.setAbout(rs.getString(5));
				
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public contact getContactById(int cid) {
		contact c= null;
		
		try {
			String sql = "select * from contact where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, cid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhone(rs.getString(4));
				c.setAbout(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public boolean updateContact(contact c) {
		boolean result = false;
		try {
			String sql = "update contact set name = ?, email = ?, phone = ?, description = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhone());
			ps.setString(4, c.getAbout());
			ps.setInt(5, c.getId());
			
			int i = ps.executeUpdate();
			if(i == 1) {
				result = true;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public boolean deleteContact(int cid) {
		boolean result = false;
		try {
			String sql = "delete from contact where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1,cid);
			
			result = ps.execute();
		}catch(Exception ex) {
			System.out.println("Exception Occured during Deletion of contact..!");
		}
		
		return result;
	}

}
