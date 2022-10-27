<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.time.*, java.time.format.*" %>
<%-- 지시자 (jsp 페이지가 실행될 떄 필요한 정보를 jsp 컨테이너 (catalina)에게 알리는 역할) --%>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>


<body>
<header><jsp:include page="header.jsp"/></header>
<main>
    <%-- JSP 주석 --%>
    <!-- html 주석 -->
    <div>
        <h1>🗿 주식 정보 찾기 🗿</h1>


        <%-- 선언문 (전역변수, 함수 정의) --%>
        <%!
            static final String CURRENT_FILE = "index.jsp";
        %>


        <%-- 스크립트릿 (지역변수 정의, _jspService() 함수 내에 정의) (자바 코드 해석해야하는 부분, 브라우저에 출력되지 않음) --%>
        <%
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = now.format(format);
        %>

        <%-- 표현식 (자바 코드 해설 결과 브라우저에 출력되는 부분)  --%>
        <h1> 접속시간 : <%=formatDateTime%> 🚗</h1>

        <%-- <%=var%> --%> <%-- 오류 발생 X --%>
        <%--<!-- <%=var%> -->--%> <%-- 오류 발생 O (동적인 요소를 해석할 수 없음 (변수 존재하지 않음) --%>

        <h5> (사용법) </h5>
        <h6> @ 이 사이트는 찾으려는 회사의 주식 정보를 가져와서 저장한다. (네이버 주식: finance.naver.com) @ </h6>
        <h6> 1번을 누른 후, 회사를 목록에 추가한다. </h6>
        <h6> 2번을 누르면 저장되어 있는 회사 목록을 보여준다. </h6>
        <h6> 3번을 누르면 회사 목록에 있는 회사에 대해서 금일 주식 정보를 가져와서 저장한다. </h6>
        <h6> 4번을 누르면 전체/회사별 목록을 출력하여 보여준다. </h6>
    </div>

    <ul class="main__nav__next">
        <h5>👉<a href="addCompanyAndUrl.jsp"><b> 1. Url로 회사추가로 이동</b></a></h5>
        <h5>👉<a href="showCompanyList.jsp"><b> 2. 회사 목록으로 이동</b></a></h5>
        <h5>👉<a href="addDailyStock.jsp"><b> 3. 회사별 주가 반영으로 이동</b></a></h5>
        <h5>👉<a href="showDailyStock.jsp"><b> 4. 회사별 주가 목록으로 이동</b></a></h5>
    </ul>

</main>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>