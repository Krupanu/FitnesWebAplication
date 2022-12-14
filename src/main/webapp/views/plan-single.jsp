<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>${plan.planTitle}</title>
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
        <h2>Subscription Plan Information</h2>
        <c:if test="${error} eq true">
            <h3>${error}</h3>
        </c:if>
        <table>
    		<thead>
    			<tr>
    				<th colspan="2"><h2>${plan.planTitle}</h2></th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<td>ID</td>
    				<td>${plan.planId}</td>
                </tr>
                <tr>
                    <td>Duration(Months)</td>
                    <td>${plan.planDuration}</td>
                </tr>
                <tr>
                    <td>Fees</td>
                    <td>${plan.planFees}</td>
                </tr>
    		</tbody>
    	</table>
    	<hr>
    	<!-- h2>All subscribers of this plan</h2>
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