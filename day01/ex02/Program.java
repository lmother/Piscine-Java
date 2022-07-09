package day01.ex02;

public class Program {
    public static void main(String[] args) throws UsersArrayList.UserNotFoundException {
        UsersArrayList list = new UsersArrayList();

        for (int i = 0; i < 15; i++) {
            list.addUser(new User("Test", 300));
        }

        System.out.printf("Number of users :%d\n", list.getNumberOfUsers());
        System.out.printf("Retrieve a user by index :%d\n", list.getUserByIndex(0).getId());
        System.out.printf("Retrieve a user by ID :%d\n", list.getUserById(5).getId());

        try{
            list.getUserById(45);
        }
        catch (Exception exception){
            System.out.println("Error. No user ID!!!");
        }

        try{
            list.getUserByIndex(200);
        }
        catch (Exception exception){
            System.out.println("Error. No user with this index");
        }

    }
}
