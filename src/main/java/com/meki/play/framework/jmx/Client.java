package com.meki.play.framework.jmx;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * Java代码中的远程连接
 * Created by xujinchao on 2015/5/4.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi:///127.0.0.1:8888/jmxrmi");
        JMXConnector jmxConnector = JMXConnectorFactory.connect(url, null);

        MBeanServerConnection mBeanServerConnection = jmxConnector.getMBeanServerConnection();

        ObjectName mbeanName = new ObjectName("xman:type=SystemConfig");
        SystemConfigMBean mbeanProxy = JMX.newMBeanProxy(mBeanServerConnection, mbeanName, SystemConfigMBean.class, true);

        int threadCount = mbeanProxy.getThreadCount();
        System.out.println("Current ThreadCount: " + threadCount);
        mbeanProxy.setThreadCount(100);
        threadCount = mbeanProxy.getThreadCount();
        System.out.println("Change ThreadCount: " + threadCount);

        Thread.sleep(3);

        jmxConnector.close();
    }
}
