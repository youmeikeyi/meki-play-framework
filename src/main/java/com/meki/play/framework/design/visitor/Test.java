package com.meki.play.framework.design.visitor;

/**
 * Created by xujinchao on 2015/5/21.
 */
public class Test {

    public static void main(String[] args){
//        Man  xx = new Man();
//        xx.accept(new Success());

        ObjectStructure structure = new ObjectStructure();
        Woman woman = new Woman();
        structure.attach(woman);
        structure.attach(new Man());
//        structure.detach(woman);
        structure.display(new Success());

    }
}
