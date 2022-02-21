<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.sai.bean.UserBean"%>
<%@ page import="com.sai.dao.UserDao"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<%UserBean user = new UserBean();%>
<%UserDao dao = new UserDao();%>
<form method="POST" action='UserHandler' name="formEditUser"><input
type="hidden" name="action" value="edit" /> <%
String uid = request.getParameter("userId");
if (!((uid) == null)) {
int id = Integer.parseInt(uid);
user = dao.getUserById(id);
%>
<table>
<tr>
<td>User ID</td>
<td><input type="text" name="userId" value="<%=user.getId()%>"></td>
</tr>
<tr>
<td>First Name</td>
<td><input type="text" name="firstName" /></td>
</tr>
<tr>
<td>Last Name</td>
<td><input type="text" name="lastName" /></td>
</tr>
<tr>
<td>dob</td>
<td><input type="text" name="dob" /></td>
</tr>
<tr>
<td>gender</td>
<td><input type="text" name="gender" /></td>
</tr>
<tr>
<td>address</td>
<td><input type="text" name="address" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Update" /></td>
</tr>
</table>
<%
} else
out.println("ID Not Found");
%>
</form>
</body>
</html>