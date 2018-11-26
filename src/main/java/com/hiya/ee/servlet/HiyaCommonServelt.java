package com.hiya.ee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet开发基本步骤 1>写一个类继承HttpServlet 2>重写doGet或者doPost 方法 3>在web.xml中注册
 * 注册Servlet 4>发布应用
 */
public class HiyaCommonServelt extends HttpServlet
{
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
        String msg = "我想大声告诉你" + page + size;

        req.setAttribute("333", "444");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(
                "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n" + "    <title>Title</title>\n"
                        + "</head>\n" + "<body>\n" + "<p>" + msg + "</p>\n" + "</body>\n" + "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        if (username != null && !username.equals(""))
        {
            req.getSession().setAttribute("username", username);
        }
        List<String> online = (List<String>) getServletContext().getAttribute("online");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>用户列表</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("当前用户是：" + username);
        out.println("<hr/><h3>在线用户列表</h3>");

        int size = online == null ? 0 : online.size();
        for (int i = 0; i < size; i++)
        {
            if (i > 0)
            {
                out.println("<br/>");
            }
            out.println(i + 1 + "." + online.get(i));
        }

        // 注意，此处对链接URL进行重写
        out.println("<hr/><a href=\"" + resp.encodeRedirectURL("logout") + "\">注销</a>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
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