<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Cookie[] arr = request.getCookies();
    	
    	String id = null;
    	/*
    	if(arr != null){
    		for(int i = 0; i<arr.length;i++){
    			if(arr[i].getName().equals("user_id")){
    			id = arr[i].getValue();
    			}
    		}
    	}
    	*/
    	// 진화된 for인 for each문으로 변경...
    	if(arr != null){
    		for(Cookie c: arr){
    			if(c.getName().equals("user_id")){
        			id = c.getValue();
        			}
    		}
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%= id %>님 환영합니다.

</body>
</html>