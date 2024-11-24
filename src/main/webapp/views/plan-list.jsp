<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Тарифные планы</title>
    <style type="text/css">
        table,th,td{
            border: 1px solid black;
            border-collapse: collapse;
            padding:8px;
            text-align: center;
        }
    </style>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<c:if test="${error==true || success==true}">
    ${message}
</c:if>
<h2>Тарифные планы</h2>
<table>
    <thead>
    <tr>
        <td colspan="5"><a href="subscriptionplan/add-new" style="float:right"><button>Добавить новый тариф</button></a></td>
    </tr>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Длительность (Месяцы)</th>
        <th>Стоимость</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${subscriptionPlans}" var="subscriptionPlan">
        <tr>
            <td>${subscriptionPlan.planId}</td>
            <td>${subscriptionPlan.planTitle}</td>
            <td>${subscriptionPlan.planDuration}</td>
            <td>INR. ${subscriptionPlan.planFees}</td>
            <td>
                <a href="subscriptionplan/${subscriptionPlan.planId}"><button>Просмотреть</button></a>
                <a href="subscriptionplan/edit-plan/${subscriptionPlan.planId}"><button>Редактировать</button></a>
                <a href="subscriptionplan/delete/${subscriptionPlan.planId}"><button>Удалить</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="5">${message}</td>
    </tr>
    </tfoot>
</table>
</body>
</html>
