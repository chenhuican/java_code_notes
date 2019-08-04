package mkw.imooc.demo.enums;

import java.util.*;

/**
 * 泛型的高级用法：包括限制泛型可用类型和使用泛型通配符等。
 * 1.限制泛型类型的语法
 *    class 类名称<T extends anyClass>
 *   其中 anyClass 指某个接口和类
 *
 * 2. 使用泛型通配符的语法
 *   泛型类名称<? extends List> a = null
 *
 *  其中，<? extends List >表示类型未知， 当需要使用该泛型对象时，可以单独实例化
 */
public class LimitClass<T extends List> {
    //限制泛型的类型
    LimitClass<ArrayList> l1 = new LimitClass<ArrayList>();
    LimitClass<LinkedList> l2 = new LimitClass<LinkedList>();

    //下面这句是错误的，因为HashMap没有实现List()接口
//    LimitClass<HashMap> l3 =new LimitClass<HashMap>();

    private List<? extends Map> datas = null;

    private List<? super HashMap> datas2 = null;
}
