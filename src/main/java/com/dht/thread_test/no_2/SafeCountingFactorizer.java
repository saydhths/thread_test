package com.dht.thread_test.no_2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dht
 * @create 2019-02-25 22:54
 * <p>
 * 使用原子类保证该类线程安全
 **/
public class SafeCountingFactorizer extends HttpServlet {

    // 使用原子类
    private final AtomicInteger count = new AtomicInteger();


    public AtomicInteger getCount() {
        return count;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        // doSomething();
        count.incrementAndGet();
    }
}
