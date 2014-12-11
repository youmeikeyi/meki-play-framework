package com.meki.play.framework.databind;

/**
 * User: HaiNan.Wang
 * Date: 14-11-18
 * Time: 下午5:43
 */
public class ThreadLocalDataBind<T> implements DataBind<T> {
    private final ThreadLocal<T> threadLocal = new ThreadLocal<T>();

    @Override
    public void put(T t) {
        this.threadLocal.set(t);
    }

    @Override
    public T get() {
        return this.threadLocal.get();
    }

    @Override
    public void remove() {
        this.threadLocal.remove();
    }
}
