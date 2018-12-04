
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Logout</title>

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

#logout{   
    position: absolute;   
    top: 50%;   
    left:50%;   
    margin: -150px 0 0 -150px;   
       
    height: 300px;   
}

#logout h2{   
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

button{   
    width: 30px;   
    min-height: 9px;   
    display: block;   
    background-color: #4a77d4;   
    border: 1px solid #3762bc;   
    color: #fff;   
    padding: 14px 14px;   
    font-size: 15px;   
    line-height: normal;   
    border-radius: 5px;   
    margin: 0;   
}

</style>


</head>

<body>
<div id="logout">
<h2>Loged out Successfully！</h2>


<br>


<a id="loginAgain11" href = "login.jsp" onclick="javascript:window.location.href('login.jsp');return false;">Login again</a>
</div>
</body>

</html>