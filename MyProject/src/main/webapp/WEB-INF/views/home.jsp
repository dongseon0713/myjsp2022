<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page session="false" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

<%@include file="include/header.jsp"%>
<script type="text/javascript">
expireDate = new Date
expireDate.setMonth(expireDate.getMonth()+3)
hitCt = eval(cookieVal("pageHit"))
hitCt++
document.cookie = "pageHit=" + hitCt + ";expires=" + expireDate.toGMTString()
function cookieVal(cookieName){
	thisCookie = document.cookie.split("; ")
	for(i=0; i < thisCookie.length; i++){
		if(cookieName == thisCookie[i].split("=")[0]){
			return thisCookie[i].split("=")[1]
	}
}
return 0
}
</script>
 <section id="contentwrap">

            <div id="content_top" class="top_padding">
                <div id="logo">
                    <a href="">
                        <img src="resources/img/logo.png" alt="메인로고" style="height:220px">
                    </a>
                </div>
                <div id="search">
                    <i class="fas fa-search"></i>
                    <input id="search_text" type="text" name="search" placeholder="        지역,식당 또는 음식">
                     <input class="w-btn w-btn-yellow" type="button" value="검색" onclick="">
                </div>

                <div id="search_opt">
                    <select id="select">
                        <option>도시</option>
                        <option value="##">도시1</option>
                        <option value="##">도시2</option>
                        <option value="##">도시3</option>
                        <option value="##">도시4</option>
                        <option value="##">도시5</option>

                    </select>
                </div>

            </div>


            <div id="content_bottom">
                <h2 style="text-align: left">지역별 맛집</h2>

                <div id="do">



                    <table width="100%" height="660px">
					<tr>
						<td><a href="board/list?city=seoul"> <img src="resources/img/tb_temp.jpg"
								alt="특별,광역시"> <span id="img_text">특별시<br> 광역시
							</span>
						</a></td>

						<td><a href="board/list?city=gyeonggi"> <img src="resources/img/kk_temp.jpg"
								alt="경기"> <span id="img_text2">경기도</span>
						</a></td>

						<td><a href="board/list?city=gangwon"> <img src="resources/img/kw_temp.jfif"
								alt="강원"> <span id="img_text2">강원도</span>
						</a></td>
					</tr>
					<tr>
						<td><a href="board/list?city=chungnam"> <img src="resources/img/cn_temp.jfif"
								alt="충남"> <span id="img_text">충청<br>남도
							</span>
						</a></td>

						<td><a href="board/list?city=chungbuk"> <img src="resources/img/cb_temp.jfif"
								alt="충북"> <span id="img_text">충청<br>북도
							</span>
						</a></td>

						<td><a href="board/list?city=gyeongbuk"> <img src="resources/img/kb_temp.jpg"
								alt="경북"> <span id="img_text">경상<br>북도
							</span>
						</a></td>
					</tr>
					<tr>
						<td><a href="board/list?city=jeonnam"> <img src="resources/img/jn_temp.jpg"
								alt="전남"> <span id="img_text">전라<br>남도
							</span>
						</a></td>

						<td><a href="board/list?city=jeonbuk"> <img src="resources/img/jb_temp.jpg"
								alt="전북"> <span id="img_text">전라<br>북도
							</span>
						</a></td>

						<td><a href="board/list?city=gyeongnam"> <img src="resources/img/kn_temp.jpg"
								alt="경남"> <span id="img_text">경상<br>남도
							</span>
						</a></td>
					</tr>


				</table>




                </div>



                <div id="side">

                     <div id="login" onclick="location.href='member/login'">
                        <a id="main_login"href="/member/login">로그인</a>
                    </div>
                  <div id="clock">
					<div id="time" class="time"></div>
					<div id="date" class="date"></div>
				</div>
                    <div id="counter">
                        	<script type="text/javascript">
                        	document.write("현재 홈페이지에 <font color=blue>" + hitCt + "</font> 번째  방문자입니다.")
                        	</script>
                    </div>

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
		function setClock() {
			var dateInfo = new Date();
			var hour = modifyNumber(dateInfo.getHours());
			var min = modifyNumber(dateInfo.getMinutes());
			var sec = modifyNumber(dateInfo.getSeconds());
			var year = dateInfo.getFullYear();
			var month = dateInfo.getMonth() + 1;
			var date = dateInfo.getDate();
			document.getElementById("time").innerHTML = hour + ":" + min + ":"
					+ sec;
			document.getElementById("date").innerHTML = year + "년 " + month
					+ "월 " + date + "일";
		}
		function modifyNumber(time) {
			if (parseInt(time) < 10) {
				return "0" + time;
			} else
				return time;
		}
		window.onload = function() {
			setClock();
			setInterval(setClock, 1000);
		}
		
		
	</script>

<%@ include file="include/footer.jsp"%>
</body>
</html>
