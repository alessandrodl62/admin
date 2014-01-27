<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test di scrittura di una attività</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>		
<script type="text/javascript" src="<%=request.getContextPath()%>/js/fastserialize.js"></script> 

</head>
<body>
<form name="invia" id="invia">

		<a href="##" id="clicca">premi qui</a>

</form>



</body>
</html>
<script>
	$("#clicca").click(function(){
	
	    alert("cliccato qui <%=request.getContextPath()%>");
			$.post('<%=request.getContextPath()%>/AttivitaServlet',
						{});
			alert("effettuato il post");
	});		

	
</script>