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

<section id="contentwrap">
           
            <div id="content_bottom" class="top_padding">
            
            <div id="logo">
                    <a href="/">
                        <img src="../resources/img/logo.png" alt="메인로고" style="height:220px">
                    </a>
                </div>
             <div class="t-margin-70">
             <h2 style="margin-bottom: 20px ">회원정보 수정</h2>
             
            <form action="modifyForm" method="post">

               <table id="regist_table" width="50%" style= "font-size: 15px; text-align: center;">
                   <tr>
                      <td style="width:20%;  height:50px" >아이디</td>
                         <td colspan="4"><input type="text" name="id" id="id" style="border: none; background-color: #ffffff; height: 40px; width: 100%; text-align: center;" value="${vo.id }" readonly>
                       </td>
                       
                    </tr>
                  
                     <tr>
                       <td style="height:50px" >이름</td>
                       <td  colspan="4"><input type="text" name="name"  id="name"style="border: none; background-color: #ffffff; height: 40px; width: 100%; text-align: center;" value="${vo.name }">
                    </tr>
                    
                     <tr>
                   		<td style="height:50px" >전화번호</td>
                   		<td width="20%";>
                   			<select name="phone" style="height: 40px; width: 90%; text-align: center; border: none;">
                   				<option value="010">010</option>
                   				<option value="011">011</option>
                   				<option value="017">017</option> 
                   			</select>
                   		</td>
                        <td colspan="2" width="20%"><input type="text" name="phone1"  id="phone1" style="border: none; background-color: #ffffff; height: 40px; width: 90%; text-align: center;" value="${vo.phone1 }"></td>
                        <td width="20%"><input type="text" name="phone2"  id="phone2" style="border: none; background-color: #ffffff; height: 40px; width: 90%; text-align: center;" value="${vo.phone2 }"></td>
                    </tr>
                    
                     <tr>
                       <td style="height:50px" >닉네임</td>
                       <td  colspan="4"><input type="text" name="nickname"  id="nickname"style="border: none; background-color: #ffffff; height: 40px; width: 100%; text-align: center;"value="${vo.nickname }">
                        </td>
                        <td>
							<input type="button" class="btn_check" value="중복체크"
								onclick="NickCheck()">
						</td>
                    </tr>
                    <tr>
                        <td style="height:50px">성별</td>
                        <td style="text-align: center">
                        <input type="radio" id="male" name="gender"
								value="남" checked>
                            <label for="male">남성</label>
                        
							<td style="text-align: center">
                       <input type="radio" id="female" name="gender"
								value="여">
                            <label for="female">여성</label>
                        </td>
                    </tr>
                   <tr>
                       <td style="height:50px"> 주소</td>
                       <td  colspan="4"><input type="text" name="address" id="address" style="border: none; background-color: #ffffff; height: 40px; width: 100%; text-align: center;" value="${vo.address }">
                       </td>
                    </tr>
                    <tr>
                       <td style="height:50px"> 이메일</td>
                       <td  colspan="1"><input type="email" name="email" id="email"style="border: none; background-color: #ffffff; height: 40px; width: 80%">
                        </td>
                       <td colspan="3" style="width: 70%; ">
                    		<select name="emailAd" id="emailAd" style="width: 80%; height: 40px;">
                    			<option value="">이메일 선택</option>
                   				<option value="@naver.com">@naver.com</option>
                   				<option value="@nate.com">@nate.com</option>
                   				<option value="@gmail.com">@gamil.com</option>
                   				<option value="@daum.net">@daum.net</option>
                   			</select>
                    	</td>
                    </tr>
                    <tr>
                    	<td style="height:50px"> 본인 확인 질문</td>
                    	<td colspan="4">
                    		<select name="question" id="question" style="height: 40px; width: 100%; text-align: center; border: none;">
                    			<option value="">새로운 질문 선택</option>
                   				<option value="1">처음으로 샀던 자동차는 ?</option>
                   				<option value="2">고등학교 시절 살았던 동네는?</option>
                   				<option value="3">첫 해외여행 장소는?</option>
                   				<option value="4">처음으로 플레이한 게임은?</option>
                   				<option value="5">가장 좋아하는 스포츠 팀이나 선수 이름은?</option>  
                   			</select>
                    	</td>
                    </tr>
                   <tr>
                    		<td style=" height:50px"> 본인 확인 답변</td>
                    		<td colspan="4"><input type="text" name="answer" id="answer" placeholder="본인 확인 답변 입력"style="border: none; background-color: #ffffff; height: 40px; width: 100%; text-align: center;"></td>
                    </tr>
                    

                </table>
                
                <div class="btn_area double">
                	<div id="btnCancel" onclick="history.go(-1)">
                		<a href="#" role="button">취소</a>
                	</div>
                	<div>
                		<input id="btnSubmit" type="button" value="확인" onclick="joinCheck()">
                	</div>
                </div>
                

            </form>

                </div>
            </div>


        </section>



