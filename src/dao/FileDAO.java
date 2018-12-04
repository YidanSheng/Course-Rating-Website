package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import po.File;
import util.DBHelper;

public class FileDAO {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static List<File> getFileList(Long commentId){
		List<File> res = new LinkedList<>();
		con = DBHelper.getConnection();
		String sql = "select * from file where comment_id = ? order by create_time DESC";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, commentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				File file = new File();
				file.setCommentId(commentId);
				file.setPath(rs.getString("path"));			
				file.setCreateTime(rs.getTimestamp("create_time"));				
				file.setFileName(rs.getString("name"));
				file.setFileId(rs.getLong("file_id"));
				res.add(file);
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
		return res;
	}
}
