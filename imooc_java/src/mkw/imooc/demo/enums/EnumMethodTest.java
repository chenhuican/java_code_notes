package mkw.imooc.demo.enums;

/**
 * 枚举对比compareTo()
 */

public class EnumMethodTest {
    enum Constants2{
        Constants_A,
        Constants_B,
        Constants_C
    }

    public static  void compare(Constants2 c) {
        for(int i=0; i<Constants2.values().length; i++){
            System.out.println(c + "与" + Constants2.values()[i] + "的比较结果为：" +
                    c.compareTo(Constants2.values()[i])
            );
        }
    }
    public static void main(String[] args) {
        compare(Constants2.valueOf("Constants_B"));
    }
}
