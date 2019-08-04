package mkw.imooc.demo.enums;


public class EnumIndexTest {
    enum Constants2{
        Constants_A,
        Constants_B,
        Constants_C
    }
    public static void main(String[] args) {
        for(int i=0; i< Constants2.values().length;i++){
            System.out.println(Constants2.values()[i]+"在枚举类中位置"+
            Constants2.values()[i].ordinal());
        }
    }
}
