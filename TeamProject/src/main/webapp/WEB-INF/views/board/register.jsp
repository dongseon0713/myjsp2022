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

  <section id="contentwrap">

            <div id="content_top" class="top_padding">
            <form method="post" enctype="multipart/form-data">
                <ul id="top_img">
                    <!--for문-->
                    <li>
                       <div class="upload">
                        <label for="chooseFile">
                            사진 업로드
                        </label>

                        <input type="file" id="chooseFile" name="chooseFile" accept="image/*" onchange="loadFile(this)">
                        </div>
                    </li>

                </ul>
            </form>

            </div>


            <div id="content_bottom">

            <form action="#####" method="post" id="#####">


                <table id="content_table" width="100%" style="text-align: center; font-size: 15px; background-color: ">
                   <tr>
                       <td style="width:20%">작성자</td>
                       <td><input type="text" name="####" readonly style="border: none; background-color: #ffffff; height: 45px; width: 100%"></td>
                       <td>글번호</td>
                       <td>
                       <input type="text" name="#####" readonly style="border: none; background-color: #ffffff; height: 45px; width: 100%">
                       </td>
                       </tr>
                    <tr>
                        <td>제목</td>
                        <td colspan="3"><input type="text" name="#####" style="border: none; background-color: #ffffff; height: 45px; width: 100%"></td>
                    </tr>
                    <tr>
                        <td style="width: 20%">가게명</td>
                        <td colspan="3"><input type="text" name="#####" style="border: none; background-color: #ffffff; height: 45px; width: 100%"></td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td colspan="3"><input type="text" name="#####" style="border: none; background-color: #ffffff; height: 45px; width: 100%"></td>
                    </tr>
                    <tr>
                        <td>주차장</td>
                        <td><input type="radio" id="y" name="carpark" checked>
                            <label for="y">있음</label>
                        </td>
                        <td><input type="radio" id="n" name="carpark">
                            <label for="n">없음</label>
                        </td>
                        <td><input type="radio" id="u" name="carpark">
                            <label for="u">모름</label>
                        </td>
                    </tr>
                    <tr>
                        <td>영업시간</td>
                        <td><input type="time" name="#####" style="border: none; background-color: #ffffff; height: 45px; width: 100%;"></td>
                        <td>-</td>
                        <td><input type="time" name="#####" style="border: none; background-color: #ffffff; height: 45px; width: 100%"></td>
                    </tr>
                    <tr>
                        <td>브레이크 타임</td>
                        <td colspan="3"><input type="time" name="####" style="border: none; background-color: #ffffff; height: 45px;  width: 100%"></td>
                    </tr>
                    <tr>
                        <td>라스트 오더</td>
                        <td colspan="3">
                            <input type="time" name="#####" style="border: none; background-color: #ffffff; height: 45px;  width: 100%">
                        </td>
                    </tr>
                    <tr>
                        <td>휴일</td>
                        <td colspan="3">
                            <input type="text" name="####" style="border: none; background-color: #ffffff; height: 45px; width: 100%">
                        </td>
                    </tr>
                    <tr>

                    </tr>
                    <tr>
                        <td>내용</td>
                        <td id="content" colspan="3">
                            <textarea name="#####" cols="120" rows="30"></textarea>
                        </td>
                    </tr>

                </table>

                <div class="left">
                    <button type="button" onclick="location.href='#######'">목록</button>
                    <button type="button" onclick="location.href='#######'">등록</button>
                </div>

            </form>
            </div>

        </section>


<%@ include file="../include/footer.jsp" %>
</body>
</html>