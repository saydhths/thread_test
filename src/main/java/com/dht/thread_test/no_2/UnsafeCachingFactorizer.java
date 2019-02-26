package com.dht.thread_test.no_2;

import com.dht.thread_test.annotation.NotThreadSafe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author dht
 * @create 2019-02-25 23:01
 * <p>
 * 该Servlet在没有足够原子性保证的情况下对其最近计算结果进行缓存（不要这么做）
 * <p>
 * 存在竞态条件：对number的判断
 * <p>
 * 要保持状态的一致性，就需要在单个原子操作中更新所有的相关状态变量
 * <p>
 * 不变性条件
 **/

@NotThreadSafe
public class UnsafeCachingFactorizer extends HttpServlet {
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference();

    private final AtomicReference<BigInteger> lastFactors = new AtomicReference();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigInteger number = new BigInteger(req.getParameter("number"));
        if (number.equals(lastNumber.get())) {
            // doSomething();
        } else {
            // doSomething();
            lastNumber.set(number);
            // result 当为number的操作结果
            BigInteger result = new BigInteger("11000");
            lastFactors.set(result);
        }
    }
}
