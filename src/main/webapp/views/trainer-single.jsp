<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Тренер :: ${trainer.trainerName}</title>
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
<h2>Информация о тренере</h2>
<c:if test="${error} eq true">
    <h3>${error}</h3>
</c:if>
<table>
    <thead>
    <tr>
        <th colspan="2"><h2>${trainer.trainerName}</h2></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>ID</td>
        <td>${trainer.trainerId}</td>
    </tr>
    <tr>
        <td>Возраст</td>
        <td>${trainer.trainerAge} лет</td>
    </tr>
    <tr>
        <td>Пол</td>
        <td>${trainer.trainerGender}</td>
    </tr>
    <tr>
        <td>Опыт</td>
        <td>${trainer.trainerExperience} лет</td>
    </tr>
    <tr>
        <td>Адрес</td>
        <td>${trainer.trainerAddress}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
