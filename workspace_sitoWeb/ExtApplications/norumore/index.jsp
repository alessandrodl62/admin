<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Anagrafica</title>
	<link rel="stylesheet" type="text/css" href="/appresources/ext/resources/css/ext-all.css"/>
<script> 

	<%session.setAttribute("idente", new Integer(2));%>
	var appContext = {
		currentAnagRecord: null,
		currentEnte: <%=session.getAttribute("idente")%>

	};
</script>

	<script type="text/javascript" src="/appresources/ext/adapter/ext/ext-base.js"></script> 
	<script type="text/javascript" src="/appresources/ext/ext-all.js"></script>
	<script type="text/javascript" src="/appresources/ext/ext-lang-it-min.js"></script>

	<script type="text/javascript" src="/appresources/anagrafica/editForm.js"></script>
	<script type="text/javascript" src="/appresources/anagrafica/anagGrid.js"></script>
	<script type="text/javascript" src="/appresources/anagrafica/winEditForm.js"></script>
	<script type="text/javascript" src="/appresources/anagrafica/profEdit.js"></script>
	<script type="text/javascript" src="/appresources/anagrafica/anagCercaForm.js"></script>

	<script type="text/javascript" src="/appresources/anagrafica/anagmain.js"></script>

	<script type="text/javascript" src="/appresources/norumore/noRumoreFormTab1.js"></script>
	<script type="text/javascript" src="/appresources/norumore/noRumoreWinEditForm.js"></script>

	<script type="text/javascript" src="apprumore.js"></script>

	<!-- script type="text/javascript" src="/appresources/anagrafica/editForm.js"></script>
	<script type="text/javascript" src="/appresources/anagrafica/anagGrid.js"></script>
	<script type="text/javascript" src="/appresources/anagrafica/winEditForm.js"></script>
	<script type="text/javascript" src="/appresources/anagrafica/profEdit.js"></script>
	<script type="text/javascript" src="/appresources/anagrafica/anagCercaForm.js"></script>

	<script type="text/javascript" src="app.js"></script -->


	<style>
		//.x-grid3-col-0{background: no-repeat url(../img/Window_Edit.gif) !important; padding-left: 18px}
		.x-trigger-search{background: url(/appresources/ext/resources/images/default/form/search-trigger.gif) !important}
	</style>

</head>
<body>



</body>
</html>