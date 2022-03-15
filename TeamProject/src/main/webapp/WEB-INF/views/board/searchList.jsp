<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />

</head>
<body>

<%@ include file="../include/header.jsp" %>


<section id="contentwrap">
            <div id="content_bottom" class="top_padding">
            
              <c:choose>
              <c:when test="${city eq 'seoul'}">
				<h2 style="text-align: left; font-size:30px;">특별,광역시 맛집</h2>
			</c:when>
			 <c:when test="${city eq 'gyeonggi'}">
				<h2 style="text-align: left; font-size:30px;">경기도 맛집</h2>
			</c:when>
			<c:when test="${city eq 'gangwon'}">
				<h2 style="text-align: left; font-size:30px;">강원도 맛집</h2>
			</c:when>
			<c:when test="${city eq 'chungnam'}">
				<h2 style="text-align: left; font-size:30px;">충청남도 맛집</h2>
			</c:when>
			<c:when test="${city eq 'chungbuk'}">
				<h2 style="text-align: left; font-size:30px;">충청북도 맛집</h2>
			</c:when>
			<c:when test="${city eq 'gyeongbuk'}">
				<h2 style="text-align: left; font-size:30px;">경상북도 맛집</h2>
			</c:when>
			<c:when test="${city eq 'jeonnam'}">
				<h2 style="text-align: left; font-size:30px;">전라남도 맛집</h2>
			</c:when>
			<c:when test="${city eq 'jeonbuk'}">
				<h2 style="text-align: left; font-size:30px;">전라북도 맛집</h2>
			</c:when>
			<c:when test="${city eq 'gyeongnam'}">
				<h2 style="text-align: left; font-size:30px;">경상남도 맛집</h2>
			</c:when>
			
			</c:choose>
			<table id="table">

				<c:forEach var="article" items="${ board }" varStatus="num">

					<tr>
						<td colspan="4" height="10px;"></td>
					</tr>

					<tr onclick="location.href='content?num=${article.num }'"
						style="cursor: pointer;">
						<td class="td_bor_right" rowspan="2" width="40px">
							${article.num }</td>
						<td rowspan=2 width=300px;><img src="${article.gdsThumbImg }" alt="썸네일"></td>
						<td colspan=3 class="td_font">${article.title }</td>
					</tr>

					<tr onclick="location.href='content?num=${article.num }'" 
					style="cursor: pointer;" height=10px;>
						<td class="td_size"><i class="fa-solid fa-eye"></i>
							${article.hit }</td>
						<td class="td_size"><i class="fa-solid fa-pen"></i>
							${article.writer }</td>
						<td class="td_size"><i class="fa-solid fa-calendar"></i> <fmt:formatDate
								value="${article.regdate}" pattern="yyyy-MM-dd" /></td>
					</tr>


					<tr>
						<td class="td_bor_bottom" colspan="5" height="10px;"></td>
					</tr>

				</c:forEach>

			</table>
                       
                       
                    
                    
                    
            
                <ul>
				<c:if test="${ page.prev }">
					<li><a href="searchList?search=${city }&pageNum=${ page.startPage - 1 }">Previous</a></li>
				</c:if>
				<c:forEach var="num" begin="${ page.startPage }"
					end="${ page.endPage }">
					<li><a href="searchList?search=${city }&pageNum=${ num }">${ num }</a></li>
				</c:forEach>
				<c:if test="${ page.next }">
					<li><a href="searchList?search=${city }&pageNum=${ page.endPage + 1 }">Next</a></li>
				</c:if>
			</ul>

			
				<button type="button" id=btnSubmit
					onclick="location.href='register'">글쓰기</button>
		

		</div>



        </section>
         <input type="hidden" name="searchName" value="${pageVO.cri.search }">
<%@ include file="../include/footer.jsp" %>
</body>
</html>