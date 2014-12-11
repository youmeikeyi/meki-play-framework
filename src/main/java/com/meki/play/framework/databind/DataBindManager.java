package com.meki.play.framework.databind;

import java.util.concurrent.ConcurrentHashMap;

/**
 * User: HaiNan.Wang
 * Date: 14-11-18
 * Time: 下午5:42
 */
public class DataBindManager {
    private static final DataBindManager instance = new DataBindManager();

    private final ConcurrentHashMap<Enum, DataBind> map = new ConcurrentHashMap<Enum, DataBind>();

    private DataBindManager() {
    }

    public static DataBindManager getInstance() {
        return instance;
    }

    public <T> DataBind<T> getDataBind(Enum bingType) {
        DataBind<T> dataBind = map.get(bingType);
        if (dataBind == null) {
            DataBind bind = new ThreadLocalDataBind();
            dataBind = map.putIfAbsent(bingType, bind);
            if (dataBind == null) {
                dataBind = bind;
            }
        }
        return dataBind;
    }
}
