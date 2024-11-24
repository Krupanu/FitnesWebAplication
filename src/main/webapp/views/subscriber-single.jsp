<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Подписчик :: ${subscriber.subscriberName}</title>
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
<h2>Информация о подписчике</h2>
<c:if test="${error==true || success==true}">
    ${message}
</c:if>
<table>
    <thead>
    <tr>
        <th colspan="2"><h3>${subscriber.subscriberName}</h3></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>ID</td>
        <td>${subscriber.subscriberId}</td>
    </tr>
    <tr>
        <td>Пол</td>
        <td>${subscriber.subscriberGender}</td>
    </tr>
    <tr>
        <td>Возраст (года)</td>
        <td>${subscriber.subscriberAge}</td>
    </tr>
    <tr>
        <td>Адрес</td>
        <td>${subscriber.subscriberAddress}</td>
    </tr>

    <tr>
        <td>Оплаченные сборы</td>
        <td>${subscriber.subscriberFeesPaid}</td>
    </tr>
    <tr>
        <td>Назначенный тренер</td>
        <td><a href="/trainer/${subscriber.trainer.trainerId}">${subscriber.trainer.trainerName}</a></td>
    </tr>
    <tr>
        <td>План подписки</td>
        <td><a href="/subscriptionplan/${subscriber.subscriptionPlan.planId}">${subscriber.subscriptionPlan.planTitle}</a></td>
    </tr>
    <tr>
        <td>Статус подписчика</td>
        <td>
            <c:if test="${subscriber.subscriberStatus == false}">
                Неактивен
            </c:if>
            <c:if test="${subscriber.subscriberStatus == true}">
                Активен
            </c:if>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
