<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Exam Papers</h2>
	<table border="1">
		<tr>
			<th>Subject</th>
			<th>Start Time</th>
			<th>End Time</th>
			<th>Examnor</th>
			<th>Location</th>
		</tr>

		<c:forEach var="paper" items="${papersList}">
			<tr>
				<td>${paper.subjectName}</td>
				<td>${paper.startTime}</td>
				<td>${paper.endTime}</td>
				<td>${paper.examinerRef}</td>
				<td>${paper.examHall}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>