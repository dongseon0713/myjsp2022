<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ include file="../include/_header.jsp" %>

	<section>
		<div align="center">
			<h3>게시글 보기</h3>
			<hr>
			<form name="regform" action="update.board" method="post">
				<table border="1" width="500" >
					<tr>
						<td	width="20%">글번호</td>
						<td width="30%"><input type="text" name="num" value="${vo.num }" readonly></td> 
					</tr>
					<tr>
						<td width="20%">작성자</td>
						<td><input type="text" name="writer" value="${vo.writer }" readonly></td>
					</tr>
					<tr>	
						<td>제목</td>
						<td><input type="text" name="title" value="${vo.title }"></td> 
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3" height="120"><textarea rows="10" style="width:100%;" name="content">
						${vo.content }
						</textarea></td> 
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="button" value="목록" onclick="location.href='list.board'">
						<input type="button" value="수정" onclick="modifycheck()">
						<input type="button" value="삭제" onclick="deletecheck()">
					</tr>
				</table>
			</form>
		</div>
	</section>

<%@ include file="../include/_footer.jsp" %>

<script type="text/javascript">
	function modifycheck() {
		//글 제목에 공백을 확인하고, 공백이 아니라면 submit() 처리
		if(document.regform.title.value == ''){
			alert("글 제목은 필수 사항 입니다.");
			return;
		}else if(confirm("게시글을 수정하시겠습니까?")){
			document.regform.submit();
		}
		
	}
	function deletecheck() {
		if(confirm("게시글을 삭제하겠습니까?")){
			location.href="delete.board?num=${vo.num}"
		}
	}
</script>