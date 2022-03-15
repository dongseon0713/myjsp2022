<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
</head>
<body>
<%@ include file="../include/header.jsp" %>

  <section id="contentwrap">
    <form role="form" action="register" method="post" id="regform" accept-charset="UTF-8" enctype="multipart/form-data">
            <div id="content_top" class="top_padding">
           
             
                       
                        <label for="chooseFile" style="font-size: 20px; font-weight:700">
                            사진 업로드
                        </label>
						<br>
                        <input type="file" id="gdsImg" name="file" />
                        
                        <div class="select_img"><img src="" /></div>
                        <div class="invisible">
                        <script src="http://code.jquery.com/jquery-latest.js"></script> 
                        <script>
                        	$("#gdsImg").change(function(){
                        		if(this.files && this.files[0]) {
                        			var reader = new FileReader;
                        			reader.onload = function(data){
                        				$(".select_img img").attr("src", data.target.result).width(500);
                        			}
                        			reader.readAsDataURL(this.files[0]);
                        		}
                        	})
                        </script>
                        <%-- 서버에 업로드하여 실행된다면 새로운 경로를 확인하여 서블릿 콘텍스트에 다시 적용해야한다. --%>
                        	<%=request.getRealPath("/") %>
                        </div>
                        </div>
                  



            <div id="content_bottom">

                <table id="content_table" class="trans-l-70" width="70%"
					style="text-align: center; font-size: 15px;">
					<tr>

						<td style="width: 25%">작성자</td>
						<td colspan="3"><input type="text" name="writer" id="writer"
							readonly
							style="border: none; background-color: #ffffff; height: 45px; width: 100%"
							value="${sessionScope.user_id }"></td>

						<!--    <td>글번호</td>
                       <td>
                       <input type="text" name="num"  readonly style="border: none; background-color: #ffffff; height: 45px; width: 100%">
                       </td>
                     -->
					</tr>

					<tr>
						<td>제목</td>
						<td colspan="3"><input type="text" name="title" id="title"
							style="border: none; background-color: #ffffff; height: 45px; width: 100%">
						</td>
					</tr>

					<tr>
						<td>가게명</td>
						<td colspan="3"><input type="text" name="name" id="name"
							style="border: none; background-color: #ffffff; height: 45px; width: 100%">
						</td>
					</tr>

					<tr>
						<td>주소</td>
						<td>
									<select name="city_b" id="city_b" style="width: 100%; height: 45px; text-align: center;">
										<option value="metropolitanCity">특별,광역시</option>
										<option value="gyeonggi">경기</option>
										<option value="gyeongbuk">경북</option>
										<option value="gyeongnam">경남</option>
										<option value="jeonbuk">전북</option>
										<option value="jeonnam">전남</option>
										<option value="gangwon">강원</option>
										<option value="chungbuk">충북</option>
										<option value="chungnam">충남</option>
									</select>
								
						</td>

						<td colspan="2"><input type="text" name="address"
							id="address"
							style="border: none; background-color: #ffffff; height: 45px; width: 95%">
						</td>
					</tr>
					<tr>
						<td>주차장</td>
						<td width=25%><input type="radio" id="Y" name="carpark"
							value="Y" checked> <label for="y">있음</label></td>
						<td width=25%><input type="radio" id="N" name="carpark"
							value="N"> <label for="n">없음</label></td>
						<td width=25%><input type="radio" id="U" name="carpark"
							value="U"> <label for="u">모름</label></td>
					</tr>
					<tr>
						<td>영업시간</td>
						<td><input type="number" min="0" max="24" step="1"
							name="open" id="open"
							style="border: none; background-color: #ffffff; height: 45px; width: 100%;"></td>
						<td>-</td>
						<td><input type="number" min="0" max="24" step="1"
							name="close" id="close"
							style="border: none; background-color: #ffffff; height: 45px; width: 100%"></td>
					</tr>
					<tr>
						<td>브레이크 타임</td>
						<td colspan="3"><input type="number" min="0" max="24"
							step="1" name="breaktime" id="breaktime"
							style="border: none; background-color: #ffffff; height: 45px; width: 100%"></td>
					</tr>
					<tr>
						<td>라스트 오더</td>
						<td colspan="3"><input type="number" min="0" max="24"
							step="1" name="lastorder" id="lastorder"
							style="border: none; background-color: #ffffff; height: 45px; width: 100%">
						</td>
					</tr>
					<tr>
						<td>휴일</td>
						<td colspan="3"><input type="text" name="holiday"
							id="holiday"
							style="border: none; background-color: #ffffff; height: 45px; width: 100%">
						</td>
					</tr>
					<tr>

					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3"><textarea name="content" id="content"
								cols="70" rows="20" style="padding: 10px; text-align: center;"></textarea>
						</td>
					</tr>

				</table>

				<div class="btn_area double" style="margin-top: 20px;">
					<div id="btnCancel" onclick="history.go(-1)">
						<a href="" role="button">취소</a>
					</div>
					<div>
						<input id="btnSubmit" type="button" value="확인"
							onclick="registerCheck()">
					</div>
				</div>
 		</div>
            </form>
           

        </section>


<%@ include file="../include/footer.jsp" %>

<script>
  function registerCheck() {
	  if ($("#title").val().length < 1) {
		  alert("제목을 입력하세요.");
	  } else if ($("#name").val().length < 1) {
		  alert("가게명을 입력하세요.");
	  } else if ($("#city_b").val() == '도시 선택') {
		  alert("도시를 선택하세요.");
	  } else if ($("#address").val().length < 1) {
		  alert("주소를 입력하세요.");
	  } else if ($("#open").val().length < 1) {
		  alert("오픈시간을 입력하세요."); 
	  } else if ($("#open").val() < 0 || $("#open").val() > 24) {
		  alert("0과 24 사이의 숫자를 입력해주세요."); 
	  } else if ($("#close").val().length < 1) {
		  alert("영업종료 시간을 입력하세요."); 
	  } else if ($("#open").val() > $("#close").val()){
		  alert("영업 종료시간을 확인해주세요."); 
      } else if ($("#close").val() < 0 || $("#close").val() > 24) {
		  alert("0과 24 사이의 숫자를 입력해주세요."); 
	  } else if ($("#breaktime").val().length < 1) {
		  alert("브레이크 타임을 입력해주세요."); 
	  } else if ($("#breaktime").val() < 0 || $("#breaktime").val() > 24) {
		  alert("0과 24 사이의 숫자를 입력해주세요."); 
	  } else if ($("#lastorder").val().length < 1) {
		  alert("라스트오더를 입력해주세요."); 
	  } else if ($("#lastorder").val() < 0 || $("#lastorder").val() > 24) {
		  alert("0과 24 사이의 숫자를 입력해주세요."); 
	  } else if ($("#holiday").val().length < 1) {
		  alert("주소를 입력하세요.");
	  } else if ($("#content").val().length < 1) {
		  alert("내용을 입력하세요.");
	  } else if (confirm("글을 등록하시겠습니까?")) {
		  $("#regform").submit();
	  }
  }
</script>

<script src="http://code.jquery.com/jquery-latest.js"></script> 
</body>
</html>