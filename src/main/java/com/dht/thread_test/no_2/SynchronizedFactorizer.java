package com.dht.thread_test.no_2;

import com.dht.thread_test.annotation.GuardedBy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

/**
 * @author dht
 * @create 2019-02-26 14:40
 * <p>
 * 这个Servlet能正确的缓存最新的计算结果，但并发性却非常糟糕（不要这么做）
 * <p>
 * 虽然是线程安全的，但是同一时间只能由一个线程执行该方法，并发性能太差
 **/
public class SynchronizedFactorizer extends HttpServlet {

    @GuardedBy(lock = "this")
    private BigInteger lastNumber;
    @GuardedBy(lock = "this")
    private BigInteger lastFactors;


    @Override
    protected synchronized void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigInteger number = new BigInteger(req.getParameter("number"));

        if (number.equals(lastNumber)) {
            // doSomething();
        } else {
            // doSomething();
            BigInteger result = new BigInteger("110");
            lastNumber = number;
            lastFactors = result;
        }
    }
}
