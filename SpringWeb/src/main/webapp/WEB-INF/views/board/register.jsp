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
    <h1 class="page-header">Board Register</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">게시글 등록</div>
      <div class="card-body">



        <form role="form" action="register" method="post" id="regForm">
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name='title' id="title">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='content' id="content"></textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name='writer' id="writer">
          </div>
          
          <!-- 
          <button type="submit" class="btn btn-primary">등록</button>
          <button type="reset" class="btn btn-primary" onclick="location.href='list'">취소</button>
 		  -->        
          
          <!-- 모달과 자바 스크립트 사용해보기 -->
          <!-- onclick속성은 클릭했을 실행될 자바 스크립트 함수가 작성됩니다. -->		
          <button type="button" class="btn btn-primary" onclick="register()">등록</button>
          <!-- <button type="button" class="btn btn-primary" onclick="location.href='list'">취소</button>  -->
          
          <%-- 페이징 --%>
          <button type="button" class="btn btn-primary" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count}'">취소</button> 	
        </form>



      </div>
      <!--  end card-body -->
    </div>
    <!--  end card-body -->
  </div>
  <!-- end card -->
</div>
<!-- /.row -->
<%@ include file="../include/footer.jsp" %>

<script type="text/javascript">
	function register() {

		//$("#아이디") 는 HTML의 아이디 속성에 한번에 접근합니다.
		//val()함수는 해당 아이디의 값에 접근합니다.
		if( $("#title").val() == "" ) {
			
			$("#myModal").modal("show");//모달 보기
		} else if( $("#writer").val() == "") {
			
			$("#myModal").modal("show");//모달 보기
		} else {
			$("#regForm").submit(); //스크립트 서브밋 함수
		}

	}

</script>
	<!-- 
	모달창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	화면에 미리 만들어 놓고 호출해서 사용하는 방식을 사용합니다.
	id 지정-> 자바스크립트를 통해 modal("show") 함수로 화면에 보여지도록 처리합니다.
	 -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Modal Heading</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">제목, 작성자는 필수 사항입니다.</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

</body>
</html>




