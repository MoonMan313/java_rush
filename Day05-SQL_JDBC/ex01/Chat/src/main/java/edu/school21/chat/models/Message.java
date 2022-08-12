package edu.school21.chat.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Message {
    private int id;
    private User author;
    private Chatroom room;
    private String text;
    private Timestamp dateTime;

    public Message(int id, User author, Chatroom room, String text, Timestamp dateTime) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = Timestamp.valueOf(dateTime);
    }

    @Override
    public String toString() {
        return "Message{\n" +
                " id=" + id +
                ",\n author=" + author +
                ",\n room=" + room +
                ",\n text='" + text + '\'' +
                ",\n dateTime=" + dateTime +
                "\n}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }
}
