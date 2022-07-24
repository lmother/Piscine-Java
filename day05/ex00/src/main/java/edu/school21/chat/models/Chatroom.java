package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Integer id;
    private String name;
    private User owner;
    private List<Massage> listMassages;

    public Chatroom(Integer id, String name, User owner, List<Massage> listMassages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.listMassages = listMassages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return Objects.equals(id, chatroom.id)
                && Objects.equals(name, chatroom.name)
                && Objects.equals(owner, chatroom.owner)
                && Objects.equals(listMassages, chatroom.listMassages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, listMassages);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", listMassages=" + listMassages +
                '}';
    }
}
