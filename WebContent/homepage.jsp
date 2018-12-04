<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Homepage</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"type="text/javascript"></script>
<script type="text/javascript">
  function logout(){
  	window.open("logout.do","_self");
  }
</script>



<script>
$( document ).ready(function() {
   $('#selectTrack').change(function(){
	  var option = $(this).val();
      $.ajax({
         type : "GET",
         url : "track.do",
         data : {"name": option},
         dataType:'json',
         success:function(data)
         { 
        	 $("#courseTable .tableContent").remove();
        	 if (data.course0 != "notfound"){       	 
	        	 var str = "";
	        	 for(var i in data){
	        		 str += "<tr class = 'tableContent'>" + 
	        		
	        		 "<td><a href='course.do?id=" + data[i].id+ "'>" + data[i].name + "</a></td>" + 
	        		 "<td>" + data[i].number + "</td>" + 
	        		 "<td>" + data[i].description + "</td>" + 
	        		 "<td>" + data[i].track + "</td>" +  
	        		 
	        		 "</tr>";
	        	 }
	        	 //<td>${course.id}</td>
	        	 //"<td>" + data[i].commentNum + "</td>" + 
	        	 
	        	 
	        	 $("#courseTable").append(str);
	        	 $("#courseName").val('');
	        	 $("#courseNumber").val('');
        	 }
        	 
         },
         error:function(data)
         {      	 
        	 $("#courseTable .tableContent").remove();
         }
     });
   });
});
</script>
<script>
$( document ).ready(function() {
   $('#courseName').change(function(){
	  var option = $(this).val();
	  var option2 = $("#selectTrack").val();
      $.ajax({
         type : "GET",
         url : "searchCourseName.do",
         data : {"courseName": option, "track": option2},
         dataType:'json',
         success:function(data)
         { 
        	 $("#courseTable .tableContent").remove();
        	 if (data.course0 != "notfound"){       	 
	        	 var str = "";
	        	 for(var i in data){
	        		 str += "<tr class = 'tableContent'>" + 
	        		 
	        		 "<td><a href='course.do?id=" + data[i].id+ "'>" + data[i].name + "</a></td>" + 
	        		 "<td>" + data[i].number + "</td>" + 
	        		 "<td>" + data[i].description + "</td>" + 
	        		 "<td>" + data[i].track + "</td>" +  
	        		 "</tr>";
	        	 }
	        	 //"<td>" + data[i].id + "</td>" + 
	        	 //"<td>" + data[i].commentNum + "</td>" + 
	        	 $("#courseTable").append(str);
        	 }
        	 
         },
         error:function(data)
         {      	 
        	 $("#courseTable .tableContent").remove();
         }
     });
   });
});
</script>

<script>
$( document ).ready(function() {
   $('#courseNumber').change(function(){
	  var option = $(this).val();
	  var option2 = $("#selectTrack").val();
      $.ajax({
         type : "GET",
         url : "searchCourseNumber.do",
         data : {"courseNumber": option, "track": option2},
         dataType:'json',
         success:function(data)
         { 
        	 $("#courseTable .tableContent").remove();
        	 if (data.course0 != "notfound"){       	 
	        	 var str = "";
	        	 for(var i in data){
	        		 str += "<tr class = 'tableContent'>" + 
	        		 
	        		 "<td><a href='course.do?id=" + data[i].id+ "'>" + data[i].name + "</a></td>" + 
	        		 "<td>" + data[i].number + "</td>" + 
	        		 "<td>" + data[i].description + "</td>" + 
	        		 "<td>" + data[i].track + "</td>" +  
	        		
	        		 "</tr>";
	        	 }
	        	 $("#courseTable").append(str);
	        	 //
	        	 // "<td>" + data[i].commentNum + "</td>" + 
        	 }
        	 
         },
         error:function(data)
         {      	 
        	 $("#courseTable .tableContent").remove();
         }
     });
   });
});
</script>

    
<style type="text/css">

body{
}
table .redTable{
}

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

#home{   
    position: absolute;   
    top: 26%;   
    left:26%;   
    margin: -150px 0 0 -150px;   
 
}

#home h1{   
    color: #fff;   
    text-shadow:0 0 10px;   
    letter-spacing: 1px;   
    text-align: left;   
}

#courseTable{
    margin: auto;
    width: 94%;
    margin-top: 20%;
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
<div id="home"> 
	<h1>Course Clip</h1>

	Welcome <a href="userinfo.do?id=${user.userId}" id="user${user.userId}" >${username}</a>!
	<br>
	<br>

	<form method="post" action="logout.do">
		<input type="submit" id="logout11" value="Log out" style="background-color:#4a77d4; width: 100px; height: 36px;"/>
	</form>

	Search course by track:
	<select id="selectTrack" style="background-color: #2D2D3F;color: #fff;">
	  <option value ="ALL">All Courses</option>
	  <option value ="DS">Data Sciences</option>
	  <option value ="IA">Information Assurance</option>
	  <option value="IS">Intelligent Systems</option>
	  <option value="IC">Interactive Computing</option>
	  <option value ="SYS">Systems</option>
	  <option value="TCS">Traditional Computer Science</option>
	  
	</select>
	
	<br>
	<br>
	Search course name:
	<input type="text" name="courseName" id="courseName" placeholder="course name" style="height: 14px; width: 100px;"/>
	<input type="submit"  id="courseName1" value="Submit" style="background-color:#4a77d4; height: 36px; width: 100px; "/>
	
	<!-- Search course number:
	<input type="text" name="courseNumber" id="courseNumber" placeholder="course number" style="height: 14px; width: 100px;"/>
	<input type="submit"  id="courseNumber1" value="Submit" style="background-color:#4a77d4; height: 36px; width: 100px; "/>
	 -->
	</div>
	
	

	
	
	<div id="table"> 
	<table class="redTable"  id="courseTable">
	<!--/**/-->	
	<thead>
		<tr>
			<!-- <td>id</td> -->
			<td>course name</td>
			<td>number</td>
			<td>description</td>
			<td>track</td>
			<!-- comment Number</td> <td>-->

		</tr>
		</thead>
		
		<tbody id="blocks">
		
		<c:forEach items="${courseList}" var="course" >

			<tr class="tableContent" >
				<!-- <td>${course.id}</td> -->
				<td><a id="course${course.id}" href="course.do?id=${course.id}">${course.name}</a></td>
				<td>${course.number}</td>
				<td>${course.description}</td>
				<td>${course.track}</td>
				<!-- <td>${course.commentNum}</td>	 -->	
			</tr>
			<br>
		</c:forEach>
		
		</tbody>
		
	
		
		<tfoot>
			<tr>
				<td colspan="6">
					<!--<div class="links"><a href="#">&laquo;</a> <a class="active" href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">&raquo;</a></div>-->
				</td>
			</tr>
		</tfoot>
	</table>
</div>
	
	<!-- ---------------------------------------- -->
	<!-- ---------------------------------------- -->
	<!-- ---------------------------------------- -->
	
	<br>
	<div id="pagiDiv" align="center" style="color:lightgrey;">
		<span id="spanFirst">First</span> 
		<span id="spanPre">Prev</span> 
		<span id="spanNext">Next</span>
		<span id="spanLast">Last</span>
		<span id="spanPageNum"></span> of <span id="spanTotalPage"></span> Page
	</div>
	<br>
	
	<!-- ---------------------------------------- -->
	<!-- ---------------------------------------- -->
	<!-- ---------------------------------------- -->
	
	
</body>

</html>

