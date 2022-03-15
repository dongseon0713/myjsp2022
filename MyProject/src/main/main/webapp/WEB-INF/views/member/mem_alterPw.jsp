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
            
            
             <h2 style="margin-bottom: 20px ">비밀번호 변경</h2>
            <form action="updatePwForm" id="updatePwForm" method="post">
            
            	<table id="regist_table" width="40%" style="text-align: center; font-size: 20px; margin-bottom: 30px; ">
	            	<tr>
	                   <td style="width:30%;  height:50px" >비밀번호</td>
	                   <td  colspan="2"><input type="password" name="pw" id="pw" style="border: none; background-color: #ffffff; height: 40px; width: 100%; text-align: center;">
	                </tr>
	                    
	                <tr>
	                   <td style="width:30%;  height:50px" >비밀번호 확인</td>
	                   <td  colspan="3"><input type="password" name="pwCheck"  id="pwCheck"style="border: none; background-color: #ffffff; height: 40px; width: 100%; text-align: center;">
	                </tr>
                </table>
                
               
              <div class="btn_area double" style="margin-top: 0px;">
                	<div id="btnCancel" onclick="history.go(-1)">
                		<a href="#" role="button">취소</a>
                	</div>
                	<div>
                		<input id="btnSubmit" type="button" value="확인" onclick="updatePwCheck()">
                	</div>
                </div>
            </form>
            </div>
        </div>
    </section>
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript">
    	function updatePwCheck(){
    		if($("#pw").val().length < 1){
    			alert("비밀번호를 입력해주세요.");
    		}else if($("#pw").val() != $("#pwCheck").val()){
    			alert("비밀번호 확인란을 확인해주세요.");
    		}else if(true){
    			$("#updatePwForm").submit();
    		}
    	}
    </script>
<%@ include file="../include/footer.jsp" %>
</body>
</html>