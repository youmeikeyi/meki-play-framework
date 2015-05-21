package com.meki.play.framework.design.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有需要被访问的对象结构
 * 包装一层
 * Created by xujinchao on 2015/5/21.
 */
public class ObjectStructure {

    private List<Person> elements = new ArrayList<Person>();

    public List<Person> attach(Person person) {
        this.elements.add(person);
        return elements;
    }

    public List<Person> detach(Person person) {
        this.elements.remove(person);
        return elements;
    }

    public void display(Action visitor) {
        for (Person person : elements) {
            person.accept(visitor);
        }
    }
}
