<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>My JSP 'index.jsp' starting page</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">   
  </head>  
    
  <body>  
    用户登陆 <br>  
      <form action="j_spring_security_check" method="post">  
        USERNAME:<input type="text" name="j_username" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" /><br/>  
        PASSWORD:<input type="password" name="j_password" value="" /><br/>  
        <input type="submit">       
    </form>  
  </body>  
</html> 