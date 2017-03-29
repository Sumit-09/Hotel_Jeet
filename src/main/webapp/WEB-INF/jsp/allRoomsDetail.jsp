<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Rooms Details</title>
</head>
<body>
<c:forEach items="${allRoomList}" var="roomData">
    <tr>
        <td>Room No: <c:out value="${roomData.roomNo}"/></td>
         <td>Name: <c:out value="${roomData.name}"/></td>
          <td>Address: <c:out value="${roomData.address}"/></td>
           <td>Rent: <c:out value="${roomData.rent}"/></td>
            <td>commission : <c:out value="${roomData.commission}"/></td> 
    </tr>
</c:forEach>
</body>
</html>