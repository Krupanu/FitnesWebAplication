<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Добавить абонента</title>
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
            padding: 8px;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Информация об абоненте</h2>
<c:if test="${error==true || success==true}">
    ${message}
</c:if>
<div class="formdiv">
    <form action="add" method="POST">
        <table>
            <thead>
            <tr>
                <th colspan="2"><h3>Добавить нового абонента</h3></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <label for="subscriber_name">Имя абонента</label>
                </td>
                <td>
                    <input type="text" id="subscriber_name" class="input" name="subscriber_name" required>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="subscriber_age">Возраст абонента</label>
                </td>
                <td>
                    <input type="text" id="subscriber_age" class="input" name="subscriber_age" required>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="subscriber_gender">Пол абонента</label>
                </td>
                <td>
                    <input type="radio" id="subscriber_gender_male" name="subscriber_gender" value="Мужской">
                    <label for="subscriber_gender_male">Мужской</label>
                    <input type="radio" id="subscriber_gender_female" name="subscriber_gender" value="Женский">
                    <label for="subscriber_gender_female">Женский</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="subscriber_address">Адрес абонента</label>
                </td>
                <td>
                    <textarea id="subscriber_address" class="input" style="height: 200px" required name="subscriber_address"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="subscriber_trainer_id">Выберите тренера</label>
                </td>
                <td>
                    <select id="subscriber_trainer_id" name="subscriber_trainer_id" class="input" required>
                        <option value="">Выберите тренера</option>
                        <c:forEach items="${trainers}" var="trainer">
                            <option value="${trainer.trainerId}">${trainer.trainerName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="subscription_plan_id">Тарифный план</label>
                </td>
                <td>
                    <select id="subscription_plan_id" name="subscription_plan_id" class="input" required>
                        <c:forEach items="${subscriptionPlans}" var="plan">
                            <option value="${plan.planId}">
                                    ${plan.planTitle}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Отправить</button></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
