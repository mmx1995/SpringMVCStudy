<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HttpMeaagerConverter Demo</title>
</head>
<body>
	<script src="assets/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
		function req(){
			$.ajax({
				url:"converter",
				date:"l-wangyunfei",
				type:"POST",
				contentType:"application/x-wisely",
				success:function(date){
					$("#resp").html(date);
				}
			})
		}
	</script>
	<div id=resp>
		
	</div>
	<input type="button" onclick="req()" value="请求">
	
</body>
</html>