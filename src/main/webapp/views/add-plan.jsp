<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Добавить тариф</title>
	<style type="text/css">
		td{
			border: 1px solid black;
			border-collapse: collapse;
			padding:24px;
			text-align: center;
		}
		.formdiv{
			padding: 8px;
			border: 1px solid black;
			display: inline-block;
			margin-top: 24px;
		}

		.input{
			height: 20px;
			width: 300px;
			padding: 8px;
		}
	</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Информация о тарифе</h2>
<c:if test="${error==true || success==true}">
	${message}
</c:if>
<div class="formdiv">
	<form action="add" method="POST">
		<table>
			<thead>
			<tr>
				<th colspan="2"><h3>Добавить новый тарифный план</h3></th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>
					<label for="plan_title">Название тарифа</label>
				</td>
				<td>
					<input type="text" id="plan_title" class="input" name="plan_title">
				</td>
			</tr>
			<tr>
				<td>
					<label for="plan_duration">Длительность тарифа (месяцы)</label>
				</td>
				<td>
					<input type="number" id="plan_duration" class="input" name="plan_duration">
				</td>
			</tr>
			<tr>
				<td>
					<label for="plan_fees">Стоимость тарифа (INR)</label>
				</td>
				<td>
					<input type="number" id="plan_fees" class="input" name="plan_fees">
				</td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">Отправить</button></td>
			</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>
