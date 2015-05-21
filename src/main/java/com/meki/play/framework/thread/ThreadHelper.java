package com.meki.play.framework.thread;

/**
 * 守护线程
 * 扩展Java自带Thread
 * Created by user on 2015/5/4.
 */
public class ThreadHelper extends Thread {

    private volatile boolean running = true;
    private boolean idle = true;

    public ThreadHelper(String name){
        super(name);
        this.setDaemon(true);
    }

    public ThreadHelper(String name, boolean isDaemon){
        super(name);
        this.setDaemon(isDaemon);
    }

    public final boolean isRunning(){
        return this.running;
    }

    public final void joinAssuring(){
        while (true){
            try {
                this.join();
                return;
            } catch (Throwable throwable){
                System.out.println(this.getClass().getName() + " shutdown. Ignore ex=" + throwable);
            }
        }
    }

    public void shutdown(){
        this.running = false;
        this.wakeup();
        this.joinAssuring();
    }

    public synchronized void wakeup(){
        this.idle = false;
        this.notify();
    }

    public final synchronized void sleepIdle(long var) {
        try {
            if (this.idle) {
                this.wait(var);
            }
        } catch (InterruptedException ex){
            System.out.println(this.getClass().getName() + " sleepOut. ex=" + ex);
        } finally {
            this.idle = true;
        }

    }

    Runnable cock(){
        return new Runnable() {
            @Override
            public void run() {
                ThreadHelper.this.wakeup();
            }
        };
    }
}
