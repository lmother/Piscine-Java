package day01.ex02;

public class UsersArrayList implements UsersList{
    private static final int DEFAULT_SIZE = 10;
    private User [] arrUsers;
    private Integer index;
    private Integer size;

    public UsersArrayList(){
        arrUsers = new User[DEFAULT_SIZE];
        index = 0;
        size = DEFAULT_SIZE;
    }

    @Override
    public void addUser(User user) {
        if (index < size) {
            arrUsers[index] = user;
            index++;
        }
        else {
            arrUsers = resizeUserArray();
            arrUsers[index] = user;
            index++;
        }
    }

    @Override
    public User getUserById(Integer id) throws UserNotFoundException{
        for (User user : arrUsers) {
            if (user.getId().equals(id))
                return user;
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByIndex(Integer index) throws UserNotFoundException {
        if (index >= 0 || index < size)
            return arrUsers[index];
        throw new UserNotFoundException();
    }

    @Override
    public Integer getNumberOfUsers() {
        return index;
    }

    private User [] resizeUserArray() {
        size += size / 2;
        index = 0;
        User[] tmp = new User[size];
        for (User user : arrUsers) {
            tmp[index] = user;
            index++;
        }
        return tmp;
    }

    class UserNotFoundException extends Exception { }
}
