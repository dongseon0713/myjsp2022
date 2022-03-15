<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//네트워크 상에서 고유성이 보장되는 id를 만들기 위한 표준 규약
UUID uuid = UUID.randomUUID();

//uuid를 문자열로 변환 후 uid로 대입
String uid = uuid.toString();

//하나의 배열로 만들기
String[] arr = uid.split("-");
//System.out.println(Arrays.toString(arr)); 배열을 주소가 아닌 값으로 표현할때는 Arrays이용
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- 보안 마우스 드레그 방지 --%>
<script type="text/javascript">
	document.onselectstart = function(){return false;}
</script>
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
			<h2 style="margin-bottom: 20px">아이디 찾기</h2>

			<form action="mem_idResult" id="findIdForm" method="post">

				 <table id="regist_table" width="50%" style= "font-size: 15px; text-align: center;">
					 <tr>
                       <td style="width:25%;  height:50px" >이름</td>
                       
                       <td  colspan="4"><input type="text" name="name"  id="name" style="border: none; background-color: #ffffff; height: 40px; width: 100%; text-align: center;">
                        </td>
                    </tr>
                    
					  <tr>
                   		<td style="height:50px" >전화번호</td>
                   		
                   		<td width=25%>
                   			<select name="phone" style="height: 40px; width: 90%; text-align: center; border: none;">
                   				<option value="010">010</option>
                   				<option value="011">011</option>
                   				<option value="017">017</option> 
                   			</select>
                   		</td>
                       
                        <td width=25% colspan="2"><input type="text" name="phone1"  id="phone1" style="border: none; background-color: #ffffff; height: 40px; width: 90%; text-align: center;"></td>
                        
                        <td width=25%><input type="text" name="phone2"  id="phone2" style="border: none; background-color: #ffffff; height: 40px; width: 90%; text-align: center;"></td>
                        
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
					
	                    	<td style="height:50px"> 본인 확인 답변</td>
	                    <td colspan="4"><input type="text" name="answer" id="answer" placeholder="본인 확인 답변 입력"style="border: none; background-color: #ffffff; height: 40px; width: 100%; text-align: center;"></td>
                    </tr>
					<tr>
						<td style="height: 50px">인증문자</td>
						<td colspan="4" style="border: none; background-color: #8e8e8e; height: 0px; width: 100%; font-size:20px;"><del><%=arr[1]%></del></td>
					</tr>
					<tr>
						<td style="height: 50px">인증문자 확인</td>
						<td colspan="4"><input type="text" name="code"id="code"style="border: none; background-color: #ffffff; height: 40px; width: 100%; text-align: center;"></td>
					</tr>
				</table>

			

				 <div class="btn_area double">
                	<div id="btnCancel" onclick="history.go(-1)">
                		<a href="#" role="button">취소</a>
                	</div>
                	<div>
                		<input id="btnSubmit" type="button" value="확인" onclick="findIdCheck()">
                	</div>
                </div>

			</form>
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
		
		function findIdCheck(){
			 if( $("#name").val().length < 1){
	   				alert("이름을 입력하세요.");
	   		}else if( $("#phone1").val() == "" || $("#phone1").val().length != 4){
   				alert("폰 번호(앞자리)는 4자리수로만 입력하세요.");
   			}else if(isNaN($("#phone1").val())) {
   				alert("휴대폰 번호를 숫자로만 입력해 주세요.")
   			}else if( $("#phone2").val() == "" || $("#phone2").val().length != 4){
   				alert("폰 번호(뒷자리)는 4자리수로만 입력하세요.");
   			}else if(isNaN($("#phone1").val())) {
   				alert("휴대폰 번호를 숫자로만 입력해 주세요.")
   			}else if($("#question").val() == ''){
				alert("본인 확인 질문을 선택해주세요.");
			}else if($("#answer").val().length < 1){
				alert("본인 확인 답변을 입력해주세요.");
			}else if($("#code").val() != '<%=arr[1]%>'){
				alert("인증 문자를 다시 확인해주세요.");
			}else if(true){
				$("#findIdForm").submit();
			}
		}
	</script>
	<%@ include file="../include/footer.jsp" %>
	
</body>
</html>