<%@ include file="../include/footer.jsp" %>
<script
									src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

								<script type="text/javascript">
								$(document).ready(function(){
								  	var msg = '${msg }';
								  	
								  		if(msg != ''){
								  		alert(msg);
								  		}
								  	});
								
									//닉네임 중복 체크
									function NickCheck() {
										var nickname = $('#nickname').val(); //nickname태그 value에 접근
										var user_Nick = {
											"nickname" : nickname
										}; //전송할 데이터의 key값

										if (nickname.length < 2) {
											alert("닉네임는 2글자 이상이여야 합니다.");
										} else {
											//먼저 ajax를 지원하는 json을 사용하기 위해 라이브러리 필요
											//json은 {키 : 값}을 구조를 가지고 있는 데이터 묶음
											//ajax문법
											$
													.ajax({
														type : "post", //요청 형식
														url : "checkNname", //요청 주소
														data : user_Nick, //서버에 전송할 데이터 json형식
														//dataType : "json",//서버에 요청 후 리턴해 주는 타입
														error : function(
																request, error) {
															alert(error
																	+ "\n"
																	+ request.status);
														},
														success : function(
																result) {
															//ajax통신에 성공했을 때 호출될 자바 스크립트 함수,
															//결과 여부가 result매개 변수로 전달됨.
															console
																	.log("성공 실패 여부 : "
																			+ result);

															if (result == 1) { //중복되는 닉네임이 존재함.
																alert("이미 존재하는 닉네임 입니다.");
															} else {
																alert("사용가능한 닉네임 입니다.");
																if(confirm("닉네임을 확정지으시겠습니까?")){
																	$("#nickname")
																	.attr(
																			"readonly",
																			true);
																}
															}
														}
													}) //$.ajax 동작 부분
										} //else 종료 부분
									}
									
									function modifyCheck(){
										if($("#name").val().length < 1){
											alert("이름을 입력해주세요.");
										}else if ($("#phone1").val() == ""
												|| $("#phone1").val().length != 4) {
											alert("폰 번호(앞자리)는 4자리수로만 입력하세요.");
										} else if (isNaN($("#phone1").val())) {
											alert("휴대폰 번호를 숫자로만 입력해 주세요.")
										} else if ($("#phone2").val() == ""
												|| $("#phone2").val().length != 4) {
											alert("폰 번호(뒷자리)는 4자리수로만 입력하세요.");
										} else if (isNaN($("#phone1").val())) {
											alert("휴대폰 번호를 숫자로만 입력해 주세요.");
										} else if($("#address").val().length < 1){
											alert("주소를 입력해주세요.");
										} else if($("#email").val().length < 1){
											alert("이메일을 입력해주세요.");
										} else if($("#emailAd").val() == ''){
											alert("이메일을 선택해주세요.");
										} else if ($("#question").val() == '') {
											alert("본인 확인 질문을 선택 해주세요.");
											return false;
										} else if ($("#answer").val().length < 1) {
											alert("본인 확인 답변을 입력해주세요.");
										} else if (confirm("수정 하시겠습니까?")) {
											$("#modifyForm").submit();
										}
									}
									</script>
</body>
</html>