<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Платежи</title>
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
<jsp:include page="header.jsp" ></jsp:include>
<c:if test="${error==true || success==true}">
    ${message}
</c:if>
<h2>Платежи</h2>
<table>
    <thead>
    <tr>
        <td colspan="6"><a href="payment/add-new" style="float:right"><button>Добавить новый платеж</button></a></td>
    </tr>
    <tr>
        <th>ID</th>
        <th>Сумма (INR)</th>
        <th>Дата</th>
        <th>Способ оплаты</th>
        <th>Оплачено</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${payments}" var="payment">
        <tr>
            <td>${payment.paymentId}</td>
            <td>${payment.paidAmount}</td>
            <td>${payment.paymentDate}</td>
            <td>${payment.paymentMode}</td>
            <td>${payment.subscriber.subscriberName}</td>
            <td>
                <a href="payment/${payment.paymentId}"><button>Просмотреть</button></a>
                <a href="payment/edit-payment/${payment.paymentId}"><button>Редактировать</button></a>
            </td>
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
