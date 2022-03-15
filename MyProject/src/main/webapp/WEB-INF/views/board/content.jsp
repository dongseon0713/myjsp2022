<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../include/header.jsp"%>

	<section id="contentwrap">

		<div id="content_top" class="top_padding">

			<ul id="top_img">
				<!--for문-->
				<li><img src="temp_img2.jfif"></li>
				<li><img src="temp_img2.jfif"></li>
				<li><img src="temp_img2.jfif"></li>
				<li><img src="temp_img2.jfif"></li>
			</ul>


		</div>


		<div id="content_bottom">

			<div class="left">
				<button id="review_register" type="button"
					onclick="location.href='list'">목록</button>
				<button id="review_register" type="button"
					onclick="location.href='modify?num=${content.num}'">수정</button>
			</div>

			<table width="50%" style="text-align: left;">

				<tr style="height: 100px;">
					<th colspan="4" style="font-size: 36px;">${ content.title }</th>
				</tr>

				<tr style="height: 20px; font-size: 12px;">

					<td style="width: 25%;">${ content.writer }</td>
					<td style="width: 25%;"><i class="fa-solid fa-eye"></i>${ content.hit }</td>
					<td style="width: 25%;">${ content.regdate }</td>
					<td style="width: 25%;">마지막 수정일</td>

				</tr>
			</table>
			<hr>
			<table id="content_table" width="40%"
				style="text-align: center; font-size: 12px;">

				<tr>
					<td style="width: 20%">가게명</td>
					<td colspan="3">${ content.name }</td>
				</tr>
				<tr>
					<td>주소</td>
					<td colspan="3">${ content.address }</td>
				</tr>
				<tr>
					<td>주차장</td>
					<td colspan="3">${ content.carpark }</td>
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
					<td id="content" colspan="4"
						style="max-width: 100px; word-wrap: break-word">
						${ content.content }


					</td>
				</tr>

			</table>



			<br>
			<hr>
			<br>

			<h3 style="text-align: left">댓글</h3>

			<table id="review_table" width="100%">

				<tr height="150px;">
					<td width="10%">번호</td>
					<td width="10%">작성자 이름</td>
					<td>내용</td>
					<td width="20%">작성일</td>
				</tr>
				<tr height="150px;">
					<td width="5%">번호</td>
					<td width="10%">작성자 이름</td>
					<td>내용</td>
					<td width="20%">작성일</td>
				</tr>

				<tr height="150px;">
					<td width="5%">번호</td>
					<td width="10%">작성자 이름</td>
					<td>내용</td>
					<td width="20%">작성일</td>
				</tr>

				<tr height="150px;">
					<td width="5%">번호</td>
					<td width="10%">작성자 이름</td>
					<td>내용</td>
					<td width="20%">작성일</td>
				</tr>


			</table>
			<form>

				<table>
					<tr height="50px;">
						<td width="10%">작성자 이름</td>
						<td>내용</td>
					</tr>
					<tr>

						<td><input type="text" readonly
							style="border: none; background-color: #ffffff; height: 45px; width: 100%"></td>
						<td><input type="text"
							style="border: none; background-color: #ffffff; height: 45px; width: 100%"></td>

					</tr>
				</table>

				<div class="left">

					<button id="review_register" type="button"
						onclick="location.href='#########'">댓글 등록</button>
				</div>

			</form>
		</div>




	</section>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>