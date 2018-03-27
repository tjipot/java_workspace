package factory.ioCollection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileStreamTest_2 {

    public static void main(String[] args) throws IOException {

        File file = new File("FileStreamTest_2.txt");
        FileOutputStream fop = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        writer.append("这里是中文输入");
        writer.append("\r\n");
        writer.append("English");
        writer.close();
        fop.close();

        FileInputStream fip = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        System.out.println(sb.toString());
        reader.close();
        fip.close();

    }

}
