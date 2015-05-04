package com.meki.play.framework.jmx;

/**
 * Created by xujinchao on 2015/5/4.
 */
public class SystemConfig implements SystemConfigMBean {

    private int threadCount;
    private String schemaName;

    public SystemConfig(int numOfThreads, String schemaName){
        this.threadCount = numOfThreads;
        this.schemaName = schemaName;
    }

    @Override
    public void setThreadCount(int numOfThreads) {
        this.threadCount = numOfThreads;
    }

    @Override
    public int getThreadCount() {
        return this.threadCount;
    }

    @Override
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    @Override
    public String getSchemaName() {
        return this.schemaName;
    }

    @Override
    public String doConfig() {
        return "Num of Threads=" + this.threadCount + ", schemaName=" + this.schemaName;
    }
}
