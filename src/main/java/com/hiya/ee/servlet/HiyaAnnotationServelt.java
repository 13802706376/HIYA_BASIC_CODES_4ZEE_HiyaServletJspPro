package com.hiya.ee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HiyaAnnotationServelt", description="注解",urlPatterns = {"/hiyaAnnotationServelt","/hiyaServelt"})
public class HiyaAnnotationServelt extends HttpServlet
{
    private static final long serialVersionUID = 143434L;

    /**
     * key=value&
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        ServletInputStream ris = req.getInputStream();
       // ris.readLine(b, off, len)
        
        ServletConfig servletConfig = getServletConfig();
        String username = servletConfig.getInitParameter("username");
        String password = servletConfig.getInitParameter("password");
        
        ServletContext servletContext = getServletContext();
        String paramValue = servletContext.getInitParameter("AAA");
        
        String page = req.getParameter("page");// 10
        String size = req.getParameter("size");// 20
        String msg = "我想大声告诉你"+page+size;
        
        req.setAttribute("333", "444");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        
        
        
        //定义一个名为username，值为Tom的cookie
        Cookie cookie = new Cookie("jeesite.session.id", req.getSession().getId());
        //指定客户端返回的cookie路径
        cookie.setPath("");
        cookie.setComment("This is an Cookie");
       // resp.addCookie(cookie);
        
        writer.write(
                "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n" + "    <title>Title</title>\n"
                        + "</head>\n" + "<body>\n" + "<p>" + msg + "</p>\n" + "</body>\n" + "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doDelete(req, resp);
    }
}