package mkw.imooc.demo.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class AnyClass {
    public static void main(String[] args) {
        // 定义ArrayList 容器
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);

        for(int i = 0; i<a.size(); i++) {
            System.out.println("获取ArrayList 容器的值：" + a.get(i));

        }

        //定义HashMap容器，设置容器的键名，键值类型
        Map<Integer, String> m = new HashMap<Integer, String>();
        for(int i=0; i<5; i++){
            System.out.println("获取Map容器的值" + m.get(i));

        }

        //定义Vector容器，使容器的内容为String
        Vector<String> v = new Vector<String>();

        for(int i = 0; i<5; i++){
            v.addElement("成员"+i);
        }
        for(int i=0; i<v.size(); i++){
            System.out.println("获取Vector容器的值："+ v.get(i));
        }

    }
}
