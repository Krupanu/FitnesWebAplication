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
        <jsp:include page="header.jsp" ></jsp:include>
        <c:if test="${error==true || success==true}">
            ${message}
        </c:if>
        <h2>Centers</h2>
        <table>
            <thead>
                <tr>
                    <td colspan="4"><a href="vaccinationcenter/add-new" style="float:right"><button>Add New Center</button></a></td>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>City</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${centers}" var="center">
                <tr>
                    <td>${center.centerId}</td>
                    <td>${center.centerName}</td>
                    <td>${center.centerCity}</td>
                    <td>
                        <a href="vaccinationcenter/${center.centerId}"><button>View</button></a>
                        <a href="vaccinationcenter/edit-center/${center.centerId}"><button>Edit</button></a>
                        <a href="vaccinationcenter/delete/${center.centerId}"><button>Delete</button></a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="4">${message}</td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>