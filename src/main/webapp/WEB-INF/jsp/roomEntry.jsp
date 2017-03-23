<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--     <select label="Room List" array=listOfRooms name="Room List">
        <c:forEach var="rooms" items="${listOfRooms}">
            <option value="${rooms}">
                <c:out value="${rooms.roomNumber}"/>
            </option>
        </c:forEach>
    </select> --%>
     <form:form modelAttribute="selectedRoom" method="POST" action="/Hotel_Jeet/selectRooms" style="width: 310px;">
   <input type="submit" value="Select Room" style="height: 68px; width: 197px; ">
        <tr>
            <td>room:</td>
            <td><form:select path="roomNumber">
                <form:option value="0" label="--- Select ---" />
                <c:forEach var="rooms" items="${listOfRooms}">
                    <form:option value="${rooms.roomNumber}"><c:out value="${rooms.roomNumber}"/></form:option>
                </c:forEach>
                </form:select>
            </td>
        </tr>
</form:form>
</body>
</html>