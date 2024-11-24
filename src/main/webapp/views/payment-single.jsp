<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Платеж :: ${payment.subscriber.subscriberName}</title>
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
<h2>Информация о платеже за подписку</h2>
<c:if test="${error} eq true">
    <h3>${error}</h3>
</c:if>
<table>
    <thead>
    <tr>
        <th colspan="2"><h2>Платеж от - ${payment.subscriber.subscriberName}</h2></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>ID</td>
        <td>${payment.paymentId}</td>
    </tr>
    <tr>
        <td>Сумма платежа</td>
        <td>INR. ${payment.paidAmount}</td>
    </tr>
    <tr>
        <td>Дата платежа</td>
        <td>${payment.paymentDate}</td>
    </tr>
    <tr>
        <td>Способ оплаты</td>
        <td>${payment.paymentMode}</td>
    </tr>
    <tr>
        <td>Оплатил</td>
        <td><a href="/subscriber/${payment.subscriber.subscriberId}">${payment.subscriber.subscriberName}</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>
