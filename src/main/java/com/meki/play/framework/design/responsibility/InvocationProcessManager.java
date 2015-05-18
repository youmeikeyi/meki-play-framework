package com.meki.play.framework.design.responsibility;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
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
            ConcreteInvocationProcessHandler concreteInvocationHandler = new ConcreteInvocationProcessHandler();
            Concrete2InvocationProcessHandler concrete2InvocationHandler = new Concrete2InvocationProcessHandler();
            this.handlers.add(concreteInvocationHandler);
            this.handlers.add(concrete2InvocationHandler);
        }
    }

    public InvocationProcessHandler next(){
        Iterator iterator = this.handlers.iterator();
        if (iterator.hasNext()) {
            return (InvocationProcessHandler) iterator.next();
        }
        return null;
    }

    public static void main(String[] args){
        InvocationProcessManager instance = InvocationProcessManager.getInstance();
        instance.deliverHandler(0);

        InvocationProcessHandler handler;
        InvocationRequest request = new InvocationRequest();
        Iterator<InvocationProcessHandler> iterator = instance.getHandlers().iterator();
        while (iterator.hasNext()){
            handler = iterator.next();
            if (handler.canAccept(request)) {
                handler.process(request);
                System.out.println(request.getName());
            }
        }


    }
}
