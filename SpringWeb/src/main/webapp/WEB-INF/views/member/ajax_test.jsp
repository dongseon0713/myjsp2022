<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="apple" value="홍길자">
	<input type="text" id="melon" value="홍길숙">
	<input type="text" id="grape" value="홍길동">
	
	<button onclick="check()">확인</button>
	
	<script type="text/javascript" src="//code.jquery.com/jquery-3.4.0.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			alert("화면 접속시 바로 실행하는 기능 구현");
			
			var msg = '${msg}';
			
			if(msg != ''){
				alert(msg)
			}
			
		});
		
		function check(){
			
			$.ajax({
				type : "post",
				url : "checkId",
				data : {
					"id" : "test"
				},
				success : function(result) {
					alert("비동기 성공!");
				}
			})
			
			
			/* $("#apple").attr("type","password");
			$("#grape").attr("type","password");
			var a = $("#melon").val();
			$("#melon").focus();
			alert(a);  */
			
			
			
			//val()
			//attr(속성, 값)
			//attr(속성)
			//removeattr(속성)
			//focus()

	}
	</script>
</body>
</html>