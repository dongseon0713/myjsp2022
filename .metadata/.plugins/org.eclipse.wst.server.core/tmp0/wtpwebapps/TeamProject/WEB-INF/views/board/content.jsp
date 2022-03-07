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
					onclick="location.href='#########'">목록</button>
				<button id="review_register" type="button"
					onclick="location.href='#########'">변경</button>
			</div>

			<table width="50%" style="text-align: left;">

				<tr style="height: 100px;">
					<th colspan="4" style="font-size: 36px;">제목</th>
				</tr>

				<tr style="height: 20px; font-size: 12px;">

					<td style="width: 25%;">작성자</td>
					<td style="width: 25%;"><i class="fa-solid fa-eye"></i>조회수</td>
					<td style="width: 25%;">최초 작성일</td>
					<td style="width: 25%;">마지막 수정일</td>

				</tr>
			</table>
			<hr>
			<table id="content_table" width="40%"
				style="text-align: center; font-size: 12px;">

				<tr>
					<td style="width: 20%">가게명</td>
					<td colspan="3">가게명 상세</td>
				</tr>
				<tr>
					<td>주소</td>
					<td colspan="3">주소 상세</td>
				</tr>
				<tr>
					<td>주차장</td>
					<td colspan="3">주차장 상세</td>
				</tr>
				<tr>
					<td>영업시간</td>
					<td>오픈시간</td>
					<td>-</td>
					<td>닫는시간</td>
				</tr>
				<tr>
					<td>브레이크 타임</td>
					<td colspan="3">브레이크 타임 상세</td>
				</tr>
				<tr>
					<td>라스트 오더</td>
					<td colspan="3">라스트 오더 상세</td>
				</tr>
				<tr>
					<td>휴일</td>
					<td colspan="3">휴일 상세</td>
				</tr>
				<tr>
					<td id="content" colspan="4"
						style="max-width: 100px; word-wrap: break-word">
						내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용


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