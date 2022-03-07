<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page session="false" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%@include file="include/header.jsp"%>

 <section id="contentwrap">

            <div id="content_top" class="top_padding">
                <div id="logo">
                    <a href="">
                        <img src="resources/img/logo.png" alt="메인로고" style="height:220px">
                    </a>
                </div>
                <div id="search">
                    <i class="fas fa-search"></i>
                    <input id="search_text" type="text" name="search" placeholder="        지역,식당 또는 음식">
                    <input type="submit" value="검색">
                </div>

                <div id="search_opt">
                    <select id="select">
                        <option>도시</option>
                        <option value="##">도시1</option>
                        <option value="##">도시2</option>
                        <option value="##">도시3</option>
                        <option value="##">도시4</option>
                        <option value="##">도시5</option>

                    </select>
                </div>

            </div>


            <div id="content_bottom">
                <h2 style="text-align: left">지역별 맛집</h2>

                <div id="do">



                        <table  width="100%" height="640px">
                            <tr>
                                <td width="33.3%">
                                    <a href="">
                                        <img src="" alt="특별,광역시">
                                    </a>
                                </td>

                                <td width="33.3%">
                                    <a href="">
                                        <img src="" alt="경기">
                                    </a>
                                </td>

                                <td width="33.3%">
                                    <a href="">
                                        <img src="" alt="강원">
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="">
                                        <img src="" alt="충남">
                                    </a>
                                </td>

                                <td>
                                    <a href="">
                                        <img src="" alt="충북">
                                    </a>
                                </td>

                                <td>
                                    <a href="">
                                        <img src="" alt="경북">
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="">
                                        <img src="" alt="전남">
                                    </a>
                                </td>

                                <td>
                                    <a href="">
                                        <img src="" alt="전북">
                                    </a>
                                </td>

                                <td>
                                    <a href="">
                                        <img src="" alt="경남">
                                    </a>
                                </td>
                            </tr>


                        </table>




                </div>



                <div id="side">

                    <div id="login">
                        <a href="mem_login">로그인</a>
                    </div>
                    <div id="clock">
                        시계
                    </div>
                    <div id="counter">
                        카운터
                    </div>

                </div>
            </div>

        </section>


<%@ include file="include/footer.jsp"%>
</body>
</html>
