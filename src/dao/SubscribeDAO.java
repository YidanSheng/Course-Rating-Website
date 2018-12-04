package dao;
//written by Tianrou

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Statement;

import po.Comment;
import po.Course;
import po.User;
import util.DBHelper;

public class SubscribeDAO {
	
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static boolean unsubscribe(long userid, long courseid) {
		SubscribeDAO dao = new SubscribeDAO();
		if(dao.recordExists(courseid,userid)) {
			con = DBHelper.getConnection();
			String sql = "delete from subscribe where user_id = ? and course_id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setLong(1, userid);
				ps.setLong(2, courseid);
				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			return false;
		}
		return false;
	}
	
	public static boolean subscribe (String username, long userid, long courseid) {
		SubscribeDAO dao = new SubscribeDAO();
		if(!dao.recordExists(courseid,userid)) {
			con = DBHelper.getConnection();// get connection
			String sql = "insert into subscribe(course_id, user_id, username) values (?,?,?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setLong(1, courseid);  // set courseId
				ps.setLong(2, userid); // set userId
				ps.setString(3, username);  // set user name
				int b = ps.executeUpdate();// return > 0: insert success. others:insert fail.
				if (b > 0) {
					return true;
				} else {
					return false;
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
		}
		
		return false; // if the record exists, then return false.
	}
	
	public static boolean recordExists (long courseid, long userid) {
		con = DBHelper.getConnection();// get connection
		String sql = "select * from subscribe where course_id = ? and user_id = ?";// query
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, courseid);// set variable to '?'
			ps.setLong(2, userid);
			rs = ps.executeQuery();// execute query return ResultSet
			if (rs.next()) {
				return true; //The record exists. Do not subscribe again.
			}else {
				return false;
			}
		}catch (SQLException e) {
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
		return true;
	}
	

}
