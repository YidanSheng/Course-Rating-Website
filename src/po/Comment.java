package po;

import java.util.Date;
import java.util.List;

public class Comment {
	private Long commentId;
	private Long courseId;
	private String courseName;
	private Long userId;
	private String username;
	private String content;
	private Date createTime;
	private List<File> fileList;
	
	public List<File> getFileList() {
		return fileList;
	}
	public void setFileList(List<File> fileList) {
		this.fileList = fileList;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	
	
}
