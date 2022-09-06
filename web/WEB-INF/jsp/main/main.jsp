<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="handler.dto.GetAnimalRes" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
<html lang="ko">
<head>

    <meta charset="UTF-8">
    <title>동물 리스트</title>

    <style>
        table {
            width: 100%;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
    </style>
    <script>
        $(document).ready(function() {
            $('th').each(function (column) {
                $(this).click(function() {
                    if($(this).is('.asc')) {
                        $(this).removeClass('asc');
                        $(this).addClass('desc');
                        sortdir=-1;
                    } else {
                        $(this).addClass('asc');
                        $(this).removeClass('desc');
                        sortdir=1;
                    }
                    $(this).siblings().removeClass('asc');
                    $(this).siblings().removeClass('desc');
                    var rec = $('table').find('tbody>tr').get();
                    rec.sort(function (a, b) {
                        var val1 = $(a).children('td').eq(column).text().toUpperCase();
                        var val2 = $(b).children('td').eq(column).text().toUpperCase();
                        return (val1 < val2)?-sortdir:(val1>val2)?sortdir:0;
                    });
                    $.each(rec, function(index, row) {
                        $('tbody').append(row);
                    });
                });
            });
        });
    </script>
</head>

<body>
<h1>동물 리스트</h1>
<hr><br>
<div>
    <form>
        <fieldset>
                <option ${(param.f == "title")? "selected" : ""} value = "name">애완동물 이름</option>
            <input type = "text" name = "name" value = "${param.name}"/>
            <input type = "submit" value = "검색">
        </fieldset>
    </form>
</div>
<table id="list">
    <thead>
    <tr>
        <th style="background-color:#eeeeee; text-align:center;">동물 이름</th>
        <th style="background-color:#eeeeee; text-align:center;">동물 생년월일</th>
        <th style="background-color:#eeeeee; text-align:center;">동물 종류</th>
        <th style="background-color:#eeeeee; text-align:center;">품종</th>
        <th style="background-color:#eeeeee; text-align:center;">주인 이름</th>
        <th style="background-color:#eeeeee; text-align:center;">주인 전화번호</th>
    </tr>
    </thead>
    <c:forEach var="dto" items="${list }">
    <tr>
        <td>${dto.animalName}</td>
        <td>${dto.animalBirth}</td>
        <td>${dto.animalType}</td>
        <td>${dto.animalKind}</td>
        <td>${dto.master}</td>
        <td>${dto.phoneNumber}</td>
    </tr>
        </c:forEach>
</table>
<br>
<button onclick="location.href='getInsert.animal'">신규 등록</button>
<button onclick="location.href='main.animal'">홈화면</button>
</body>
</html>

