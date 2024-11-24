<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
<head>
	<title>Подписчики</title>
	<style type="text/css">
		table, th, td{
			border: 1px solid black;
			border-collapse: collapse;
			padding:8px;
			text-align: center;
		}
	</style>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Подписчики</h2>
<c:if test="${error==true || success==true}">
	${message}
</c:if>
<table>
	<thead>
	<tr>
		<td colspan="8"><a href="subscriber/add-new" style="float:right"><button>Добавить нового подписчика</button></a></td>
	</tr>
	<tr>
		<th>ID</th>
		<th>Имя</th>
		<th>Возраст</th>
		<th>Пол</th>
		<th>Адрес</th>
		<th>Статус</th>
		<th>Оплаченные сборы</th>
		<th>Действие</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${subscriber_list}" var="subscriber">
		<tr>
			<td>${subscriber.subscriberId}</td>
			<td>${subscriber.subscriberName}</td>
			<td>${subscriber.subscriberAge}</td>
			<td>${subscriber.subscriberGender}</td>
			<td>${subscriber.subscriberAddress}</td>
			<td>
				<c:if test="${subscriber.subscriberStatus == false}">
					Неактивен
				</c:if>
				<c:if test="${subscriber.subscriberStatus == true}">
					Активен
				</c:if>
			</td>
			<td>${subscriber.subscriberFeesPaid}</td>
			<td>
				<a href="subscriber/${subscriber.subscriberId}"><button>Просмотр</button></a>
				<a href="subscriber/edit-subscriber/${subscriber.subscriberId}"><button>Редактировать</button></a>
				<a href="subscriber/delete/${subscriber.subscriberId}"><button>Удалить</button></a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
	<tr>
		<td colspan="8">${message}</td>
	</tr>
	</tfoot>
</table>
</body>
</html>
