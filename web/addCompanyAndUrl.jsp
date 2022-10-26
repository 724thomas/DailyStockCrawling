<%--
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
    <div class="addUrl">
        <form action="./DoCompanyAddServlet" method="get">
            <label for="url-box">URL : ⌨️</label>
            <input type="text" id="url-box" name="url" placeholder="Paste URL..." required>
        </form>
    </div>
</Main>
<div></div>
<div></div>
</body>
</html>
