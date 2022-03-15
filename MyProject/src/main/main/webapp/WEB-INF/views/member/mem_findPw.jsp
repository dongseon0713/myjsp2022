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
<%-- 보안 마우스 드래그 방지 --%>
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
			<h2 style="margin-bottom: 20px">비밀번호 찾기</h2>
			
			<form action="findPwForm" id="findPwForm" method="post">

				<table id="regist_table" width="40%" style= "font-size: 15px; text-align: center;">
					<tr>
						<td style="width: 25%; height: 50px">아이디</td>
						<td colspan="4"><input type="text" name="id" id="id"
							style="border: none; background-color: #ffffff; height: 40px; width: 100%; text-align: center;">
                        </td>
					</tr>
					
					<tr>
                       <td style="height:50px"> 이메일</td>
                       <td  colspan="1"><input type="email" name="email" id="email"style="border: none; background-color: #ffffff; height: 40px; width: 80%; text-align: center;">
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
                		<input id="btnSubmit" type="button" value="확인" onclick="findPwCheck()">
                	</div>
                </div>
			</form>
		</div>
        </div>
	</section>
	
	<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js">
	</script>
	<script type="text/javascript">

		$(document).ready(function(){
		  	var msg = '${msg }';
		  	
		  		if(msg != ''){
		  		alert(msg);
		  		}
		  	});

		function findPwCheck(){
		
			if($("#id").val().length < 1){
	   				alert("아이디를 입력하세요.");
			}else if( $("#email").val().length < 1) {
   				alert("이메일을 입력해주세요.");
   			}else if( $("#emailAd").val() == '') {
   				alert("이메일을 선택해주세요.")
   			}else if($("#code").val() != '<%=arr[1]%>'){
				alert("인증 문자를 다시 확인해주세요.");
			}else if(true){
				$("#findPwForm").submit();	
			}
		}
	</script>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>