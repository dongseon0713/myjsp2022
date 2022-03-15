<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp"%>
<section id="contentwrap">

		<div id="content_bottom" class="top_padding">
			<div id="logo">
				<a href="/"> <img src="../resources/img/logo.png" alt="메인로고"
					style="height: 220px">
				</a>
			</div>
			
			
				 <div class="t-margin-70">

                  <div style="margin-bottom: 20px">
                    ${sessionScope.user_id }님 환영합니다.
                  </div>
  
           	
           	<div id="btn_area_mypage">
          
                    <div id="btn_mypage" onclick="location.href='/member/mem_modifyCheck'">
                		<a href="/member/mem_modifyCheck" role="button">회원 정보 수정</a>
                	</div>
                	
                	  <div id="btn_mypage" onclick="location.href='/member/mem_unregister">
                		<a href="/member/mem_unregister" role="button">회원 탈퇴</a>
                	</div>
                    <div id="btn_mypage" onclick="location.href='/member/mem_alterPw'">
                		<a href="/member/mem_alterPw" role="button">비밀번호 변경</a>
                	</div>
            </div>
            
            
		</div>
    </div>
</section>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  	var msg = '${msg }';
  	
  		if(msg != ''){
  		alert(msg);
  		}
  	});
</script>
<%@ include file="../include/footer.jsp"%>
</body>
</html>