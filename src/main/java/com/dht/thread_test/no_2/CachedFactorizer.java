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
 * @create 2019-02-26 14:58
 * <p>
 * <p>
 * 缓存最近执行因数分解的数值及其计算结果的Servlet
 * <p>
 * 当执行时间较长的计算或者可能无法快速完成的操作，一定不要持有锁
 **/
public class CachedFactorizer extends HttpServlet {

    @GuardedBy(lock = "this")
    private BigInteger lastNumber;
    @GuardedBy(lock = "this")
    private BigInteger[] lastFactors;
    @GuardedBy(lock = "this")
    private long hits;
    @GuardedBy(lock = "this")
    private long chcheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getChcheHitRatio() {
        return chcheHits / hits;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigInteger number = new BigInteger(req.getParameter("number"));
        BigInteger[] factors = null;
        synchronized (this) {
            hits++;
            if (number.equals(lastNumber)) {
                chcheHits++;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            // doSomething();
            factors = new BigInteger[1];
            synchronized (this) {
                lastNumber = number;
                lastFactors = factors;
            }
        }
    }
}
