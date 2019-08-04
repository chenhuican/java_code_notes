package mkw.imooc.demo.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件输入/输出流
 * FileOutputStream, FileInputStream
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("D:\\IdeaProjects\\imooc_java\\Resources\\word.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte buy[] = "程序运行期间，大部分数据都在内存中".getBytes();
            out.write(buy);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream in = new FileInputStream(file);
            byte byt[] = new byte[1024];
            int len = in.read(byt);
            System.out.println("文件的信息是：" + new String(byt, 0, len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
