<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<table border="1">
    <tr>
        <th>제목</th>
        <td>${boardDTO.title}</td>
    </tr>
    <tr>
        <th>작성자</th>
        <td>${boardDTO.writer}</td>
    </tr>
    <tr>
        <th>작성일</th>
        <td>${boardDTO.regDate}</td>
    </tr>
    <tr>
        <th>조회수</th>
        <td>${boardDTO.cnt}</td>
    </tr>
</table>
<div>
    <a href="<c:url value="/board/edit/${boardDTO.seq}"/>">수정</a>
    <a href="<c:url value="/board/delete/${boardDTO.seq}"/>">삭제</a>
    <a href="<c:url value="/board/list"/>">목록</a>
</div>
</body>
</html>
