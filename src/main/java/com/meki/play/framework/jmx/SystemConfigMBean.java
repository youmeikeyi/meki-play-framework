package com.meki.play.framework.jmx;

/**
 * MBean接口类
 * 必须以MBean结尾
 * Created by xujinchao on 2015/5/4.
 */
public interface SystemConfigMBean {


    /**
     * 可去除，变为只读
     * @param numOfThreads
     */
    public void setThreadCount(int numOfThreads);

    public int getThreadCount();

    public void setSchemaName(String schemaName);

    public String getSchemaName();

    /**
     * using do* for operation.
     * @return
     */
    public String doConfig();
}
