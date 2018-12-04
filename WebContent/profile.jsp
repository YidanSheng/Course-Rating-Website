<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>

<style type="text/css">

html{   
    width: 100%;   
    height: 100%;   
    font-style: sans-serif;   
}

body{   
    width: 90%;   
    height: 100%; 
    
    font-family: 'Open Sans',sans-serif;   
    margin: 0;   
    background-color: #727696;   
}

#profile{   
    margin: auto;
    width: 90%;
    margin-left: 10%;
    margin-top: 20px;
    padding: 10px; 
 
}

#profile h1{   
    color: #fff;   
    text-shadow:0 0 10px;   
    letter-spacing: 1px;   
    text-align: left;   
}


h1{   
    font-size: 2em;   
    margin: 0.67em 0;   
} 

input{   
    width: 278px;   
    height: 28px;   
    margin-bottom: 10px;   
    outline: none;   
    padding: 10px;   
    font-size: 13px;   
    color: #fff;   
    text-shadow:1px 1px 1px;   
    border-top: 1px solid #312E3D;   
    border-left: 1px solid #312E3D;   
    border-right: 1px solid #312E3D;   
    border-bottom: 1px solid #56536A;   
    border-radius: 4px;   
    background-color: #2D2D3F;   
} 

table.redTable {
  border: 2px solid #AAAAAA;
  background-color: #CFCFE3;
  width: 100%;
  text-align: center;
  border-collapse: collapse;
}
table.redTable td, table.redTable th {
  border: 1px solid #AAAAAA;
  padding: 3px 2px;
}
table.redTable tbody td {
  font-size: 13px;
}
table.redTable tr:nth-child(even) {
  background: #ABB1D2;
}
table.redTable thead {
  background: #8489BF;
}
table.redTable thead th {
  font-size: 19px;
  font-weight: bold;
  color: #FFFFFF;
  text-align: center;
  border-left: 2px solid #A4A4A4;
}
table.redTable thead th:first-child {
  border-left: none;
}

table.redTable tfoot {
  font-size: 13px;
  font-weight: bold;
  color: #FFFFFF;
  background: #8489BF;
}
table.redTable tfoot td {
  font-size: 13px;
}
table.redTable tfoot .links {
  text-align: right;
}
table.redTable tfoot .links a{
  display: inline-block;
  background: #FFFFFF;
  color: #000000;
  padding: 2px 8px;
  border-radius: 5px;
}

</style>

</head>

<script>
	function viewAndRemove(userid,courseid){
		var url="remove.do";
		var tempForm = document.createElement("form");
	    tempForm.id = "tempForm1";
	    tempForm.method = "post";
	    tempForm.action = url;
	    var hideInput1 = document.createElement("input");
	    hideInput1.type = "hidden";
	    hideInput1.name="userID"; 
	    hideInput1.value = userid;
	    var hideInput2 = document.createElement("input");
	    hideInput2.type = "hidden";
	    hideInput2.name="courseID"; 
	    hideInput2.value = courseid;
	    console.log(userid);
	    console.log(courseid);
	    document.body.appendChild(tempForm);
	    tempForm.submit();
	    document.body.removeChild(tempForm);
	}
</script>

<body>
<div id="profile">
<h1>Profile</h1>
<div id="words" style="color:#d3d3d3;">
<p>Welcome ${user.username}!</p>
<p>Your email: ${user.email}</p>
<a href="homepage.do" style="position: absolute;top: 9%;right:10%; ">Back</a>

<h2>Comment History</h2>
</div>
<table class="redTable" id="table">
	<thead>
		<tr>
			<td>Course Name</td>
			<td>Content</td>
			<td>File list</td>
			<td>Create Time</td>
			<td>Operation</td>
		</tr>
	</thead>
		<c:forEach items="${commentList}" var="comment">
			<tr id="comment${comment.commentId}">
				<td>${comment.courseName}</td>
				<td>${comment.content}</td>
				<td>
					<table>
						<c:forEach items="${comment.fileList}" var="file">
							<a href="/OOAD-Project/downloadfile?filename=${file.fileName}"><tr>[${file.fileName}]</tr></a>
						</c:forEach>
					</table>
				</td>
				<td>${comment.createTime}</td>
				<td><a href="/OOAD-Project/EditComment?comment=${comment.commentId}" id="edit${comment.commentId}"> Edit</a> | <a href="/OOAD-Project/DeleteComment?comment=${comment.commentId}" id="delete${comment.commentId }">Delete</a></td>
			</tr>
		</c:forEach>
</table>
<br>
<div id="words" style="color:#d3d3d3;">
<h3>What's new in your subscription</h3>
</div>
<table class="redTable" id="table">
		<thead>
		<tr>
			<td>Course Name</td>
			<td></td>
		</tr>
		</thead>
	<c:forEach items="${notificationList}" var="notification">
		<tr>
			<td><a href="course.do?id=${notification.id}">${notification.name}</a></td>
			<td>	
				<form action="remove.do" name = "removeForm" method = "post">
					<input type = "hidden" value = "${notification.id}" name = "courseID">
					<input type = "hidden" value = "${user.userId}" name = "userID">
					<button>View</button>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>