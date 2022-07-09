package day01.ex04;

interface UsersList {
    void addUser(User user);
    User getUserById(Integer id) throws Exception;
    User getUserByIndex(Integer index) throws UsersArrayList.UserNotFoundException;
    Integer getNumberOfUsers();
}
