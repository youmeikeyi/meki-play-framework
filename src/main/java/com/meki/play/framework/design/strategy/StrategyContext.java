package com.meki.play.framework.design.strategy;

/**
 * Created by user on 2015/4/10.
 */
public class StrategyContext {

    private AbstractStrategy strategy;

    public StrategyContext(AbstractStrategy strategy){
        this.strategy = strategy;
    }

    public StrategyContext(int type){
        switch (type){
            case 1:
                break;
            case 2:
                this.strategy = new ConcreteStrategy();
                break;
            default:
        }
    }

    public void contextInterface(){
        this.strategy.accept();
    }

    //client
    public static void main(String[] args){
        StrategyContext context = new StrategyContext(2);
        context.contextInterface();
    }
}
