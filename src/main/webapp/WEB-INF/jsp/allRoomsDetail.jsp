<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Rooms Details</title>
</head>
<body>
<table align="center">
<h2>Today's Report</h2>
<tr>
    <th>Room No</th>
    <th>Name</th>
    <th>Address</th>
    <th>Personal Id Type</th>
    <th>Personal Id No</th>
    <th>Personal Id Photo Location</th>
    <th>Rent</th>
    <th>Commission</th>
    <th>Number of Days stay</th>
    <th>Date</th>
  </tr>
<c:forEach items="${allRoomList}" var="roomData">
    <tr>
        <td>${roomData.roomNo}</td>
         <td>${roomData.name}</td>
          <td>${roomData.address}</td>
          <td>${roomData.personalId}</td>
          <td>${roomData.personalIdNo}</td>
          <td>${roomData.photo}</td>
           <td>${roomData.rent}</td>
            <td>${roomData.commission}</td>
            <td>${roomData.numberOfDays}</td>
            <td>${roomData.date}</td>  
    </tr>
</c:forEach>
<tr><td><input type=button value="Back" onCLick="history.back()"></td></tr>
</table>
</body>
</html>