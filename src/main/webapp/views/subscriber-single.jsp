<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>${pageTitle}</title>
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
        <h2>Citizen Information</h2>
        <c:if test="${error==true || success==true}">
            ${message}
        </c:if>
        <table>
    		<thead>
    			<tr>
    				<th colspan="2"><h3>${citizen.citizenName}</h3></th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<td>ID</td>
    				<td>${citizen.citizenId}</td>
                </tr>
                
                <tr>
                    <td>City</td>
                    <td>${citizen.citizenCity}</td>
                </tr>

                <tr>
                    <td>Number of Vaccines</td>
                    <td>${citizen.citizenDoses}</td>
                </tr>
                <tr>
                    <td>Vaccination Status</td>
                    <td>
                        <c:if test="${citizen.citizenDoses == 0}">
                            Not Vaccinated
                        </c:if>
                        <c:if test="${citizen.citizenDoses == 1}">
                            Partially Vaccinated
                        </c:if>
                        <c:if test="${citizen.citizenDoses == 2}">
                            Fully Vaccinated
                        </c:if>
                    </td>
                </tr>

                <tr>
                    <td>Allocated Vaccination Center</td>
                    <td><a href="../vaccinationcenter/${citizen.citizenCenterId}">${citizen.citizenCenter}</a></td>
                </tr>
    		</tbody>
    	</table>
    </body>
</html>