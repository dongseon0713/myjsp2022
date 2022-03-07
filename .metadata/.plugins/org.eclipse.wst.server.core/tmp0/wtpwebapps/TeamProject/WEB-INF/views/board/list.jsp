<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="../include/header.jsp" %>


<section id="contentwrap">
            <div id="content_bottom" class="top_padding">
              <select id="select">
                        <option>카테고리 별 보기</option>
                        <option value="##">도시1</option>
                        <option value="##">도시2</option>
                        <option value="##">도시3</option>
                        <option value="##">도시4</option>
                        <option value="##">도시5</option>

                </select>
                
                <table id="table" width=1000px; height=220px;>
                   
                   <c:forEach var="######" items="#######" varStatus="#######">
                    <tr>
                       <td rowspan=2 width=50px;>도시</td>
                        <td rowspan=2 width=300px;><img src="temp_img.jpg" alt="썸네일" width=100%;></td>
                        
                        <td colspan=5 class="td_bor_bottom td_font" onclick="location.href='###########';">음식점 상호(or 제목)</td>
                    </tr>
                    <tr height=10px; >
                        <td class="td_size"><i class="fa-solid fa-eye"></i>     조회수</td>
                     
                        <td class="td_size"><i class="fa-solid fa-thumbs-up"></i>     추천수</td>
                        <td></td>
                        <td class="td_size"><i class="fa-solid fa-calendar"></i>     2000.00.00</td>
                        <td class="td_size"><i class="fa-solid fa-pen"></i>     작성자</td>
                    </tr>
                    <tr>
                            <td height="20px;"></td>
                            
                    </c:forEach>
                       
                       
                    
                    
                    
                </table>
                
                <button type="button"
					onclick="location.href='#########'">글쓰기</button>
                
                <ul>
					<li><a
						href="##############">Previous</a></li>

					<li><a
						href="##############">1</a></li>

					<li><a
						href="##############">Next</a></li>
				</ul>
                
            </div>



        </section>
        
<%@ include file="../include/footer.jsp" %>
</body>
</html>