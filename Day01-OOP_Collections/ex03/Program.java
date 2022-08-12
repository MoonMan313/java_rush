public class Program {
    public static void main(String[] args) {
        User mike = new User("Mike", 1000);
        User john = new User("John", 1000);

        System.out.println("User: " + mike.getName());
        System.out.println("Balance: " + mike.getBalance());
        System.out.println("-------------------");

        System.out.println("User: " + john.getName());
        System.out.println("Balance: " + john.getBalance());
        System.out.println("-------------------\n");

        Transaction one;
        Transaction two;
        for (Integer i = 0; i < 5; ++i) {
            System.out.println("(" + i + ")");
            System.out.println("Transaction three: John -> Mike 200$");
            one = new Transaction(mike, john, -200);
            System.out.println(one.getIdentifier());
            System.out.println();

            System.out.println("Transaction four: Mike + 200$");
            two = new Transaction(mike, john,200);
            System.out.println(two.getIdentifier());
            System.out.println();
        }

        Transaction[] listMike = mike.getTransactionsList().transformToArray();
        System.out.println("-------------------");
        System.out.println("User: " + mike.getName());
        System.out.println("Balance: " + mike.getBalance());
        System.out.println("Transactions List UUID: ");
        for (Integer j = 0; j < listMike.length; ++j) {
            System.out.print(j + "   ");
            System.out.println(listMike[j].getIdentifier());
        }

        Transaction[] listJohn = john.getTransactionsList().transformToArray();
        System.out.println("-------------------");
        System.out.println("User: " + john.getName());
        System.out.println("Balance: " + john.getBalance());
        System.out.println("Transactions List UUID: ");
        for (Integer l = 0; l < listJohn.length; ++l) {
            System.out.print(l + "   ");
            System.out.println(listJohn[l].getIdentifier());
        }

        System.out.println("-------------------");
        System.out.println("Delete the (0)-(2)-(4) transactions for each user");
        mike.getTransactionsList().removeTransactionById(listMike[0].getIdentifier());
        john.getTransactionsList().removeTransactionById(listJohn[0].getIdentifier());
        mike.getTransactionsList().removeTransactionById(listMike[2].getIdentifier());
        john.getTransactionsList().removeTransactionById(listJohn[2].getIdentifier());
        mike.getTransactionsList().removeTransactionById(listMike[4].getIdentifier());
        john.getTransactionsList().removeTransactionById(listJohn[4].getIdentifier());

        Transaction[] listMike2 = mike.getTransactionsList().transformToArray();
        System.out.println("-------------------");
        System.out.println("User: " + mike.getName());
        System.out.println("Balance: " + mike.getBalance());
        System.out.println("Transactions List UUID: ");
        System.out.println("1   " + listMike2[0].getIdentifier());
        System.out.println("3   " + listMike2[1].getIdentifier());

        Transaction[] listJohn2 = john.getTransactionsList().transformToArray();
        System.out.println("-------------------");
        System.out.println("User: " + john.getName());
        System.out.println("Balance: " + john.getBalance());
        System.out.println("Transactions List UUID: ");
        System.out.println("1   " + listJohn2[0].getIdentifier());
        System.out.println("3   " + listJohn2[1].getIdentifier());

        System.out.println("-------------------");
        System.out.println("Checking for deletion of a transaction with an incorrect id:");
        john.getTransactionsList().removeTransactionById(listJohn[4].getIdentifier());
    }
}
