package day02.ex00;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String readLine = "/Users/lmother/IdeaProjects/ex00/src/day02/ex00/signatures.txt";
        StringBuilder myStr = new StringBuilder();

        try {
            FileInputStream file = new FileInputStream(readLine);
            while (file.available() > 0) {
                char c = (char)file.read();
                if (c == '\n'){
                    String [] tmp = myStr.toString().split(",");
                    if (tmp.length > 1)
                        map.put(tmp[0], tmp[1].trim());
                    myStr.delete(0, myStr.length());
                    continue;
                }
                myStr.append(c);
            }
            String [] tmp = myStr.toString().split(",");
            if (tmp.length > 1)
                map.put(tmp[0], tmp[1].trim());
            myStr.delete(0, myStr.length());

            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.printf("%s, %s bit: %d\n", entry.getKey(), entry.getValue(), entry.getValue().length());
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream readFile = new FileInputStream("/Users/lmother/Desktop/testfiles/gif.gif");
            for (int i = 0; i < 8; i++) {
                myStr.append(String.format("%02X ", readFile.read()));
            }
            System.out.println(myStr);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int sizeBits = entry.getValue().length();
                System.out.println(myStr.indexOf(entry.getValue()));
                if (myStr.toString().startsWith(entry.getValue()))
                    System.out.println(entry.getKey());
            }
            readFile.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }



    }
}
