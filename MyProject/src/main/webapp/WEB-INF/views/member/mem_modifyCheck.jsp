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
            <div class="margin_bottom" id="logo">
                    <a href="/">
                        <img src="../resources/img/logo.png" alt="메인로고" style="height:220px">
                    </a>
             </div>
     <div class="t-margin-70">
             <h2 style="margin-bottom: 20px ">비밀번호 확인</h2>
       
            <form action="pwCheckForm" id="pwCheckForm" method="post">
			
                   <table id="regist_table" width="40%" style="text-align: center; font-size: 20px; margin-bottom: 30px; ">
                    
                 	<tr>
                       <td style="width:30%;  height:50px" >비밀번호</td>
                       <td  colspan="2"><input type="password" name="pw" id="pw" style="border: none; background-color: #ffffff; height: 40px; width: 100%">
                    </tr>
                </table>
                
                
                
                <div class="btn_area double">
                	<div id="btnCancel">
                		<a href="/" role="button">취소</a>
                	</div>
                	<div>
                		<input id="btnSubmit" type="button" value="확인"
								onclick="pwCheck()">
                	</div>
                </div>
                <div class="find_3">
	                <ul>
	                	<li>
	                		<a href="/member/mem_findPw" class="find_text">비밀번호 찾기</a>
	                	</li>
	                </ul>
				</div>
            </form>
            </div>
            </div>

 </section>
<%@ include file="../include/footer.jsp" %>

<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
	  	var msg = '${msg }';
	  	
	  		if(msg != ''){
	  		alert(msg);
	  		}
	  	});
	function pwCheck() {
		if($("#pw").val().length < 1){
			alert("비밀번호를 입력해 주세요.");
		}else if(true){
			$("#pwCheckForm").submit();
		}
		
		
	}
</script>
</body>
</html>