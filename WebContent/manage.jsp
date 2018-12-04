<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Management</title>

</script>

<style type="text/css">

html{   
    width: 100%;   
    height: 100%;     
    font-style: sans-serif;   
}

body{   
    width: 100%;   
    height: 100%;   
    font-family: 'Open Sans',sans-serif;   
    margin: 0;   
    background-color: #727696;   
}

#manage{   
    position: absolute;   
    top: 26%;   
    left:26%;   
    margin: -150px 0 0 -150px;   
    width: 300px;   
    height: 300px;   
}

#manage h1{   
    color: #fff;   
    text-shadow:0 0 10px;   
    letter-spacing: 1px;   
    text-align: left;   
}

#courseTable{
    margin: auto;
    width: 90%;
    margin-top: 150px;
    padding: 10px;
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
</script>

</head>
<body>
<div id="manage">
<h1>Manage Course</h1>
<form method="post" action="logout.do">
		<input type="submit" id="logout11" value="Log out" style="background-color:#4a77d4; width: 100px; height: 36px;"/>
</form>
<a href="courseAdd.jsp" style="color:#bbb; " id="addCourse">Add New Course</a>

</div>
<table class="redTable" id="courseTable">
		<tr>
			<td>id</td>
			<td>course.name</td>
			<td>number</td>
			<td>description</td>
			<td>track</td>
			<td>Operation</td>
		</tr>
		
		<c:forEach items="${courseList}" var="course">

			<tr class="tableContent">
				<td>${course.id}</td>
				<td><a href="course.do?id=${course.id}" >${course.name}</a></td>
				<td>${course.number}</td>
				<td>${course.description}</td>
				<td>${course.track}</td>
				<td><a href="editCourse.do?id=${course.id}" id="edit${course.id}">Edit</a>&nbsp;&nbsp;<a href="deleteCourse.do?id=${course.id}" id="delete${course.id}">Delete</a></td>
			</tr>
			<br>
		</c:forEach>
	</table>

</body>
</html>