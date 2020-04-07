<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>NO</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
        <c:forEach var="board" items="${boardList}" varStatus="loop">
            <tr>
                <td>${board.seq}</td>
                <td><a href="<c:url value="/board/read/${board.seq}" /> ">${board.title}</a></td>
                <td>${board.writer}</td>
                <td>${board.regDate}</td>
                <td>${board.cnt}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="<c:url value="/board/list"/> ">새글</a>
</body>
</html>