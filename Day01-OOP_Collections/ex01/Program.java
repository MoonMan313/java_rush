public class Program {
    public static void main(String[] args) {
        User mike = new User("Mike", 1000);
        User john = new User("John", 100);
        User bob = new User("Bob", 10);

        System.out.println("User: " + mike.getName());
        System.out.println("Balance: " + mike.getBalance());
        System.out.println("ID: " + mike.getId());
        System.out.println("-------------------");
        System.out.println("User: " + john.getName());
        System.out.println("Balance: " + john.getBalance());
        System.out.println("ID: " + john.getId());
        System.out.println("-------------------\n");
        System.out.println("User: " + bob.getName());
        System.out.println("Balance: " + bob.getBalance());
        System.out.println("ID: " + bob.getId());
        System.out.println("-------------------\n");
    }
}
