<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/_header.jsp" %>
	
	<section>
		<div align="center">
			<form name="regform" action="register.board" method="post">
				<h2>게시판 글 작성 페이지</h2>
				<hr>
				<table border="1">
					<tr>
						<td>작성자</td>
						<td><input type="text" size="10" name="writer"></td>
					</tr>
					<tr>
						<td>글 제목</td>
						<td><input type="text" size="50" name="title"></td>
					</tr>
					<tr>
						<td>글 내용</td>
						<td><textarea rows="10" style="width:100%;" name="content"></textarea></td>
					</tr>
					<tr>
						<!-- 글 등록 메뉴 -->
						<td colspan="2" align="center">
							<input type="button" value="글 목록" onclick="location.href='list.board'">
							<input type="button" value="등록" onclick="registCheck()">
							<input type="button" value="취소" onclick="">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	
<%@ include file="../include/_footer.jsp" %>
	<!-- 
		registCheck() 구현 
	작성자, 글제목에 공백을 확인하고, 공백이 아니라면 submit() 처리
	-->
<script type="text/javascript">
	function registCheck(){
		if(document.regform.writer.value == ""){
			alert("작성자는 필수 사항입니다.");
			return;
		}else if(document.regform.title.value == ""){
			alert("글 제목은 필수 사항입니다.");
			return;
		}else if(confirm("게시글을 등록 하겠습니까?")){
			document.regform.submit();
		}
	}
</script>
