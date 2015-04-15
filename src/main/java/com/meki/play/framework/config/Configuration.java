package com.meki.play.framework.config;

import java.util.Map;
import java.util.Properties;

/**
 * 单个配置的接口
 * User: jinchao.xu
 * Date: 14-10-10
 * Time: 下午2:54
 */
public interface Configuration {

    Integer getInt(String key);

    String getString(String key);

    Properties toProperties();

    Map<String, String> toMap();
}
