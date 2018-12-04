<%@page import="po.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"type="text/javascript"></script>
<script>
function addInput(){
	$("#professor").append("<div>Name: &nbsp;<input type ='text' name = 'professorName' > Link: &nbsp;<input type ='text' name = 'professorLink'><input type='button' onclick='($(this).parent().remove())' value = 'x' ><br></div>");
}

function validate() {
	var name = document.getElementById("name");
	var number = document.getElementById("number");
	name = name.value;
	number = number.value;
	if (name.length == 0) {
		alert("course name cannot be null");
		return false;
	}
	if (number.length == 0) {
		alert("course number cannot be null");
		return false;
	}
	return true;
}
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

#course{   
    position: absolute;   
    top: 30%;   
    left:50%;   
    margin: -150px 0 0 -150px;   
    width: 300px;   
    height: 300px;   
}

#course h1{   
    color: #fff;   
    text-shadow:0 0 10px;   
    letter-spacing: 1px;   
    text-align: center;   
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

</style>
</head>
<body>
<div id="course"> 
<h1>Add new Course</h1>
<div id="form" style="color:#fff;"> 
<form action="addCourse.do" >
<input type ="hidden" name = "id">
Name  <input type ="text" name = "name" id = "name"><br>
Number  <input type ="text" name = "number" id = "number"><br>
Description  <textarea type ="text" name = "description" id = "description" cols="39" rows ="4" style="background-color: #d0d3ea;"></textarea><br>
Track  
	  <select name = "track" id = "track" style="background-color: #2D2D3F;color: #fff;"   >
	  <option value ="" selected ></option>
	  <option value ="DS" >Data Sciences</option>
	  <option value ="IA" >Information Assurance</option>
	  <option value="IS" >Intelligent Systems</option>
	  <option value="IC" >Interactive Computing</option>
	  <option value ="SYS" >Systems</option>
	  <option value="TCS" >Traditional Computer Science</option></select>
<br>
<br>
Professor 
<input type="button" onclick="addInput()" value = "Add Professor" style="background-color:#4a77d4; height: 36px;"></input><div id = "professor"></div>


<input type="submit" id="addSubmit" value = "submit" onclick="return validate()" style="background-color:#4a77d4; height: 36px;">
</form>
</div>
</div>
<c:if test="${requestScope.inf!=null}">

      <span color="red"> ${requestScope.inf} </span>

</c:if>
</body>
</html>