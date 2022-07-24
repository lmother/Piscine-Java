package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private Integer userId;
    private String login;
    private String pass;
    private List<Chatroom> listRooms;
    private List<Chatroom> listWhereSocialized;


    public User(Integer userId, String login, String pass, List<Chatroom> listRooms, List<Chatroom> listWhereSocialized) {
        this.userId = userId;
        this.login = login;
        this.pass = pass;
        this.listRooms = listRooms;
        this.listWhereSocialized = listWhereSocialized;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId)
                && Objects.equals(login, user.login)
                && Objects.equals(pass, user.pass)
                && Objects.equals(listRooms, user.listRooms)
                && Objects.equals(listWhereSocialized, user.listWhereSocialized);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, pass, listRooms, listWhereSocialized);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", listRooms=" + listRooms +
                ", listWhereSocialized=" + listWhereSocialized +
                '}';
    }
}
