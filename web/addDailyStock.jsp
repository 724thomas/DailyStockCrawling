<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-26
  Time: 오전 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>

<Main>
    <div>
        <ul class="main__nav__next">
            <%
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
                String formatDateTime = now.format(format);
            %>
            <h1><%=formatDateTime%> 데이터 추가 완료 🚗</h1>
        </ul>
    </div>
    <h1>👉🏻<a href="index.jsp"><b>뒤로가기</b></a></h1>
</Main>
<div></div>
<div></div>
</body>
</html>
