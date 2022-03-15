<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	<section id="contentwrap">
	<div id="content_bottom" class="top_padding">
		<div id="logo">
			<a href="/"> <img src="../resources/img/logo.png" alt="메인로고"
				style="height: 220px">
			</a>
		</div>
		
		<div class="t-margin-70">

                  <div style="margin-bottom: 20px">
	
		<c:choose>
			<c:when test="${vo.id != null }">
				아이디는 ${vo.id } 입니다.
			</c:when>
			<c:otherwise>
				아이디가 존재하지 않습니다.
			</c:otherwise>
		</c:choose>	
            
             </div>

			<div class="find_2">
                           
                           
                            <ul>
                               
                               
                                <li>
                                    <a href="/member/mem_findPw">비밀번호 찾기</a>
                                </li>
                                
                            
                                <li>
                                    <a href="/member/login">로그인</a>
                                </li>
                               
                                
                            </ul>
                            
                            
                        </div>
			
        </div>
	</div>
	
	</section>
	<%@ include file="../include/footer.jsp" %>
</body>
</html>