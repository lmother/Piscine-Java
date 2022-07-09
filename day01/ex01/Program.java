package day01.ex01;

public class Program {
    public static void main(String[] args) {

        User ben = new User();
        System.out.println(ben.getId());

        User ben1 = new User();
        System.out.println(ben1.getId());

        User ben2 = new User();
        System.out.println(ben2.getId());

        System.out.println(UserIdsGenerator.getInstance().generatedId());
    }
}
