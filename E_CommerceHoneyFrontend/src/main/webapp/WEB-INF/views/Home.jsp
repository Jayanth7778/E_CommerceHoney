<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Honey Web Application</title>

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<!-- <link rel="stylesheet" href="resources/css/bootstrap.css"> -->

<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/cloud-zoom.css" />" rel="stylesheet">

<!-- <link rel="stylesheet" href="resources/css/style.css">  -->

<script src="<c:url value="/resources/js/jquery-3.2.0.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/CustomJS.js" />"></script>

<!-- <script src="resources/js/jquery-3.2.0.js"></script>
<script src="resources/js/bootstrap.js"></script> -->
</head>
<body>
	<!-- Display Menu -->
	<jsp:include page="Menu.jsp"></jsp:include>
	
	<!-- Display Carousel and Products -->
	<c:if test="${isUserAtHomePage=='true'}">
		<jsp:include page="Carousel.jsp"></jsp:include>
		<jsp:include page="Products.jsp"></jsp:include>
	</c:if>

	<!-- Display Footer -->
	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>