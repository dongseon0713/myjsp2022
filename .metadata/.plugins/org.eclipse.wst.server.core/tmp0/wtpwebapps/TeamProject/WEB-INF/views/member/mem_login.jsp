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
             <br>
             <br>
             <br>
             <h2>로그인</h2>
       
            <form action="loginForm" method="post">
			
                <table id="regist_table" width="40%" style="text-align: left; font-size: 12px; background-color: ">
                   <tr>
                       <td style="width:30%;  height:50px" >아이디</td>
                       <td colspan="2"><input type="text" name="id" style="border: none; background-color: #ffffff; height: 40px; width: 100%">
                    </tr>
                    
                        <tr>
                       <td style="width:30%;  height:50px" >비밀번호</td>
                       <td  colspan="2"><input type="password" name="pw" style="border: none; background-color: #ffffff; height: 40px; width: 100%">
                    </tr>
                </table>
                
                <br>
                
                <div>
                    <button type="submit" class="btn_login" id="log.login"><span class="btn_text">로그인</span></button>        
                </div>
                <div class="find">
	                <ul class="find_wrap" id="find_wrap">
	                	<li>
	                		<a href="" class="find_text">비밀번호 찾기</a>
	                	</li>
	                	<li>
	                		<a href="/member/mem_findId" class="find_text">아이디 찾기</a>
	                	</li>
	                	<li>
	                		<a href="join" class="find_text">회원가입</a>
	                	</li>
	                </ul>
				</div>
            </form>
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
</script>
<%@ include file="../include/footer.jsp" %>
</body>
</html>