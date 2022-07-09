package day01.ex01;

public class UserIdsGenerator {
    private static Integer id = 1;
    private static UserIdsGenerator instance;

    public static synchronized UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
    public int generatedId() {
        return id++;
    }
}
