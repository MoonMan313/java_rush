public class Program {
    public static void main(String[] args) {
        UsersArrayList bookUsers = new UsersArrayList();

        System.out.print("Size: ");
        System.out.println(bookUsers.numberOfUsers());
        System.out.print("Capacity: ");
        System.out.println(bookUsers.getCapacity());
        System.out.println("-------------------");

        System.out.println("+10 Users");
        for (Integer i = 0; i < 10 ; ++i) {
            bookUsers.addUser("User", i);
        }
        System.out.println("-------------------");
        System.out.print("Size: ");
        System.out.println(bookUsers.numberOfUsers());
        System.out.print("Capacity: ");
        System.out.println(bookUsers.getCapacity());
        System.out.println("ID User by ID: ");
        for (Integer i = 1; i < 11 ; ++i) {
            System.out.println(bookUsers.getUserByID(i).getId());
        }
        System.out.println("-------------------");

        System.out.println("+1 Users");
        bookUsers.addUser("User", 11);

        System.out.print("Size: ");
        System.out.println(bookUsers.numberOfUsers());
        System.out.print("Capacity: ");
        System.out.println(bookUsers.getCapacity());
        System.out.println("ID User by index: ");
        for (Integer j = 0; j < 11 ; ++j) {
            System.out.println(bookUsers.getUserByIndex(j).getId());
        }

        System.out.println(bookUsers.getUserByIndex(13).getId());

    }
}
