package com.imp.memory;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/25
 */
public class StaticObject {

    private static StaticObject staticObject;

    private int a;
    private int b;


    private  StaticObject() {
    }


    public static StaticObject getInstance(){
        if(staticObject==null){
            staticObject=new StaticObject();
        }
        return staticObject;
    }

    public Integer getA() {
        return a;
    }

    public void setA(int a) {
        this.a += a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(int b) {
        this.b += b;
    }


    @Override
    public String toString() {
        return "StaticObject{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
