<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New User</title>
</head>
<body>
<form method="POST" action='UserHandler' name="formAddUser"><input
type="hidden" name="action" value="insert" />
<p><b>Add New Record</b></p>
<table>
<tr>
<td>User ID</td>
<td><input type="text" name="userid" /></td>
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
<td><input type="submit" value="Submit" /></td>
</tr>
</table>
</form>
<p><a href="UserHandler?action=listUser">View-All-Records</a></p>
</body>
</html>