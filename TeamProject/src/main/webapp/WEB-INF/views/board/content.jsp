<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
</head>
<body>
	<%@ include file="../include/header.jsp"%>

	<section id="contentwrap">

		


		<div id="content_bottom" class="top_padding">

				<div id="content_middle">

			<table width="50%" style="text-align: left;">

				<tr style="height: 100px;">
					<th colspan="4" style="font-size: 36px;">${ content.title }</th>
				</tr>

				<tr style="height: 20px; font-size: 15px; text-align:center;">

					<td style="width: 33%;">${ content.writer }</td>
					<td style="width: 33%;"><i class="fa-solid fa-eye"></i>&nbsp;${ content.hit }</td>
					<td style="width: 33%;"><fmt:formatDate
								value="${content.regdate}" pattern="yyyy-MM-dd HH:mm" /></td>
					

				</tr>
				
			
			</table>
			
		<div id="content_line">
			<table id="content_table"  width="100%"
				style="text-align: center; font-size: 20px;">

				<tr>
					<td style="width: 20%">가게명</td>
					<td colspan="3">${ content.name }</td>
					<c:choose>
						<c:when test="${content.gdsThumbImg != null}">
							<td rowspan="7"><img src="${content.gdsThumbImg }" alt="썸네일"></td>
						</c:when>
						<c:otherwise>
							<td rowspan="7">이미지<br>없음</td>
						</c:otherwise>
					</c:choose>
					
				</tr>
				<tr>
					<td>주소</td>
					<td colspan="3">${ content.address }</td>
				</tr>
				<tr>
					<td>주차장</td>
					<c:choose>
						<c:when test="${ content.carpark eq 'y'}">
						<td colspan="3">있음</td>
						</c:when>
						<c:when test="${ content.carpark eq 'n'}">
						<td colspan="3">없음</td>
						</c:when>
						<c:otherwise>
						<td colspan="3">확인 안됨</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td>영업시간</td>
					<td>${ content.open }</td>
					<td>-</td>
					<td>${ content.close }</td>
				</tr>
				<tr>
					<td>브레이크 타임</td>
					<td colspan="3">${ content.breaktime }</td>
				</tr>
				<tr>
					<td>라스트 오더</td>
					<td colspan="3">${ content.lastorder }</td>
				</tr>
				<tr>
					<td>휴일</td>
					<td colspan="3">${ content.holiday }</td>
				</tr>
				<tr>
					<td colspan="5" height="200px"
						style="max-width: 100px; word-wrap: break-word">
						${ content.content }
						
					</td>
				</tr>

			</table>
			
			</div>
			
		    <div class="btn_area double">
				<button id="btnCancel" type="button"
					onclick="history.back()">목록</button>
				<button id="btnSubmit" type="button"
					onclick="location.href='modify?num=${content.num}'">수정</button>
			</div>
			
			</div>


			
            <div id="review_wrap">
			<h3 style="text-align: left">댓글</h3>
		
			<table id="review_table" width="100%">
				<tr height="50px;">
					<td width="5%"><strong>번호</strong></td>
					<td width="10%"><strong>작성자 이름</strong></td>
					<td><strong>내용</strong></td>
					<td width="20%"><strong>작성일</strong></td>
					<td width="10%"></td>
				</tr>
				
			<c:forEach var="good" items="${ comment }" varStatus="num">
			    
				<tr height="50px;">
					<td width="10%">${ good.num }</td>
					<td width="10%">${ good.writer }</td>
					<td>${ good.content }</td>
					<td width="20%">
					  <fmt:formatDate value="${ good.regdate }" pattern="yy.MM.dd hh:mm:ss"/>
					  
					</td>
					<td><form action="commentDelete?num=${ good.num }&uniquenum=${ content.num }" method="post"><input id="btnCancel_review" type="submit" value="삭제하기"></form></td>
					
				</tr>
			  
			</c:forEach>
			 
			
			</table>
		
			<form action="commentSubmit?uniquenum=${ content.num }" method="post" id="commentform">

				<table>
					<tr height="50px;">
						<td width="10%">작성자 이름</td>
						<td>내용</td>
						<td width="10%"></td>
					</tr>
					<tr>
					<c:choose>
						<c:when test="${sessionScope.user_id != null }">
						<td><input type="text" name="writer" id="writer"
							style="border: none; background-color: #ffffff; height: 45px; width: 100%; text-align: center" value="${sessionScope.user_id }" readonly></td>
						</c:when>
						<c:otherwise>
						<td><input type="text" name="writer" id="writer"
							style="border: none; background-color: #ffffff; height: 45px; width: 100%; text-align: center"></td>
						</c:otherwise>
					</c:choose>
						<td><input type="text" name="content" id="content"
							style="border: none; background-color: #ffffff; height: 45px; width: 95%; text-align: center"></td>
				        <td>
				            <input id="btnSubmit_review" type="button" value="댓글 등록" onclick="cRegisterCheck()">
				           
				        </td>

					</tr>
				</table>
			
				

					
				
				
			</form>
</div>
		</div>




	</section>

	<%@ include file="../include/footer.jsp"%>

<script type="text/javascript">
function cRegisterCheck() {
	  if ($("#writer").val().length < 1) {
		  alert("이름을 입력하세요");
	  } else if ($("#content").val().length < 1) {
		  alert("내용을 입력하세요.");
	  } else if (confirm("댓글을 등록하시겠습니까?")) {
		  $("#commentform").submit();
	  }
}


</script>

<script src="http://code.jquery.com/jquery-latest.js"></script> 
</body>
</html>