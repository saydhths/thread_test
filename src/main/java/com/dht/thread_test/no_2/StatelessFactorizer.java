package com.dht.thread_test.no_2;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * @author dht
 * @create 2019-02-25 16:39
 * <p>
 * 一个无状态的Servlet
 * <p>
 * 无状态的类：既不包含任何域（属性），也不包含任何对其他域的引用；
 * 无状态的类一定时线程安全的：因为它不存在共享的变量
 **/
public class StatelessFactorizer extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("number");
        // doSomething();
    }
}
