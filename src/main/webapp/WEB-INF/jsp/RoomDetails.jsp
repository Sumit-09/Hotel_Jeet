<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Details</title>
</head>
<body>
	<form:form action="roomData" method="post" modelAttribute="roomDetails">
		<table align="center" border="2">
			<tr>
				<th width="48%">Room No</th>
				<td><form:input path="roomNo" value="${roomNumber}" /></td>
			</tr>

			<tr>
				<th width="48%">Name</th>
				<td><form:input path="name" /></td>
			</tr>

			<tr>
				<th width="48%">Address</th>
				<td><form:input path="address" /></td>
			</tr>

			<tr>
				<th width="48%">Personal Id</th>
				<td><form:select path="personalId">
						<form:option value="Select..." />
						<form:option value="Voter Id Card" />
						<form:option value="PAN Card" />
					</form:select></td>
			</tr>

			<tr>
				<th width="48%">Personal Id Number</th>
				<td><form:input path="personalIdNo" /></td>
			</tr>

			<tr>
				<th width="48%">Photo</th>
				<td><form:input path="photo" /></td>
			</tr>

			<tr>
				<th width="48%">Rent</th>
				<td><form:input path="rent" /></td>
			</tr>

			<tr>
				<th width="48%">Commission</th>
				<td><form:input path="commission" /></td>
			</tr>

			<tr>
				<th width="48%">No. of Days</th>
				<td><form:input path="numberOfDays" /></td>
			</tr>

			<tr>
				<th width="48%">Date</th>
				<td><form:input path="date" /></td>
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