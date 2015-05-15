package com.meki.play.framework.jmx.test;

import com.meki.play.framework.jmx.SystemConfig;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xujinchao on 2015/5/5.
 */
public class SystemConfigAgent {

    public static void main(String[] args) throws Exception {

//        MBeanServer server = MBeanServerFactory.createMBeanServer();
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("meki:name=SystemConfig");
        server.registerMBean(new SystemConfig(4, "test"), objectName);

        ObjectName adapterName = new ObjectName("SystemConfigAgent:name=htmladapter,port=8082");
//        HtmlAdaptorServer adaptorServer = new HtmlAdaptorServer();
//        server.registerMBean(adaptorServer, adapterName);
//        adaptorServer.start();
        System.out.println("start......");

        Map<String, String> test = new TreeMap<String, String>();
        test.put("abc", "12");
        test.put("z", "sd");
        test.put("o", "s");
        System.out.println(test);

        for(Map.Entry<String, String> entry: test.entrySet()){
            System.out.println("key:" + entry.getKey() +", value=" + entry.getValue());
        }
        Integer s = 2;
        int l = 2;
        System.out.println(s.equals(l));
    }
}
