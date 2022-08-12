package edu.school21.chat.models;

import java.util.List;

public class User {
    private Long id;
    private String login;
    private String password;
    private List<Chatroom> allChatroom;
    private List<Chatroom> userChatroom;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(Long id, String login, String password, List<Chatroom> allChatroom, List<Chatroom> userChatroom) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.allChatroom = allChatroom;
        this.userChatroom = userChatroom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getAllChatroom() {
        return allChatroom;
    }

    public void setAllChatroom(List<Chatroom> allChatroom) {
        this.allChatroom = allChatroom;
    }

    public List<Chatroom> getUserChatroom() {
        return userChatroom;
    }

    public void setUserChatroom(List<Chatroom> userChatroom) {
        this.userChatroom = userChatroom;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", allChatroom=" + allChatroom +
                ", userChatroom=" + userChatroom +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }
}
