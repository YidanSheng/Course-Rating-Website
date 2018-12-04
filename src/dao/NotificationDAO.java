package dao;

//written by Tianrou

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import po.Comment;
import po.Course;
import util.DBHelper;

//Display the list of notification for each updated course to user	
public class NotificationDAO {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void RemoveRecord(long userid, long courseid) {
		con = DBHelper.getConnection();
		String sql = "delete from notification where user_id = ? and course_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, userid);
			ps.setLong(2, courseid);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static List<Course> displayNotification (long userid){
		List<Course> res = new LinkedList<>(); 
		ArrayList<Long> courseid = new ArrayList<>();
		
		con = DBHelper.getConnection();
		String sql = "select * from notification where user_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				courseid.add(rs.getLong("course_id"));
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
		
		res = getCourseList(courseid);
		return res;
	}
	
	protected static List<Course> getCourseList (ArrayList<Long> courseid){
		List<Course> res = new LinkedList<>(); 
		con = DBHelper.getConnection();
		
		for(Long id : courseid) {
			String sql = "select * from course where course_id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setLong(1, id);
				rs = ps.executeQuery();
				int i = 0;
				while (rs.next()) {
					Course course=new Course();  
					course.setId(rs.getLong("course_id"));  
					course.setName(rs.getString("course_name"));
					course.setDescription(rs.getString("description")); 
					course.setNumber(rs.getLong("course_number")); 
					course.setCommentNum(rs.getLong("comment_number"));
					course.setTrack(rs.getString("track"));  
	                res.add(course);
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
		
		return res;
	}
}
