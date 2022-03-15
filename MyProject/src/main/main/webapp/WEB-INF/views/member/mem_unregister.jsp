<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "../include/header.jsp" %>
<section id="contentwrap">
           <div id="content_bottom" class="top_padding">
			<div id="logo">
				<a href="/"> <img src="../resources/img/logo.png" alt="메인로고"
					style="height: 220px">
				</a>
			</div>
			</div>
           
           <div class="t-margin-70">
            
             <h2 style="margin-bottom: 20px ">회원 탈퇴</h2>
             
            <form action="unregister" id="unregister" method="post">

               <table id="regist_table" class="trans-l-70" width="680px" style= "font-size: 15px; text-align: center;">
						<tr>
							<td style="width:25%; height:50px" >탈퇴 이유</td>
							<td>
								<select id="reason" name="reason" style="height: 40px; width: 100%; text-align: center; border: none;">
									<option value="">이유를 선택 해주세요.</option>
									<option value="1">도움이 되지 않아요.</option>
									<option value="2">이용하지 않아요.</option>
									<option value="3">사용이 불편해요.</option>
									<option value="4">복잡해요.</option>
									<option value="5">기타</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>상세 이유</td>
							<td>
								<textarea rows="30" cols="70" id="cause" name="cause" style="border: none; text-align: center; padding: 20px 0;"></textarea>
							</td>
						</tr>
				</table>
				<br>
				<div class="btn_area double">
                	<div id="btnCancel" onclick="history.go(-1)">
                		<a href="#" role="button">취소</a>
                	</div>
                	<div>
                		<input id="btnSubmit" type="button" value="확인" onclick="unregister()">
                	</div>
                </div>
			</form>
    </div>
</section>
<%@ include file = "../include/footer.jsp" %>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript">
	function unregister() {
		if($("#reason").val() == ""){
			alert("사유를 선택해주세요.");
		}else if(confirm("회원 탈퇴 하시겠습니까?")){
			$("#unregister").submit();
		}
	}
</script>

</body>
</html>