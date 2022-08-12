package edu.school21.sockets.models;

public class User {
    private Long id;
    private String email;
    private String password;

    public User(Long id, String login, String password) {
        this.id = id;
        this.email = login;
        this.password = password;
    }

    public User(String email, String password) {
        this.id = null;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}