<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String baseUrl = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort();
	baseUrl += request.getContextPath() + "/";
	//注：path="yuerleyuan2016"
	String path = request.getContextPath();
	request.setAttribute("path", path);
	request.setAttribute("baseUrl", baseUrl);
	request.setCharacterEncoding("utf-8");
%>
<base href="<%=baseUrl%>" />

<!-- <script type="text/javascript" src="../static/bootstrap/wb0b654kl/assets/js/jquery.js"></script> -->

<%-- 弹框提示的CSS（JS在下面） --%>
<link type="text/css" rel="stylesheet" href="static/css/xcConfirm.css" >

<script src="static/js/jquery.js" type="text/javascript" ></script>
<%-- 弹框提示的JS（css在上面） --%>
<script src="static/js/xcConfirm.js" type="text/javascript" ></script>

<%-- 此处用于ajax的session过期判断 --%>
<script src="static/js/ajaxComplete.js" type="text/javascript" ></script>





