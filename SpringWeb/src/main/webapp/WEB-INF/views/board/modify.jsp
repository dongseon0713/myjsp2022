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

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Modify Page</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">수정 페이지</div>
      <div class="card-body">



        <form role="form" action="update" method="post" name="regform" id="regform">
          
          <div class="form-group">
            <label>번호</label>
            <input class="form-control" name="num" value="${vo.num }" readonly="readonly">
          </div>
          
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name="title" value="${vo.title }">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name="content">${vo.content }</textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name="writer" value="${vo.writer }" readonly="readonly">
          </div>
          
          
           
          <button type="submit" class="btn btn-primary">변경</button>
          <button type="button" class="btn btn-secondary" onclick="location.href='delete?num=${vo.num}'">삭제</button>
          <button type="button" class="btn btn-dark" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count }'">목록</button>
          </form>
           <!--
         	자바 스크립트를 이용한 처리  
           <button type="button" class="btn btn-primary" onclick="check('modify')">변경</button>
          <button type="button" class="btn btn-secondary" onclick="check('delete')">삭제</button>
          <button type="button" class="btn btn-dark" onclick="check('list')">목록</button>
        </form>
			-->


      </div>
      <!--  end card-body -->
    </div>
    <!--  end card-body -->
  </div>
  <!-- end card -->
</div>
<!-- /.row -->

<%@ include file="../include/footer.jsp" %>
<script>
	function check(e){
		//$("#아이디") 는 HTML의 아이디 속성에 한번에 접근할 수 있음.
		//attr(속성, 변경할 값) 함수는 태그 내부 속성을 변경하는 함수
		if(e == 'modify'){
			if(document.regform.title.value == ''){
				alert("제목은 필수사항 입니다.");
			}else if(document.regform.content.value == ''){
				alert("내용은 필수사항 입니다.");
			}else if(confirm("변경하시겠습니까 ? ")){
				document.regform.submit();
			}
		}else if(e == 'delete'){
			if(confirm("삭제하겠습니까?")){
				//$는 값을 불러옴 #은 form에 id값 id를 쓰지 않으면 값을 불러올수없다.
				$("#regform").attr("action","delete");
				$("#regform").submit();
			}else{
				return;
			}
		}else{
			$("#regform").attr("action","list");
			$("#regform").submit();
		}
		
	}
</script>
</body>
</html>