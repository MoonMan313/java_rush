import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User mike = new User("Mike", 1000);
        User john = new User("John", 1000);

        mike.setIdentifier(1);
        john.setIdentifier(2);

        System.out.println("User: " + mike.getName());
        System.out.println("Balance: " + mike.getBalance());
        System.out.println("-------------------");
        System.out.println("User: " + john.getName());
        System.out.println("Balance: " + john.getBalance());
        System.out.println("-------------------\n");

        System.out.println("Transaction one: John -> Mike 0$");
        Transaction one = new Transaction(mike, john, 0);
        System.out.println();

        System.out.println("Transaction two: John -> Mike 1001$");
        Transaction two = new Transaction(mike, john, -1001);
        System.out.println();

        System.out.println("Transaction three: John -> Mike 1000$");
        Transaction three = new Transaction(mike, john,-1000);
        System.out.println(three.getIdentifier());
        System.out.println();

        System.out.println("Transaction four: Mike + 1000$");
        Transaction four = new Transaction(mike, john,1000);
        System.out.println(four.getIdentifier());
        System.out.println();

        System.out.println("User: " + mike.getName());
        System.out.println("Balance: " + mike.getBalance());
        System.out.println("-------------------");
        System.out.println("User: " + john.getName());
        System.out.println("Balance: " + john.getBalance());
    }
}
