package edu.school21.chat.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class Massage {
    private long id;
    private User author;
    private Chatroom room;
    private String text;
    private Date date;

    public Massage(Integer id, User author, Chatroom room, String text, Date date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Massage massage = (Massage) o;
        return Objects.equals(id, massage.id)
                && Objects.equals(author, massage.author)
                && Objects.equals(room, massage.room)
                && Objects.equals(text, massage.text)
                && Objects.equals(date, massage.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, room, text, date);
    }

    @Override
    public String toString() {
        return "Massage{" + "\n" +
                "id=" + id + "\n" +
                ", author=" + author + "\n" +
                ", room=" + room + "\n" +
                ", text='" + text + '\'' + "\n" +
                ", date=" + new SimpleDateFormat("yy/MM/dd HH:mm").format(date) + "\n" +
                '}';
    }

}
