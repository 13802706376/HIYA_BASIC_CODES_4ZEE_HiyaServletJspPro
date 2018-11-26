<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>  
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp"   isErrorPage="true" %>
<%@include file="foot.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>500</title>
</head>
<body>
	

	
	
	${-168.18}
	
	
	 ${9.3 div 3}
	 
	 
	 ${9.3/3} 
	 
	   ${"Hello"+",Tarena!"} 
	   
	   
	    int dividend = 0;  
        int divisor = 0;  
        int result = 0;  
        try {  
            dividend = Integer.parseInt(request.getParameter("value1"));  
        } catch (NumberFormatException nfex) {  
            throw new NumberFormatException("被除数不是整数! ");  
        }  
        try {  
            divisor = Integer.parseInt(request.getParameter("value2"));  
        } catch (NumberFormatException nfex) {  
            throw new NumberFormatException("除数不是整数! ");  
        }   
        result = dividend / divisor;  
        out.println(dividend + " / " + divisor + " = " + result);  
	   
	   
	  <%  
	  
	  
	  
	  

	  
	  try{
	  
	  pageContext.getAttribute("name");
	  request.getCookies();
	  session.getId();
	  application.getContextPath();
	  page.notify();
	  response.getWriter().write("rrrr");
	  out.write("3534");
	  exception.getMessage();
	  
	  config.getInitParameter("fggg");
	  
	  }
	  catch()
	  {
	      
	  }
	  
	  %>
	
	
	
	   <%  pageContext.setAttribute("name", "page");
        request.setAttribute("name", "request");
        session.setAttribute("name", "session"); 
        application.setAttribute("name", "application"); %>
  
      <!--  pageContext -> request -> session->application  -->
      ${name}    
      ${pageScope.name}
      ${requestScope.name}
      ${sessionScope.name}
      ${applicationScope.name}
      
      
    <jsp:forward page="another.jsp"/>
      
    <jsp:include  page="b.jsp" flush="true">
             <jsp:param name="name" value="narci"/>
    </jsp:include> 
    
     <jsp:useBean id=”变量名” scope=”page|request|session|application” class=”完整类名” type=”数据类型”  beanName=””/>
     <jsp:setProperty name=”实例名” property=”*”|property=”属性名”|property=”属性名” param=”参数名”|property=”属性名” value=”值” />
     <jsp:getProperty name=”实例名” property=”属性名” />
      
    <!--  jsp：plugin 指令（不常用）用于下载服务器端的javaBean或Applet到客户端执行。  --> 
      
</body>
</html>

      