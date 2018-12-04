<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Course Detail</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"type="text/javascript"></script>
<script type="text/javascript">
	function postComment(){
		var comment = $('#contentText').val();
		var file = $('#fileName').val();
		
		if(comment == "" && file == ""){
			alert("Please enter comment content or attach file!");
		}
		else{
			$('#commentForm').submit();
		}		
	}
	
	function sub(){
		var courseid = $('#formCourseId').val();
		var data = {'dataid':courseid};
		//alert(courseid);
		$.ajax({
			type : "POST",
			url: "subscribe.do",
			data : data,
			dataType:'json',
			success:function(data)
	         { 
				//alert("回传成功");
	        	 if(data.state){
	        		 alert("Subscribe Successful!");
	        		 $('#stateButton').val("Unsubscribe");
	        	 }else{
	        		 alert("Unsubscribe Successful!");
	        		 $('#stateButton').val("Subscribe");
	        	 }
	         },
	         error:function(data)
	         {      	 
	        	 alert("回传失败");
	         }
		});
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

#detail{   
    position: absolute;   
    top: 26%;   
    left:26%;
    right:26%;    
    margin: -150px 0 0 -150px;      
}

#detail h1{   
    color: #fff;   
    text-shadow:0 0 10px;   
    letter-spacing: 1px;   
    text-align: left;   
}


h1{   
    font-size: 2em;   
    margin: 0.67em 0;   
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

.bubble 
{
position: relative;
width: 508px;
height: 126px;
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
left: 402px;
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
left: 399px;
}

</style>

<!-------------------for page---------------------->
 
    <script type="text/javascript" src="pagination.js"></script>
    <script type="text/javascript">
        //全局变量
        var numCount;       //数据总数量
        var columnsCounts;  //数据列数量
        var pageCount;      //每页显示的数量
        var pageNum;        //总页数
        var currPageNum ;   //当前页数

        //页面标签变量
        var blockTable;
        var preSpan;
        var firstSpan;
        var nextSpan;
        var lastSpan;
        var pageNumSpan;
        var currPageSpan;



        window.onload=function(){
            //页面标签变量
            blockTable = document.getElementById("blocks");
            preSpan = document.getElementById("spanPre");
            firstSpan = document.getElementById("spanFirst");
            nextSpan = document.getElementById("spanNext");
            lastSpan = document.getElementById("spanLast");
            pageNumSpan = document.getElementById("spanTotalPage");
            currPageSpan = document.getElementById("spanPageNum");

            numCount = document.getElementById("blocks").rows.length - 1;       //取table的行数作为数据总数量（减去标题行1）
            columnsCounts = blockTable.rows[0].cells.length;
            pageCount = 10;
            pageNum = parseInt(numCount/pageCount);
            if(0 != numCount%pageCount){
                pageNum += 1;
            }

            firstPage();
        };
    </script>
    
    <!-------------------for page---------------------->

</head>


<body>
<div id="detail">
	<h1>Course Detail</h1 >
	<div id="words" style="color:#d3d3d3;">
	Welcome <a href="userinfo.do?id=${userid}">${username}</a>!
	<a href="homepage.do" style="position: absolute;top: 4%;right:0%;">Back</a>
	<p>Course Name: ${course.name}</p>
	<p>Course Description: ${course.description}</p>
	<p>Course Lecturer: </p>
	<c:forEach items="${professorList}" var="professor">
		<p>- <a href="${professor[1]}">${professor[0]}</a></p>
	</c:forEach>
	</div>
<h3 style="color:#fff;">Comments & Documents</h3>
	<table class="redTable">
		<thead>
		<tr>
			<th>username</th>
			<th>content</th>
			<th>file list</th>
			<th>create time</th>
		</tr>
		</thead>
		
		<tbody id="blocks">
		
		<c:forEach items="${commentList}" var="comment">
			<tr>
				<td>${comment.username}</td>
				<td>${comment.content}</td>
				<td>
				<table>
						<c:forEach items="${comment.fileList}" var="file">
							<a href="/OOAD-Project/downloadfile?filename=${file.fileName}"><tr>[${file.fileName}]</tr></a>
						</c:forEach>
					</table>
				 </td>			 
				<td>${comment.createTime}</td>			
			</tr>
			<br>
		</c:forEach>
		
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="5">
				</td>
			</tr>
		</tfoot>
	</table>
		<br>
	<div id="pagiDiv" align="right" style="color:lightgrey;">
		<span id="spanFirst">First</span> 
		<span id="spanPre">Prev</span> 
		<span id="spanNext">Next</span>
		<span id="spanLast">Last</span>
		<span id="spanPageNum"></span> of <span id="spanTotalPage"></span> Page
	</div>
	
<table>
	<td>
	<form id = "subscribeForm">	
		<input type = "hidden" value = "${userid}" id = "formUserId">
		<input type = "hidden" value = "${course.id}" id = "formCourseId">
		<input type="button" value="${subState}" id = "stateButton" onclick="sub()"/>
	</form>
	</td>
</table>

	
	<div id = "comment" style="color:white">
	<p>Add Your Comment</p>
	<form action = "addcomment.do" name="commentForm" id = "commentForm" method="post" enctype="multipart/form-data">
    	<div class="bubble">   
    	<textarea id="contentText" class="text" cols="81" rows ="9" name="contentText"></textarea>
    	<input type="hidden" value="${course.id}" name = "courseId">
    	<input type="hidden" value="${course.name}" name = "courseName">
    	</div>
		<br>
		<input type="file" value="Attach File" name = "fileName" id = "fileName" multiple>
   		<br>
   		<input type="button" value="Submit" id = "postcomment" class="submitButton" onclick="postComment();" style="   
    margin-bottom: 10px;   
    outline: none;      
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
	</form>
	</div>

</body>
</html>