<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<spring:url value="/scripts/script.js" var="menuscriptsjs" />
<spring:url value="/scripts/jpl-menus.js" var="menusJS" />
<spring:url value="/styles/styles.css" var="menucss" />
<spring:url value="/scripts/jquery.min.js" var="jqueryJS" />
<spring:url value="/scripts/jquery-ui.min.js" var="jqueryuiJS" />
<spring:url value="/scripts/bootstrap.min.js" var="bootstrapJS" />

<link href="${menucss}" rel="stylesheet" />
<script src="${jqueryJS}"></script>
<script src="${jqueryuiJS}"></script>
<script src="${menuscriptsjs}"></script>
<script src="${bootstrapJS}"></script>
<script src="${menusJS}"></script>

<title>CSS MenuMaker</title>

</head>
<body>

	<div id='cssmenu'>
		<ul>
			<li><a href='#' id="homepage"><span>Home</span></a></li>
			<li class='last'><a href='#' id="postjobmenu"><span>Post
						Job</span></a></li>

			<li class='last'><a href='#' id="trainingsoffered"><span>Trainings</span></a></li>
			<li class='last'><a href='#' id="logoutmenu"><span>Logout</span></a></li>

		</ul>
	</div>

</body>
<html>