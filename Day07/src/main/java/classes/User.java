package classes;

public class User {
    private String name;
    private Integer height;

    public User() {
    }

    public User(String name, Integer height) {
        this.name = name;
        this.height = height;
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

    public int grow(int value) {
        this . height += value;
        return height;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
