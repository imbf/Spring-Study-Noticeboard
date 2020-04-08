<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>

<%-- form 태그에 action 정보가 없어도 Spring이 브라우저 창을 참고해서 자동으로 action정보를 설정 --%>
<form:form commandName="boardDTO" method="post">
    <table border="1">
        <tr>
            <th><form:label path="title">제목</form:label></th>
            <td><form:input path="title"/>
                <form:errors path="title"/></td>
        </tr>
        <tr>
            <th><form:label path="content">내용</form:label></th>
            <td><form:input path="content"/>
                <form:errors path="content"/></td>
        </tr>
        <tr>
            <th><form:label path="writer">작성자</form:label></th>
            <td><form:input path="writer"/>
                <form:errors path="writer"/></td>
        </tr>
        <tr>
            <th><label for="pwd">비밀번호</label></th>
            <td><input type="password" id="pwd" name="pwd"/>${msg}</td>
        </tr>
    </table>
    <div>
        <input type="submit" value="등록">
        <a href="<c:url value="/board/list"/>">목록</a>
    </div>
</form:form>
</body>
</html>
