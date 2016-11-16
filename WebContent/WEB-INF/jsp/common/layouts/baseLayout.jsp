<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="-1" />
    <title><fmt:message key="app.title"/></title>
    <link href="${cssPath}bootstrap.min.css" rel="stylesheet">
	<link href="${cssPath}style.css" rel="stylesheet">
	
</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="header"/>
		<tiles:insertAttribute name="body"/>
	</div>
	<tiles:insertAttribute name="footer"/>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script src="${jsPath}jquery-3.1.1.min.js"></script>
    <script src="${jsPath}bootstrap-3.3.7.min.js"></script>	
</body>
</html>