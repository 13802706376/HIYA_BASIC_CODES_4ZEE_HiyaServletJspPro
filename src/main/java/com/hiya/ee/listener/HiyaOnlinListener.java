package com.hiya.ee.listener;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HiyaOnlinListener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener
{
    private ServletContext application = null;

    //session属性新增 事件[uesrname]
    public void attributeAdded(HttpSessionBindingEvent arg0)
    {
        if ("uesrname".equals(arg0.getName()))
        {
            List<String> online = (List<String>) this.application.getAttribute("online");
            online.add((String) arg0.getValue());
            this.application.setAttribute("online", online);
        }
    }

    // session属性删除 事件
    public void attributeRemoved(HttpSessionBindingEvent arg0)
    {
    }

    //session属性被替换 事件
    public void attributeReplaced(HttpSessionBindingEvent arg0)
    {
    }

    // session创建时的回调方法
    public void sessionCreated(HttpSessionEvent arg0)
    {
    }

    // session销毁时的回调方法
    public void sessionDestroyed(HttpSessionEvent arg0)
    {
       List<String> online=(List<String>)this.application.getAttribute("online");
       String username=(String)arg0.getSession().getAttribute("username");
       online.remove(username);
       this.application.setAttribute("online",online);
    }

    //上下文销毁
    public void contextDestroyed(ServletContextEvent arg0)
    {
    }

     //上下文初始化
    public void contextInitialized(ServletContextEvent arg0)
    {
        this.application = arg0.getServletContext();
        this.application.setAttribute("online", new LinkedList<String>());
    }
}