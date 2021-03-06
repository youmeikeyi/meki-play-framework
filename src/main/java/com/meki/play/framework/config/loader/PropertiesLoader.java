package com.meki.play.framework.config.loader;

import com.meki.play.framework.config.Configuration;

import java.util.List;

/**
 * 配置加载器接口
 * User: jinchao.xu
 * Date: 14-10-10
 * Time: 下午4:20
 */
public interface PropertiesLoader<T extends Configuration> {
    List<T> loadPropertiesConfiguration();
}
