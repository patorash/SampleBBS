<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja" lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><c:if test="${param.title == null}">サンプル掲示板</c:if><c:if test="${params.title != null}">${param.title} | サンプル掲示板</c:if></title>
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta name="description" content="${param.description}" />
<meta name="keywords" content="${param.keywords}" />
<meta name="robots" content="index,follow" />
<!-- Source File -->
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.8.2r1/build/reset/reset-min.css" />
<link rel="stylesheet" type="text/css" href="/css/layout.css" />
<link rel="stylesheet" type="text/css" href="/css/main.css" />
<c:forEach items="${cssFiles}" var="css">
<link rel="stylesheet" href="${css}" type="text/css" media="all" />
</c:forEach>
<c:forEach items="${jsFiles}" var="js">
<script type="text/javascript" src="/js/${js}"></script>
</c:forEach>
</head>
<body>
<div id="container">
	<c:import url="/header.jsp" />
	<div id="main">
		<div id="content">
		${param.content}
		</div>
	</div>
	<c:import url="/footer.jsp" />
</div>
</body>
</html>