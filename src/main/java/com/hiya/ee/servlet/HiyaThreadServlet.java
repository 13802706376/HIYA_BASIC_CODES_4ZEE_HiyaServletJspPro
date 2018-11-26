package com.hiya.ee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiyaThreadServlet extends HttpServlet
{
    /**
     * 
     */
    private static final long serialVersionUID = 75671L;
    /*
     * 把i定义成全局变量，当多个线程并发访问变量i时，就会存在线程安全问题了，如下图所示：同时开启两个浏览器模拟并发访问同一个Servlet，
     * 本来正常来说，第一个浏览器应该看到2，而第二个浏览器应该看到3的，结果两个浏览器都看到了3，这就不正常。
     * 
     */
    int j=1;
    
    /**
     * 线程不安全
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /*
         * 当多线程并发访问这个方法里面的代码时，会存在线程安全问题吗 i变量被多个线程并发访问，但是没有线程安全问题，因为i是doGet方法里面的局部变量，
         * 当有多个线程并发访问doGet方法时，每一个线程里面都有自己的i变量， 各个线程操作的都是自己的i变量，所以不存在线程安全问题
         * 多线程并发访问某一个方法的时候，如果在方法内部定义了一些资源(变量，集合等) 那么每一个线程都有这些东西，所以就不存在线程安全问题了
         */
        int i = 1;
        i++;
        response.getWriter().write(i);
        
        j++;
        response.getWriter().write(j);
    }

    /**
     * 线程安全 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /**
          * 加了synchronized后，并发访问i时就不存在线程安全问题了，
          * 为什么加了synchronized后就没有线程安全问题了呢？
          * 假如现在有一个线程访问Servlet对象，那么它就先拿到了Servlet对象的那把锁
          * 等到它执行完之后才会把锁还给Servlet对象，由于是它先拿到了Servlet对象的那把锁，
          * 所以当有别的线程来访问这个Servlet对象时，由于锁已经被之前的线程拿走了，后面的线程只能排队等候了
          */
           synchronized (this) 
           {    //在java中，每一个对象都有一把锁，这里的this指的就是Servlet对象             i++;
                 try 
                 {
                     Thread.sleep(1000*4);
                 } catch (InterruptedException e) 
                 {
                     e.printStackTrace();
                 }
                 response.getWriter().write(j+"");
         }
     }
}
