package com.meki.play.framework.design.bean;

/**
 * Created by user on 2015/4/10.
 */
public class User {

    private int id;
    private String name;
    private String pwd;
    private String sex;

    public User(){
    }

    //just test
    private User(String name){
        this.name = name;
    }

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //more test
    public void sayHello(){
        System.out.println("Hello!~");
    }

    public int sayHello(String who){
        System.out.println("Hello!~" + who);
        return 1;
    }
}
