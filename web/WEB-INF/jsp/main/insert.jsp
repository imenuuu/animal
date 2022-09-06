<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>애완동물 등록 페이지</title>
    <style type="text/css"><!-- Simple Css -->
    html, body{ margin:0; padding:0}
    body{ width:1000px; margin:0 auto; }
    </style>
    <script type="text/javascript">
        function addBoard(){
            boardForm.submit();
        }
        function returnHome(){
            window.location.replace("http://localhost:9000/main.animal");
                            }

    </script>
</head>

<body>
<form action="./insert.animal" method="post" name="boardForm">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr><!-- BOARD TITLE -->
            <td colspan="2" align="center"><h2>애완동물 등록</h2></td>
        </tr>
        <tr height="40">
            <th>애완동물 이름</th>
            <td><input name="animalName" type="text" style="width:100%;" /></td>
        </tr>
        <tr height="40">
            <th>애완동물 생일</th>
            <td><input name="animalBirth" type="date" style="width:100%;" min="yyy",max="zzz"/></td>
        </tr >
        <tr height="40">
            <th>애완동물 종류</th>
            <td><input name="animalType" type="text" style="width:100%;" /></td>
        </tr>
        <tr height="40">
            <th>품종</th>
            <td><input name="animalKind" type="text" style="width:100%;" /></td>
        </tr>
        <tr height="40">
            <th>주인 이름</th>
            <td><input name="master" type="text" style="width:100%;" /></td>
        </tr>
        <tr height="40">
            <th>전화번호</th>
            <td><input name="phoneNumber" type="text" style="width:100%;" /></td>
        </tr>


        <tr>
            <td colspan="2" align="right">
                <a href="javascript:addBoard()">[ADD]</a>&nbsp;&nbsp;
                <a href="javascript:returnHome()">[홈으로]</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>