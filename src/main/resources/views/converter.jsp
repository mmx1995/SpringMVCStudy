<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HttpMeaagerConverter Demo</title>
</head>
<body>
	
	<div id="resp">
		
	</div>
	<input type="button" onclick="req()" value="请求">
	
	<script src="assets/js/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
		function req(){
			$.ajax({
				url:"login",
				data:"{\"username\":\"1234\",\"password\":\"1234\"}",
				type:"POST",
				contentType:"application/json",
				success:function(date){
					$("#resp").html(date);
				}
			})
		}
	</script>
</body>
</html>