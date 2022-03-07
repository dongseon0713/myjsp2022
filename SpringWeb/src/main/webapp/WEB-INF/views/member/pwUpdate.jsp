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
                <h1 class="h4 text-gray-900 mb-4">비밀번호 변경</h1>
              </div>
              
              
              <!-- 자바스크립트(제이쿼리) 를 사용하기전에 input 태그의 id속성을 확인하세요. -->
              <form class="user" action="pwUdateForm" method="post" id="pwUpdateForm">
         
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
				
				<input type="button" class="btn btn-primary btn-user btn-user btn-block" value="비밀번호 변경" onclick="passwordCheck()">
               
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
	function passwordCheck(){
		var pw = $('#pw').val();
		var user_pw = {"pw" : pw};
		
		if(pw.length < 4){
			alert("비밀번호는 4글자 이상이여야 합니다.");
		}else if( $("#pw").val() != $("#pwCheck").val()){
   				alert("비밀번호 확인란을 확인해주세요.");
   				$("#pwCheck").focus();
		}else {
			$.ajax({
				type :"post",
				url : "updatePw",
				data : user_pw,
				error : function(request, error){
						alert(error + "\n" + request.status);
					},
					success : function(result){ 
							//ajax통신에 성공했을 때 호출될 자바 스크립트 함수,
							//결과 여부가 result매개 변수로 전달됨.
							console.log("성공 실패 여부 : " + result);
							
							if(result == 1) {	//중복되는 아이디가 존재함.
								alert("변경되었습니다.");
								location.href="/member/mypage";
							}else{
								alert("변경에 실패했습니다.");
							}
					}
				}) 	//$.ajax 동작 부분
			}	//else 종료 부분
	}
</script>
</body>
</html>