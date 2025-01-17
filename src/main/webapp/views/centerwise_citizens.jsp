<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html lang="ru">
<head>
	<title>${pageTitle}</title>
	<style type="text/css">
		table, th, td {
			border: 1px solid black;
			border-collapse: collapse;
			padding: 8px;
			text-align: center;
		}
	</style>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Граждане</h2>
<c:if test="${error==true || success==true}">
	${message}
</c:if>
<table>
	<thead>
	<tr>
		<th>ID</th>
		<th>Имя</th>
		<th>Город</th>
		<th>Количество доз</th>
		<th>Статус вакцинации</th>
		<th>Центр вакцинации</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${citizens}" var="citizen">
		<tr>
			<td>${citizen.citizenId}</td>
			<td>${citizen.citizenName}</td>
			<td>${citizen.citizenCity}</td>
			<td>${citizen.citizenDoses}</td>
			<td>
				<c:if test="${citizen.citizenDoses == 0}">
					Не вакцинирован
				</c:if>
				<c:if test="${citizen.citizenDoses == 1}">
					Частично вакцинирован
				</c:if>
				<c:if test="${citizen.citizenDoses == 2}">
					Полностью вакцинирован
				</c:if>
			</td>
			<td><a href="../../vaccinationcenter/${citizen.citizenCenterId}">${citizen.citizenCenter}</a></td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
	<tr>
		<td colspan="6">${message}</td>
	</tr>
	</tfoot>
</table>
</body>
</html>
