package day02.ex01;

public class StartProgram {

    public static void main(String[] args) throws Exception {
        if (args.length != 2)
            throw new Exception("Error. Number of arguments should be two!!!");
        Program program = new Program(args[0] , args[1]);

        System.out.printf("Similarity = %s\n", program.getSimilarity());
    }
}