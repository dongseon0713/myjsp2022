<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
              <div class="col-lg-3"></div>
              
              <div class="col-lg-6">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">MyPage</h1>
              </div>
              
              
              <!-- 자바스크립트(제이쿼리) 를 사용하기전에 input 태그의 id속성을 확인하세요. -->
              
                <!-- 세션값 -->
                <div class="text-center">
                  <div>
                    ${sessionScope.user_id }님 환영합니다.
                  </div>
                </div>
                <br>
				
				<input type="button" class="btn btn-primary btn-user btn-user btn-block" value="회원 탈퇴" onclick="location.href='delete'">
   				<input type="button" class="btn btn-primary btn-user btn-user btn-block" value="회원 정보 수정" onclick="location.href='modify'">
   				<input type="button" class="btn btn-primary btn-user btn-user btn-block" value="비밀번호 변경" onclick="location.href='pwCheck'">
              <hr>
              <div class="text-center">
                <a class="small" href="/">메인으로</a><!-- 절대경로 -->
              </div>
              <div class="text-center">
                <a class="small" href="logout">로그아웃</a>
              </div>
              <div class="col-lg-3"></div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

<%@ include file="../include/footer.jsp" %>
</body>
</html>