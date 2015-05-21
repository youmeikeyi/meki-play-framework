package com.meki.play.framework.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 消息线程
 * 这里处理的对象为Runable或Thread, 实际应用可替换其他对象
 * Created by xujinchao on 2015/5/19.
 */
public class MessageThread extends ThreadHelper {

    private static Logger LOGGER = LoggerFactory.getLogger(MessageThread.class);

    public static String THREAD_NAME = "MessageThread";

    private static MessageThread instance;
    private final BlockingDeque<Thread> threads = new LinkedBlockingDeque<Thread>();

    public static synchronized MessageThread getInstance() {
        if (null == instance) {
            instance = new MessageThread(THREAD_NAME);
        }
        return instance;
    }

    public MessageThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (isRunning() || !threads.isEmpty()) {
            try {
                Thread thread = threads.poll(5, TimeUnit.SECONDS);
                if (thread != null) {
                    thread.run();
                }
            } catch (Exception e) {
                LOGGER.error("" + e.getMessage(), e);
            }

        }
        super.run();
    }

    public boolean add(Thread thread) {
        return threads.add(thread);
    }

    public void clear() {
        threads.clear();
    }

    /**
     * 区分类型
     * @param thread
     * @return
     */
    public boolean tryAdd(Thread thread) {
        if (thread instanceof Runnable) {
            add(thread);
            return true;
        }
        return false;
    }
}
