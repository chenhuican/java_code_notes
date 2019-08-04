package mkw.imooc.demo.daemon;

/**
 * 2019/07/28
 * -- 可见性分析
 * 导致共享变量在线程间不可见的原因：
 * 1. 线程交叉执行
 * 2. 重排序结合线程交叉执行
 * 3. 共享变量更新后的值没有在工作内存主与主内存及时更新
 *
 * synchronized
 *
 * volatile适用场合
 * 1. 对变量的写入操作不依赖当前值
 *    1) 不满足： number ++、 count = count *5
 *    2) 满足：boolean变量，记录温度变化的变量等
 *
 * 2. 该变量没有包含在具有其他变量的不变式中
 *    1) 不满足：不变式 low < up
 */

public class SynchronizedDemo {
    // 共享变量
    private boolean ready = false;
    private int result = 0;
    private int number = 1;

    // 写操作
    public void write() {
        ready = true;
        number = 2;
    }

    //读操作
    public void read() {
        if(ready) {
            result = number*3;
        }
        System.out.println("result的值为：" + result);
    }

    //内部线程类
    private class ReadWriteThread extends Thread{
        private boolean flag;
        public ReadWriteThread(boolean flag){
            this.flag = flag;
        }

        @Override
        public void run() {
            if(flag){
                // 构造方法中传入true,执行写操作
                write();
            }else{
                read();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo synDemo = new SynchronizedDemo();

        //启动线程执行写操作
        synDemo.new ReadWriteThread(true).start();


        //启动线程执行读操作
        synDemo.new ReadWriteThread(false).start();

    }
}
