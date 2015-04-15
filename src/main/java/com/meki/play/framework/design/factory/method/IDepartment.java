package com.meki.play.framework.design.factory.method;

import com.meki.play.framework.design.bean.Department;

/**
 * 每次新加产品，都需要在工厂增加接口，对应地修改所有子工厂
 * Created by user on 2015/4/15.
 */
public interface IDepartment {

    public void insertDepartment(Department department);

    public Department getDepartment(int id);
}
