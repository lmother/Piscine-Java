package edu.school21.chat.models;

import java.util.Date;
import java.util.Objects;

public class Massage {
    private Integer id;
    private User author;
    private Chatroom room;
    private String text;
    private Date date;

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
        return "Massage{" +
                "id=" + id +
                ", author=" + author +
                ", room=" + room +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
