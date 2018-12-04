package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.User;
import util.DBHelper;

/* 1. check login success or not，2. register*/
public class UserDAO {

	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	public static User checkLogin(String username, String password) {

		con = DBHelper.getConnection();// get connection
		String sql = "select * from user where username = ?";// query
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);// set variable to '?'
			rs = ps.executeQuery();// execute query，return ResultSet
			if (rs.next()) {
				String pwd = rs.getString("password");
				if (pwd.equals(password)) {
					// if match successfully
					User user = new User();
					user.setUserId(rs.getLong("user_id"));
					user.setUsername(username);
					user.setRole(rs.getInt("role"));
					user.setEmail(rs.getString("email"));
					return user;
				} 
				
			} 
		} catch (SQLException e) {

			e.printStackTrace();
		} finally { 
			// close connection
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
		return null;
	}

	public static String register(String username, String password,String email) {
		UserDAO dao = new UserDAO();
		System.out.println("start validate");
		if(!dao.userIsExist(username)) {
			return "Username already be used";
		}
		if(!dao.emailIsExist(email)) {
			return "Email already be used";
		}

		con = DBHelper.getConnection();
	
		String sql = "insert into user(username, password, email,role) values (?,?,?,0)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);  // set username
			ps.setString(2, password); // set password
			ps.setString(3, email);  // set email
			int b = ps.executeUpdate();// return > 0: insert success. others:insert fail.
			if (b > 0) {
				return "Register success";
			} else {
				return "Register fail";
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				ps = null;
			}
		}
		return "Register success";
	}
	
	
	 public boolean userIsExist(String username){	      
	        Connection conn = DBHelper.getConnection();
	        String sql = "select * from user where username = ?";
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, username);
	            ResultSet rs = ps.executeQuery();
	            // if already has this username
	            if(!rs.next()){
	                // not exist this username in db
	                return true;
	            }
	            rs.close();
	            ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}
					rs = null;
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}
					ps = null;
				}
			}
	        return false;
	    }
	 	
	 public boolean emailIsExist(String email){
	        Connection conn = DBHelper.getConnection();
	        String sql = "select * from user where email = ?";
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, email);
	            ResultSet rs = ps.executeQuery();
	            // if already has this email
	            if(!rs.next()){
	                // not exist this email in db
	                return true;
	            }
	            rs.close();
	            ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally { 
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}
					rs = null;
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}
					ps = null;
				}
			}
	        return false;
	    }
	 
	 public static User getUserInfo(Long id) {
		 	User user = new User();
			con = DBHelper.getConnection();
			String sql = "select * from user where user_id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setLong(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					user.setUserId(id);
					user.setEmail(rs.getString("email"));
					user.setRole(rs.getInt("role"));
					user.setUsername(rs.getString("username"));
				} else {
					return null;
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally { 
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}
					rs = null;
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}
					ps = null;
				}
			}
			return user;
		}


}

