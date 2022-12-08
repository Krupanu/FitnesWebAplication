<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>``
    <head>
        <title>Payment :: ${payment.subscriber.subscriberName}</title>
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
        <h2>Subscription payment Information</h2>
        <c:if test="${error} eq true">
            <h3>${error}</h3>
        </c:if>
        <table>
    		<thead>
    			<tr>
    				<th colspan="2"><h2>Payment By - ${payment.subscriber.subscriberName}</h2></th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<td>ID</td>
    				<td>${payment.paymentId}</td>
                </tr>
                <tr>
                    <td>Paid Amount</td>
                    <td>${payment.paidAmount}</td>
                </tr>
                <tr>
                    <td>Payment Date</td>
                    <td>${payment.paymentDate}</td>
                </tr>
                <tr>
                    <td>Payment Mode</td>
                    <td>${payment.paymentMode}</td>
                </tr>
                <tr>
                    <td>Paid By</td>
                    <td><a href="/subscriber/${payment.subscriber.subscriberId}">${payment.subscriber.subscriberName}</a></td>
                </tr>
    		</tbody>
    	</table>
    	<hr>
    	<!-- h2>All subscribers of this payment</h2>
    	<table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${citizens}" var="citizen">
                <tr>
                    <td>${citizen.citizenId}</td>
                    <td>${citizen.citizenName}</td>
                    <td><a href="../citizens/${citizen.citizenId}">View</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table-->
    </body>
</html>