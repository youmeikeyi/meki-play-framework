package com.meki.play.framework.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Created by xujinchao on 2015/5/4.
 */
public class SystemConfigManager {

    private static final int DEFAULT_NUM_OF_THREADS = 10;

    private static final String DEFAULT_SCHEMA_NAME = "default";

    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        SystemConfig mBean = new SystemConfig(DEFAULT_NUM_OF_THREADS, DEFAULT_SCHEMA_NAME);
        ObjectName name = new ObjectName("xman:type=SystemConfig");
        mbs.registerMBean(mBean, name);

        do {
            Thread.sleep(3000);
            System.out.println("Thread Count=" + mBean.getThreadCount() + "::: schemaName=" + mBean.getSchemaName());
        } while (mBean.getThreadCount() != 0);
    }
}
