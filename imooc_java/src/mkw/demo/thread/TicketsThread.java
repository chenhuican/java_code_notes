package mkw.demo.thread;

class MyThead extends Thread {
    private int ticketsCont = 5; // 一共五张表票
    private String name;

    public MyThead(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (ticketsCont > 0) {
            ticketsCont --; // 如果还有票就卖掉一张
            System.out.println(name + "卖了1张票，剩余票数为："+ ticketsCont);
        }
    }
}

public class TicketsThread {
    public static void main(String[] args) {
        MyThead mt1 = new MyThead("窗口1");
        MyThead mt2 = new MyThead("窗口2");
        MyThead mt3 = new MyThead("窗口3");

        //启动这三个线程，三个窗口开始卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }

}
