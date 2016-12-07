<%@ include file="view/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>demo主页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<body>
	<%-- 点击测试 --%>
	<a href="${path}/quartzController/getQuartzById.do?id=1">点击测试</a>
	
	<%-- 进入MQ主页 --%>
	<a href="${path}/welcomeController/welcome.do">进入MQ主页</a>
	
</body>

<script type="text/javascript">

	

</script>
</html>