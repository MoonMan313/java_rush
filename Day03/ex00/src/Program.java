public class Program {
    public static void main(String[] args) {

        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("Enter the number of iterations in the format: \"java Program --count=NUMBER\"");
            System.exit(0);
        }

        int count = Integer.parseInt(args[0].substring(8));
        if (count <= 0) {
            System.err.println("Enter a positive number.");
            System.exit(0);
        }

        Thread egg = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < count; ++i) {
                    System.out.println("Egg");
                }
            }
        };

        Thread hen = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < count; ++i) {
                    System.out.println("Hen");
                }
            }
        };

        hen.start();
        egg.start();

        try {
            hen.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < count; ++i) {
            System.out.println("Human");
        }
    }
}
