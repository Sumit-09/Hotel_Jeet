<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Room</title>
</head>
<body>
<form:form action="saveRooms" method="post" modelAttribute="room">
		<table align="center" border="2">
			<tr>
				<th width="48%">Room No</th>
				<td><form:input path="roomNumber" value="${roomNumber}" /></td>
			</tr>
			<tr>
				<td width="48%" align="right"><input type="submit"
					name="Submit" value="Submit form" /></td>
				<td width="48%"><input type="reset" name="Reset"
					value="Reset form" /></td>
			</tr>
			<tr><td><input type=button value="Back" onCLick="history.back()"></td></tr>
			</table>
			</form:form>
</body>
</html>