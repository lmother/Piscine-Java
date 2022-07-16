package day02.ex01;

import java.io.*;
import java.util.*;

public class Program {
    private final ArrayList<String> listA;
    private final ArrayList<String> listB;
    private Map<String, Integer> dict;
    private final Vector <Integer> vectorA;
    private final Vector <Integer> vectorB;

    public Program(String fileNameA, String fileNameB){
        listA = readFile(fileNameA);
        listB = readFile(fileNameB);
        dict = listsToMap(listA, listB);
        vectorA = createVector(listA);
        vectorB = createVector(listB);
        writeMapToFile();
    }


    private ArrayList<String> readFile(String fileName){
        ArrayList <String> tmp = new ArrayList<>();
        String line;

        try(BufferedReader reedFile = new BufferedReader(new FileReader(fileName))){
            line = reedFile.readLine();
            while (line != null){
                tmp.addAll(Arrays.asList(line.split(" ")));
                line  = reedFile.readLine();
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        return tmp;
    }

    private TreeMap<String, Integer> listsToMap(ArrayList<String> listA, ArrayList<String> listB){
        ArrayList<String> all = new ArrayList<>(listA);
        dict = new TreeMap<>();

        all.addAll(listB);
        for(String str : all) {
            dict.put(str, 0);
        }
        return (TreeMap<String, Integer>) dict;
    }

    private void writeMapToFile(){
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, Integer> entry : dict.entrySet()){
            str.append(entry.getKey()).append(" ");
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.txt"))){
            writer.write(str.toString());
        }catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }

    private Vector<Integer> createVector(ArrayList<String> list){
        Vector<Integer> tmp = new Vector<>(dict.size());

        for (Map.Entry<String, Integer> entry : dict.entrySet()){
            for (String str : list){
                if(entry.getKey().equals(str)) {
                    dict.replace(entry.getKey(), entry.getValue(), entry.getValue() + 1);
                }
            }
            tmp.add(entry.getValue());
            dict.replace(entry.getKey(), entry.getValue(), 0);
        }
        return tmp;
    }

    public String getSimilarity(){
        double numerator = 0;
        double sqrA = 0;
        double sqrB = 0;
        double denominator = 0;
        String res;

        for (int i = 0; i < vectorA.size(); i++){
            numerator = vectorA.get(i) * vectorB.get(i) + numerator;
            sqrA = vectorA.get(i) * vectorA.get(i) + sqrA;
            sqrB = vectorB.get(i) * vectorB.get(i) + sqrB;
        }
        denominator = Math.sqrt(sqrA) * Math.sqrt(sqrB);
        res = String.format("%.3f", numerator / denominator);
        return res.substring(0, res.length() - 1);
    }

    public ArrayList<String> getListA(){
        return listA;
    }

    public ArrayList<String> getListB(){
        return listB;
    }

    public Map<String, Integer> getDict(){
        return dict;
    }

    public Vector<Integer> getVectorA() {
        return vectorA;
    }

    public Vector<Integer> getVectorB() {
        return vectorB;
    }
}
