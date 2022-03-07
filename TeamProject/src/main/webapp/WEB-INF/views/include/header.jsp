<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
    <title>Project_header</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/proj_css.css" type="text/css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
     

</head>
<body>

 <div id="wrap">


        <header id="header">

            <div class="container">

                <h2><a href="/">모아맛집</a></h2>
                <nav>

                    <ul>
                        <li class="bor-r bor-l"><a href="">상단 메뉴 1</a></li>
                        <li class="bor-r"><a href="">상단 메뉴 2</a></li>
                        <li class="bor-r"><a href="">상단 메뉴 3</a></li>
                        <c:choose>
                        	<c:when test="${sessionScope.user_id != null }">
                        		<li class="bor-r"><a href="">내 정보</a></li>
                        		<li><a href="/member/mem_logout">로그아웃</a></li>
                        	</c:when>
                        	<c:otherwise>
                        		<li class="bor-r"><a href="/member/login">로그인</a></li>
                        		<li><a href="/member/join">회원 가입</a></li>
                        	</c:otherwise>
                        </c:choose>
                    </ul>

                </nav>

            </div>

        </header>

