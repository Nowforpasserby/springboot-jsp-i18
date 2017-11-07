<%--
  Created by IntelliJ IDEA.
  User: JG.Hannibal
  Date: 2017/11/7
  Time: 上午10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="i18/messages_${system_language}"/>
<html>
<head>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <%--<title>#{title}</title>--%>
</head>
<body>
<div id="footer">
    <div id="copyright">
        <span><fmt:message key="common.copyright"/></span>
    </div>
    <div id="language">
        <span><fmt:message key="common.language"/>:</span>
        <a href="#" data-value="zh_CN">中文</a>
        <span>|</span>
        <a href="#" data-value="en_US">English</a>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $('#language').find('a').click(function () {
            var language = $(this).data('value');
            document.cookie = "cookie_language=" + language +
                ";expires=365";
            location.reload();
        });
    });
</script>
</html>
