package day02.ex00;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        StringBuilder myStr = new StringBuilder();
        String signaturesPathFile = "signatures.txt";
        String testFile = "/";

        FileInputStream readSignFile = null;
        FileInputStream readInputFile = null;
        FileOutputStream writeResult  = null;
        String inputFile = null;

        while (!inputFile.equals("42")){
            inputFile = new Scanner(System.in).nextLine();
        }

        try {
            readSignFile = new FileInputStream(signaturesPathFile);
            while (readSignFile.available() > 0) {
                char c = (char)readSignFile.read();
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readInputFile = new FileInputStream(inputFile);
            for (int i = 0; i < 10; i++) {
                if(readInputFile.available() == 0)
                    break;
                myStr.append(String.format("%02X ", readInputFile.read()));
            }
            System.out.println(myStr);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (myStr.toString().startsWith(entry.getValue())) {
                    writeResult = new FileOutputStream("result.txt", true);
                    writeResult.write(entry.getKey().getBytes(StandardCharsets.UTF_8));
                    System.out.println(entry.getKey());
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        try {
            if (readSignFile != null)
                readSignFile.close();
            if (readInputFile != null)
                readInputFile.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
