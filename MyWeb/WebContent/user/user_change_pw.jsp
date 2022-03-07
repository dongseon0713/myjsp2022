<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/_header.jsp" %>
	
<c:choose>
	<c:when test="${sessionScope.user_id eq null}">
		<c:redirect url="user_login.jsp" />
	</c:when>
</c:choose>
	<section>
		<div align="center">
			<h3>비밀번호 변경 페이지</h3>
			<hr>
			<form action="user_change_pw_ok.jsp" method="post">
				<table>
					<tr>
						<td>현재 비밀번호</td>
						<td><input type="password" name="old_pw"></td>
					</tr>
					<tr>
						<td>변경 비밀번호</td>
						<td><input type="password" name="new_pw"></td>
					</tr>
				</table>
				<input type="submit" value="확인">
				<input type="button" value="취소" onclick="history.go(-1)">
			</form>
		</div>
	</section>

<%@ include file="../include/_footer.jsp" %>