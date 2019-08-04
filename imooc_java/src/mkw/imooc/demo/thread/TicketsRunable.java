package mkw.imooc.demo.thread;

/**
 * Runnable
 * 2019/07/27
 * imooc:《细说多线程之Thread VS Runnable》
 * 学习笔记
 */
class Mythreads implements Runnable {
    private int ticketsCont = 5; // 一共五张表票
    //volatile int ticketsCont = 5;

    @Override
    public void run() {
        while (ticketsCont > 0) {
            ticketsCont --; // 如果还有票就卖掉一张
            System.out.println(Thread.currentThread().getName() + "卖了1张票，剩余票数为："+ ticketsCont);
        }
    }
}

public class TicketsRunable {
    public static void main(String[] args) {
        Mythreads mt = new Mythreads();
        Thread th1 = new Thread(mt, "窗口1");
        Thread th2 = new Thread(mt, "窗口2");
        Thread th3 = new Thread(mt, "窗口3");

        th1.start();
        th2.start();
        th3.start();
    }
}
