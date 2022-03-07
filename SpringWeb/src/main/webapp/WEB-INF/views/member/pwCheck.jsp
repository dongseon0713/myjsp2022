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
                <h1 class="h4 text-gray-900 mb-4">비밀번호 변경 확인</h1>
              </div>
              
              
              <!-- 자바스크립트(제이쿼리) 를 사용하기전에 input 태그의 id속성을 확인하세요. -->
              <form class="user" action="pwForm" method="post" id="pwForm">
                <!-- 아이디 -->
                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" placeholder="아이디" name="id" id="id">
                  </div>
                </div>
             
                
                <!-- 비밀번호 -->
                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" placeholder="비밀번호" name="pw" id="pw">
                  </div>
                </div>


				
				<input type="button" class="btn btn-primary btn-user btn-user btn-block" value="비밀번호 변경" onclick="pwCheck()">
               
              </form>
                           
              <hr>
              <div class="text-center">
                <a class="small" href="/">메인으로</a><!-- 절대경로 -->
              </div>
              <div class="col-lg-3"></div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
<%@ include file="../include/footer.jsp" %>
<script type="text/javascript">
	
	function pwCheck() {
		if($("#id").val().length < 1){
			alert("이름을 입력하세요.");
		}else if ($('#pw').val().length < 1){
			alert("비밀번호를 입력하세요.");
		}else {
			$("#pwForm").submit();	
		}
		
	}
	

</script>
</body>
</html>