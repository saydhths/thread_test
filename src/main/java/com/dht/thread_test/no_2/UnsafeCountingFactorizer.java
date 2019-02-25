package com.dht.thread_test.no_2;

import com.dht.thread_test.annotation.NotThreadSafe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dht
 * @create 2019-02-25 22:40
 * <p>
 * 在没有同步的情况下统计已处理请求数量的Servlet（不要这么做）
 * <p>
 * (先检查后执行)实际包含三个独立的操作：读取（读取count的值）——操作（count++）——写入（将计算出的新值赋值给count）
 * <p>
 * 要想它为线程安全的则需要保证“先检查后操作”为原子性操作，即不可分割操作；
 **/
@NotThreadSafe
public class UnsafeCountingFactorizer extends HttpServlet {
    private long count = 0;

    public long getCount() {
        return count;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        // doSomething();
        count++;
    }
}
