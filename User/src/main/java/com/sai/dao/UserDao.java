package com.sai.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sai.bean.UserBean;
import com.sai.dbconnection.ConnectionProvider;

public class UserDao {

    private Connection conn;

    public UserDao() {
    	conn = ConnectionProvider.getConnection();
    }

    public void addUser(UserBean userBean) {
        try {
        	String sql = "INSERT INTO users(userid, firstname,lastname,dob,gender,address)" +
    		" VALUES (?, ?, ?, ? , ? ,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userBean.getId());
            ps.setString(2, userBean.getfName());
            ps.setString(3, userBean.getlName());
            ps.setString(4, userBean.getdob());
            ps.setString(5, userBean.getgender());
            ps.setString(6, userBean.getaddress());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(int userId) {
        try {
        	String sql = "DELETE FROM users WHERE userid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      }

    public void editUser(UserBean userBean) {    	
    	try {
    		String sql = "UPDATE users SET firstname=?, lastname=?,dob=?,gender=?,address=?" +
            " WHERE userid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setString(1, userBean.getfName());
            ps.setString(2, userBean.getlName());
            ps.setString(3, userBean.getdob());
            ps.setString(4, userBean.getgender());
            ps.setString(5, userBean.getaddress());
            ps.setInt(6, userBean.getId());
            ps.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List getAllUsers() {
        List users = new ArrayList();
        try {
        	String sql = "SELECT * FROM users";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                UserBean userBean = new UserBean();
                userBean.setId(rs.getInt("userid"));
                userBean.setfName(rs.getString("firstname"));
                userBean.setlName(rs.getString("lastname"));
                userBean.setdob(rs.getString("dob"));
                userBean.setgender(rs.getString("gender"));
                userBean.setaddress(rs.getString("address"));
                users.add(userBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public UserBean getUserById(int userId) {
    	UserBean userBean = new UserBean();
        try {
        	String sql = "SELECT * FROM users WHERE userid=?";
            PreparedStatement ps = conn.
                    prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, userBean.getfName());
            ps.setString(3, userBean.getlName());
            ps.setString(4, userBean.getdob());
            ps.setString(5, userBean.getgender());
            ps.setString(6, userBean.getaddress());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	userBean.setId(rs.getInt("userid"));
            	userBean.setfName(rs.getString("firstname"));
            	userBean.setlName(rs.getString("lastname"));
            	 userBean.setdob(rs.getString("dob"));
                 userBean.setgender(rs.getString("gender"));
                 userBean.setaddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBean;
    }
}