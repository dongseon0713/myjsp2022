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
           
            <div id="content_bottom" class="top_padding">
             <h2>회원정보 수정</h2>
             
            <form>

                <table id="regist_table" width="40%" style="text-align: left; font-size: 12px; background-color: ">
                   <tr>
                       <td style="width:30%;  height:50px" >아이디</td>
                       <td colspan="2"><input type="text" name="####" readonly style="border: none; background-color: #ffffff; height: 40px; width: 100%">
                    </tr>
                    
                        <tr>
                       <td style="width:30%;  height:50px" >비밀번호</td>
                       <td  colspan="2"><input type="text" name="####" style="border: none; background-color: #ffffff; height: 40px; width: 100%">
                    </tr>
                    
                     <tr>
                       <td style="width:30%;  height:50px" >비밀번호 확인</td>
                       <td  colspan="2"><input type="text" name="####" style="border: none; background-color: #ffffff; height: 40px; width: 100%">
                    </tr>
                    
                     <tr>
                       <td style="width:30%;  height:50px" >이름</td>
                       <td  colspan="2"><input type="text" name="####" style="border: none; background-color: #ffffff; height: 40px; width: 100%">
                    </tr>
                    
                      <tr>
                       <td style="width:30%;  height:50px" >닉네임</td>
                       <td  colspan="2"><input type="text" name="####" style="border: none; background-color: #ffffff; height: 40px; width: 100%">
                    </tr>
                    
                        <tr>
                        <td style= "height:50px">성별</td>
                        <td style="text-align: center"><input type="radio" id="male" name="gender" checked>
                            <label for="male">남성</label>
                        <td style="text-align: center">
                       <input type="radio" id="female" name="gender">
                            <label for="n">여성</label>
                        </td>
                    </tr>
                    <tr>
                       <td style="width:30%;  height:50px"> 주소</td>
                       <td  colspan="2"><input type="text" name="####" style="border: none; background-color: #ffffff; height: 40px; width: 100%">
                    </tr>
                                        <tr>
                       <td style="width:30%;  height:50px"> 이메일</td>
                       <td  colspan="2"><input type="text" name="####" style="border: none; background-color: #ffffff; height: 40px; width: 100%">
                    </tr>
                    

                </table>
                <br>
                <div>
                    <button type="button" onclick="location.href='########'">목록</button>
                    <button type="button" onclick="location.href='########'">수정</button>
                    <button type="button" onclick="location.href='########'">탈퇴</button>
                </div>

            </form>


            </div>


        </section>



<%@ include file="../include/footer.jsp" %>
</body>
</html>