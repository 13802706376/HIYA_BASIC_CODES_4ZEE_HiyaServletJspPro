<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   //核心标签库
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>  //数据库标签库
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
           response.setStatus(500);
		// 获取异常类
		Throwable ex = Exceptions.getThrowable(request);
		if (ex != null) 
		{
			LoggerFactory.getLogger("500.jsp").error(ex.getMessage(), ex);
		}

		// 编译错误信息
		StringBuilder sb = new StringBuilder("错误信息：\n");
		if (ex != null) 
		{
			sb.append(Exceptions.getStackTraceAsString(ex));
		} else 
		{
			sb.append("未知错误.\n\n");
		}

		// 如果是异步请求或是手机端，则直接返回信息
		if (Servlets.isAjaxRequest(request)) 
		{
			out.print(sb);
		}

		// 输出异常信息页面
		else 
		{
%>
<%@page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>
<%@page import="com.yunnex.ops.erp.common.web.Servlets"%>
<%@page import="com.yunnex.ops.erp.common.utils.Exceptions"%>
<%@page import="com.yunnex.ops.erp.common.utils.StringUtils"%>
<%@page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>500 - 系统内部错误</title>
<%@include file="/WEB-INF/views/include/head.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<h1>系统内部错误.</h1>
		</div>
		<div class="errorMessage">
			错误信息：<%=ex == null ? "未知错误." : StringUtils.toHtml(ex.getMessage())%>
		<br /> <br /> 请点击“查看详细信息”按钮，将详细错误信息发送给系统管理员，谢谢！<br /> <br /> <a
			href="javascript:" onclick="history.go(-1);" class="btn">返回上一页</a>
		&nbsp; <a href="javascript:" onclick="$('.errorMessage').toggle();"
			class="btn">查看详细信息</a>
	</div>
	<div class="errorMessage hide">
		<%=StringUtils.toHtml(sb.toString())%>
		<br /> <a href="javascript:" onclick="history.go(-1);" class="btn">返回上一页</a>
		&nbsp; <a href="javascript:" onclick="$('.errorMessage').toggle();"
			class="btn">隐藏详细信息</a> <br /> <br />
	</div>
	<script>
		try 
		{
			top.$.jBox.closeTip();
		} catch (e) {}
	</script>
	</div>
</body>
</html>
<%
   }
   out = pageContext.pushBody();
%>

<!-- 成员变量 -->
<%!String hello = "Hello, World!";%>


<!-- 局部变量 -->
<%
   String hello = "Hello, World!";
%>



<c:set var="counter" value="200"/>
<c:set value="10000" var="maxUser" scope="application"/>

 ${maxUser} 
   ${count} 
   
<c:remove var="maxUser" scope="application"/>

<c:out value="${sessionZhang3}"/><br>
 
<c:if test="${age<18}">
       <h1 align=center>您尚未成年，不能进入游戏中心！</h1>
</c:if>
 
 
 
<c:set var="tax" value="5000" />
<c:choose>
    <c:when test="${tax <=0}">
         您今年没有纳税！
    </c:when>
    <c:when test="${tax<=1000&&tax>0}">
      您今年缴纳的税款为${tax},加油！
    </c:when>
    <c:when test="${tax<=3000&&tax>1000}">
      您今年缴纳的税款为${tax},再接再励哦！
    </c:when>
    <c:otherwise>
      您今年纳税超过了3000元，多谢您为国家的繁荣富强作出了贡献！
    </c:otherwise>
</c:choose>
    
 
<c:forEach items='${header}' var='h'>
      <tr>
        <td><li>Header name:<c:out value="${h.key}"/></li></td>
        <td><li>Header value:<c:out value="${h.value}"/></li></td>
      </tr>
   </c:forEach>

<c:import url="footer.jsp" charEncoding="GBK">
     <c:param name="name" value="Java"/>
</c:import>
    
<c:url var="next" value="next.jsp"/>
<c:redirect url="${next}"/>


<sql:setDataSource   var="ds"  driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/tarena"  user="root" password="11111111" />


<sql:query var="rs" dataSource="${ds}" sql="select * from users" ></sql:query>
 <c:forEach var="user" items="${rs.rows}">
     <tr>
       <td>${user.userid}</td>
       <td>${user.username}</td>
       <td>${user.password}</td>
       <td>${user.role}</td>
     </tr>
 </c:forEach>
   
   
<sql:update dataSource="${ds}" sql="insert into users values(101,'maxwell','123','admin')"  var="i"></sql:update>
    
    
<sql:update dataSource="${ds}" sql="UPDATE users SET username=? WHERE userid=?" var="i">
   <sql:param value="Rod Johnson" /> 
   <sql:param value="100" />        
</sql:update>



 
 
 
 
 
 
 
    
   
   
      
      
      



   
   
   
   




    
    
    








