<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.sai.bean.UserBean"%>
<%@ page import="com.sai.dao.UserDao"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All User</title>
</head>
<body>
<%
//UserBean user = new UserBean();
UserDao dao = new UserDao();
List<UserBean> userList = dao.getAllUsers();
//Iterator<UserBean> itr = userList.iterator();
%>
<table border="1">
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>dob</th>
<th>gender</th>
<th>address</th>
</tr>
<tr>
<%
/*while(itr.hasNext())
{
System.out.println(user.getId());*/
for (UserBean user : userList) {
%>
<td><%=user.getId()%></td>
<td><%=user.getfName()%></td>
<td><%=user.getlName()%></td>
<td><%=user.getdob() %></td>
<td><%=user.getgender() %></td>
<td><%=user.getaddress()%></td>
<td><a
href="UserHandler?action=editform&userId=<%=user.getId()%>">Update</a></td>
<td><a
href="UserHandler?action=delete&userId=<%=user.getId()%>">Delete</a></td>

</tr>
<%
}
//}
%>
</table>
<p><a href="UserHandler?action=insert">Add User</a></p>
</body>
</html>