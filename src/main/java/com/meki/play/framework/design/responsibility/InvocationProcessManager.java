package com.meki.play.framework.design.responsibility;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 职责链处理 管理类
 * 单例
 * Created by xujinchao on 2015/5/18.
 */
public class InvocationProcessManager {

    public static InvocationProcessManager manager = new InvocationProcessManager();

    public static InvocationProcessManager getInstance() {
        if (manager == null) {
            manager = new InvocationProcessManager();
        }
        return manager;
    }

    public List<InvocationProcessHandler> handlers = new LinkedList<InvocationProcessHandler>();

    public List<InvocationProcessHandler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<InvocationProcessHandler> handlers) {
        this.handlers = handlers;
    }

    public InvocationProcessHandler nextHandler(Iterator<InvocationProcessHandler> iterator) {
        if (iterator.hasNext()) {
            return (InvocationProcessHandler) iterator.next();
        }
        return null;
    }

    /**
     * 装载handler链
     * @param type
     */
    public void deliverHandler(int type) {
        if (type == 0) {
            //第一种方式  利用linklist，不直接设置下一个处理器，需要遍历
            ConcreteInvocationProcessHandler concreteInvocationHandler = new ConcreteInvocationProcessHandler();
            Concrete2InvocationProcessHandler concrete2InvocationHandler = new Concrete2InvocationProcessHandler();
            this.handlers.add(concreteInvocationHandler);
            this.handlers.add(concrete2InvocationHandler);
        } else {
            ConcreteInvocationProcessHandler concreteInvocationHandler = new ConcreteInvocationProcessHandler();
            Concrete2InvocationProcessHandler concrete2InvocationHandler = new Concrete2InvocationProcessHandler();
            DefaultInvocationProcessHandler defaultInvocationProcessHandler = new DefaultInvocationProcessHandler();
            concreteInvocationHandler.setNextHandler(concrete2InvocationHandler);
            concrete2InvocationHandler.setNextHandler(defaultInvocationProcessHandler);
            this.handlers.add(concreteInvocationHandler);
            this.handlers.add(concrete2InvocationHandler);
            this.handlers.add(defaultInvocationProcessHandler);
        }

    }

//    /**
//     * 实际上是无效的
//     * @return
//     */
//    public InvocationProcessHandler next(){
//        Iterator iterator = this.handlers.iterator();
//        if (iterator.hasNext()) {
//            return (InvocationProcessHandler) iterator.next();
//        }
//        return null;
//    }

    public static void main(String[] args){
        InvocationProcessManager instance = InvocationProcessManager.getInstance();
        instance.deliverHandler(0);
        instance.handlers.add(new DefaultInvocationProcessHandler());
        InvocationProcessHandler handler;
        InvocationRequest request = new InvocationRequest();
//        Iterator<InvocationProcessHandler> iterator = instance.getHandlers().iterator();
//        while (iterator.hasNext()){
//            handler = iterator.next();
//            if (handler.canAccept(request)) {
//                handler.process(request);
//                System.out.println(request.getName());
//            }
//        }
        System.out.println(instance.getHandlers());
        //2
        System.out.println("begin");
        instance.handlers.clear();

        instance.deliverHandler(1);
        handler = instance.getHandlers().get(0);

        while (handler != null) {
            handler.process(request);
            System.out.println(request.getName());
            handler = handler.next();
        }

    }
}
