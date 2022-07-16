package day02.ex00;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        StringBuilder myStr = new StringBuilder();
        String signaturesPathFile = "/Users/lmother/Desktop/piscine/day02/ex00/signatures.txt";

        FileInputStream readSignFile = null;
        FileInputStream readInputFile = null;
        FileOutputStream writeResult = null;
        Scanner in = new Scanner(System.in);

        try {
            readSignFile = new FileInputStream(signaturesPathFile);
            while (readSignFile.available() > 0) {
                char c = (char)readSignFile.read();
                if (c == '\n'){
                    String [] tmp = myStr.toString().split(",");
                    if (tmp.length > 1)
                        map.put(tmp[0] + "\n", tmp[1].trim());
                    myStr.delete(0, myStr.length());
                    continue;
                }
                myStr.append(c);
            }
            String [] tmp = myStr.toString().split(",");
            if (tmp.length > 1)
                map.put(tmp[0], tmp[1].trim());
            myStr.delete(0, myStr.length());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (readSignFile != null)
            readSignFile.close();

        String inputFileName = in.nextLine();

        while (!inputFileName.equals("42")) {
            try {
                System.out.println("PROCESSED");
                readInputFile = new FileInputStream(inputFileName);
                writeResult = new FileOutputStream("result.txt", true);

                for (int i = 0; i < 10; i++) {
                    if (readInputFile.available() == 0)
                        break;
                    myStr.append(String.format("%02X ", readInputFile.read()));
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (myStr.toString().startsWith(entry.getValue())) {
                        writeResult.write(entry.getKey().getBytes());
                    }
                }
                myStr.delete(0, myStr.length());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            inputFileName = in.nextLine();
        }
        in.close();
        if(writeResult != null)
            writeResult.close();
        if (readInputFile != null)
            readInputFile.close();
    }
}
