package com.generics;

/**
 * 2019/07/01 图书馆
 *
 * 泛型可以解决数据类型的安全性问题。
 * 其原理时在类声明时，通过一个标识表示类中的某个属性的类型或者某个方法返回值及参数类型。
 * 这样在类声明或实例化的时候，只要指定好需要的类型即可。
 *
 */
public class GenericsDemo1 {
    public static void main(String[] args) {
        // 泛型对象定义
        // 类名称<具体类> 对象名称 = new 类名称<具体类>();
        Point<Integer> p = new Point<Integer>();
        p.setVar(30);
        System.out.println(p.getVar()*2);

    }
}

class Point<T> {
    private T var;
    public T getVar(){
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}
