<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Najagso Admin</title>
<link rel="stylesheet" href="admin/css/admin.css">
<c:choose>
	<c:when test="${empty workerId}">
		<script type="text/javascript">
			location.href = 'NajagsoServlet?command=admin_login_form';
		</script>
	</c:when>
</c:choose>
</head>
<body onload="go_ab()">
	<div id="wrap">
		<header>			
			<div id="logo">
				<a href="NajagsoServlet?command=admin_login_form"> 
					<img style="width:800px" src="admin/images/logo.png">
					<img src="admin/images/text.gif">
				</a>
			</div>	
			<input class="btn" type="button"  value="logout"  style="float: right;"
			   onClick="location.href='NajagsoServlet?command=admin_logout'">			
		</header>
		<div class="clear"></div>