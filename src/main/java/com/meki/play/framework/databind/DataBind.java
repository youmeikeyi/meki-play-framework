package com.meki.play.framework.databind;

/**
 * User: HaiNan.Wang
 * Date: 14-11-18
 * Time: 下午3:01
 */
public interface DataBind<T> {
    void put(T t);

    T get();

    void remove();
}
