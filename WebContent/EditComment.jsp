<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Comment</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('input:file').change(		
	    function(e){
	    	var filenames = "";
	        var f = e.target.files,
	            len = f.length;
	        for (var i=0;i<len;i++){
	        	filenames += f[i].name + ",";	           
	        }
	        filenames = filenames.substring(0, filenames.length-1);
	        console.log(filenames);
	        $('#inputname').val(filenames);
	    });
});
</script>
<script type="text/javascript">
	function clearFile(){
		$('#inputname').val('');
	}
	
	function confirm(){
		$('#edit_form').submit();
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

#comment{   
    position: absolute;   
    top: 40%;   
    left:50%;   
    margin: -150px 0 0 -150px;   
    width: 380px;    
}

#comment h1{   
    color: #fff;   
    text-shadow:0 0 10px;   
    letter-spacing: 1px;   
    text-align: center;   
}

h1{   
    font-size: 2em;   
    margin: 0.67em 0;   
}

.bubble 
{
position: relative;
width: 330px;
height: 128px;
padding: 0px;
-webkit-border-radius: 10px;
-moz-border-radius: 10px;
border-radius: 10px;
border: #4a77d4 solid 4px;
}

.bubble:after 
{
content: '';
position: absolute;
border-style: solid;
border-width: 26px 20px 0;
border-color: #ffffff transparent;
display: block;
width: 0;
z-index: 1;
bottom: -26px;
left: 262px;
}

.bubble:before 
{
content: '';
position: absolute;
border-style: solid;
border-width: 29px 23px 0;
border-color: #4a77d4 transparent;
display: block;
width: 0;
z-index: 0;
bottom: -33px;
left: 259px;
}

</style>

</head>
<body>
<div id="comment" style="color: #fff;">  
<h1>Edit Comment&nbsp&nbsp&nbsp&nbsp&nbsp</h1>
<form class = "form" action="editcomment.do" id = "edit_form" method="post" enctype="multipart/form-data">

<c:forEach items="${commentList}" var="comment">


<input type ="hidden" name = "id" value="${comment.commentId}">


<p >Comment Content: </p>

<div class="bubble"> 
<textarea name = "commentcontent" id="commentcontent" cols="51.7" rows ="9.7">${comment.content}</textarea>
</div>
<br>
<br>
File name: 
<br>
<input type ="text" id = "inputname" name = "inputname" style="background-color: #aeb1c4;" value="${fileList}" readonly>
<button type= "button" id = "clearComment" onclick = "clearFile();">delete file</button>
<table>
<td>
<input type="file" id="files" value="Attach File" name = "fileName"  multiple>

</c:forEach>
</td>
<td>
</td>
</table>
<br>
</form>

<input type="submit" value = "submit" id = "updateForm" onclick = "confirm()" style="   
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
	background-color:#4a77d4; width: 100px; height: 36px;">
</div>

</body>
</html>