package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import util.DBHelper;

public class TeachDAO {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void add(Long courseId, String professorName, String professorLink) {
		con = DBHelper.getConnection();
		String sql = "INSERT INTO teach (course_id,professor_name,professor_link) VALUES (?,?,?)";
		int re;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1,courseId);
			ps.setString(2, professorName);
			ps.setString(3, professorLink);
			
			re = ps.executeUpdate();
			if (re == 0) {
				System.out.println("Insert failed");
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
	
	public static void delete(Long courseId) {
		con = DBHelper.getConnection();
		String sql = "DELETE FROM teach WHERE course_id = ?";
		int re;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1,courseId);
			
			re = ps.executeUpdate();
			
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
	
	public static List<String> getCourseTeachName(Long courseId) {
		List<String> result = new ArrayList<>(); 
		con = DBHelper.getConnection();
		String sql = "SELECT * FROM teach WHERE course_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1,courseId);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(rs.getString("professor_name"));
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
		return result;
	}
	
	public static List<String> getCourseTeachLink(Long courseId) {
		List<String> result = new ArrayList<>(); 
		con = DBHelper.getConnection();
		String sql = "SELECT * FROM teach WHERE course_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1,courseId);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(rs.getString("professor_link"));
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
		return result;
	}

	public static List<Integer> getCourseTeachId(Long courseId) {
		List<Integer> result = new ArrayList<>(); 
		con = DBHelper.getConnection();
		String sql = "SELECT * FROM teach WHERE course_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1,courseId);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(Integer.parseInt(rs.getString("teach_id")));
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
		return result;
	}
	
	public static void clear(Long courseId) {
		con = DBHelper.getConnection();
		String sql = "DELETE FROM teach WHERE course_id = ?";
		int re;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1,courseId);
			re = ps.executeUpdate();
			if (re == 0) {
				System.out.println("Delete nothing");
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
	
//	public static void update(Long courseId, String professorName, String professorLink) {
//	con = DBHelper.getConnection();
//	String sql = "INSERT INTO teach (course_id,professor_name,professor_link) VALUES (?,?,?)";
//	int re;
//	try {
//		ps = con.prepareStatement(sql);
//		ps.setLong(1,courseId);
//		ps.setString(2, professorName);
//		ps.setString(3, professorLink);
//		
//		re = ps.executeUpdate();
//		if (re == 0) {
//			System.out.println("Insert failed");
//		}
//		
//	} catch (SQLException e) {
//		e.printStackTrace();
//	} finally { 
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//			rs = null;
//		}
//		if (ps != null) {
//			try {
//				ps.close();
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//			ps = null;
//		}
//	}
//}
}