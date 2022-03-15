<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Project_header</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/proj_css.css"
	type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

</head>
<body>

	<div id="wrap">


		<header id="header">

			<div class="container">

				<h2>
					<a href="/">모아맛집</a>
				</h2>
				<nav>

					<ul>
						<c:choose>
							<c:when test="${sessionScope.user_id != null }">
								<li class="bor-r bor-l"><a href="/member/mem_mypage">내정보</a>
									<ul class="bor-r" id="submenu">
										<li><a href="/member/mem_modifyCheck">회원 정보 수정</a></li>
										<li><a href="##">회원 정보 탈퇴</a></li>
										<li class="bor-b"><a href="/member/mem_alterPw">비밀번호 변경</a></li>
									</ul></li>
								<li><a href="/member/mem_logout">로그아웃</a></li>
							</c:when>
							<c:otherwise>
								<li class="bor-r bor-l"><a href="/member/login">로그인</a></li>
								<li><a href="/member/join">회원가입</a></li>
							</c:otherwise>
						</c:choose>

					</ul>

				</nav>

			</div>
				<div id="header_back"></div>
		</header>