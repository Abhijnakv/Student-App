<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
<head> 
<style> 
.heading { 
color: #000080; 
} 
.sub { 
color: #1e90ff; 
} 
.success 
{ 
} 
color:green; 
.failure 
{ 
color:red; 
} 
</style> 
<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">  
</head> 
<body bgcolor='#add8e6'> 
<div align="center"> 
<h1 class="heading">Pentagon Space</h1> 
  <h3 class="sub">Login</h3> 
  <%String success=(String)request.getAttribute("success");%> 
  <%if(success!=null){%> 
  <h3 class="success"><%=success %></h3> 
  <%}%> 
  <%String error=(String)request.getAttribute("error"); %> 
  <%if(error!=null){%> 
  <h3 class="failure"><%=error%></h3> 
  <%}%> 
  <form action="login" method="post"> 
 <br> 
   <table> 
    <tr> 
     <td><b>Enter your mail ID:</b></td> 
     <td><input type="email" name="mail" required="required"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    <tr> 
     <td><b>Enter the password:</b></td> 
     <td><input type="password" name="password" required="required"></td> 
    </tr> 
    <tr> 
     <td><br></td>
     <td><br></td> 
    </tr> 
    <tr> 
     <td><input class="btn btn-success" type="submit" value="Login"></td> 
     <td><a href="forgotPassword.jsp">forgot password?</a></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
   </table> 
   Don't have a account?<a href="signup.jsp">signup</a>  
  </form> 
 </div> 
</body> 
</html> 