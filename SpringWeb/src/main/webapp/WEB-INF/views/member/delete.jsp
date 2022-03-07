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
                <h1 class="h4 text-gray-900 mb-4">회원 탈퇴</h1>
              </div>
              
              
              <!-- 자바스크립트(제이쿼리) 를 사용하기전에 input 태그의 id속성을 확인하세요. -->
              <form class="user" action="deleteForm" method="post" id="deleteForm">
                <!-- 아이디 -->
                <div class="form-group row">
                  <div class="col-sm-8 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" placeholder="아이디" name="id" id="id">
                  </div>
				</div>
                <!-- 비밀번호 -->
                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" placeholder="비밀번호" name="pw" id="pw">
                  </div>
                </div>
                
                <!-- 비밀번호 확인 -->
                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" placeholder="비밀번호체크" id="pwCheck">
                  </div>
                </div>
				
				<input type="button" class="btn btn-primary btn-user btn-user btn-block" value="회원탈퇴" onclick="deleteCheck()">
               
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
  <script type="text/javascript">
  
  $(document).ready(function(){
	  	var msg = '${msg }';
	  	
	  		if(msg != ''){
	  		alert(msg);
	  		}
	  	});
  
  function deleteCheck(){
   			//attr(속성, 변경할 값) 함수는 해당 ID태그의 내부 속성을 변경
   			//attr(속성) 함수의 매개값이 하나라면 해당 속성여부를 확인
   			//val() 함수는 해당 ID태그의 값을 확인
   			//focus() 함수는 해당 ID태그의 마우스 커서를 위치시킨다.
   			//submit() 함수는 해당 ID태그의 form 을 서밋처리
   			if($("#id").val().length < 1){
   				alert("아이디를 입력하세요.");
   			}else if( $("#pw").val().length < 1){
   				alert("비밀번호를 입력하세요.");
   			}else if( $("#pw").val() != $("#pwCheck").val()){
   				alert("비밀번호 확인란을 확인해주세요.");
   				$("#pwCheck").focus();
   			}else if(confirm("회원 탈퇴 하시겠습니까?")){
   				$("#deleteForm").submit();
   			}
   			
   		}
  </script>
<%@ include file="../include/footer.jsp" %>
</body>
</html>