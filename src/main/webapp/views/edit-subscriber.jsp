<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Edit Citizen</title>
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
		}
	</style>
</head>
<body>
    <jsp:include page="header.jsp" ></jsp:include>
    <h2>Citizen Information</h2>
    <c:if test="${error==true || success==true}">
        ${message}
    </c:if>
	<div class="formdiv">
		<form action="/citizens/edit" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3>Edit Citizen</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<label for="citizen_name">Citizen Name</label>
						</td>
						<td>
							<input type="hidden" id="citizen_id" class="input" name="citizen_id" value="${citizen.citizenId}">
							<input type="text" id="citizen_name" class="input" name="citizen_name" value="${citizen.citizenName}">
						</td>
					</tr>
					<tr>
						<td>
							<label for="citizen_city">Citizen City</label>
						</td>
						<td>
							<select id="citizen_city" name="citizen_city" class="input">
								<option value="">Select city</option>
                                <c:forEach items="${cities}" var="city">
                                    <option value="${city}" <c:if test="${city == citizen.citizenCity}">selected</c:if>>
                                        ${city}
                                    </option>
                                </c:forEach>
							</select>
						</td>
					</tr>
					<tr>
					    <td>
                            <label for="citizen_doses">No. Of Doses</label>
                        </td>
                        <td>
                            <select name="citizen_doses" id="citizen_doses" class="input" <c:if test="${citizen.citizenDoses==2}">disabled</c:if>>

                                 <c:if test="${citizen.citizenDoses==0}">
                                    <option value="0" selected>None</option>
                                    <option value="1">One</option>
                                    <option value="2" disabled>Two</option>
                                 </c:if>
                                <c:if test="${citizen.citizenDoses==1}">
                                    <option value="0" disabled>None</option>
                                    <option value="1" selected disabled>One</option>
                                    <option value="2">Two</option>
                                </c:if>
                            </select>
                            <c:if test="${citizen.citizenDoses==2}">
                                Fully Vaccinated
                            </c:if>
                        </td>
					</tr>
					<tr>
						<td>
							<label for="citizen_center">Vaccination Center</label>
						</td>
						<td>
							<select id="citizen_center" name="citizen_center" class="input" <c:if test="${citizen.citizenDoses==2}">disabled</c:if>>
							<c:forEach items="${vaccinationCenters}" var="center">
							    <option value="${center.centerId}" <c:if test="${center.centerId == citizen.centerId}">selected</c:if>>
							        ${center.centerName}
							    </option>
							</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><button type="submit">Submit</button></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>