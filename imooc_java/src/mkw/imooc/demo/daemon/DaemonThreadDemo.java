package mkw.imooc.demo.daemon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * 守护线程讲解
 */
class DaemonThread implements Runnable {
    @Override
    public void run() {
        System.out.println("进入守护线程 " + Thread.currentThread().getName());
        try {
            writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("退出守护线程" + Thread.currentThread().getName());
    }

    private void writeToFile() throws Exception {
        File filename = new File("D:" + File.separator + "daemon.txt");
        OutputStream os = new FileOutputStream(filename, true);
        int count = 0;
        while (count <999) {
            os.write(("\r\nword .." + count).getBytes());
            count --;
            System.out.println("守护线程" + Thread.currentThread().getName() + "向文件中写入word");
            Thread.sleep(1000);
        }
    }
}
public class DaemonThreadDemo {
    public static void main(String[] args) {
        System.out.println("进入主线程" + Thread.currentThread().getName());

        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread);
        thread.setDaemon(true);
        thread.start();

        //从终端获取输入,退出主线程，守护线程也就退出了
        Scanner sc = new Scanner(System.in);
        sc.next();

        System.out.println("退出主线程" + Thread.currentThread().getName());
    }

}
