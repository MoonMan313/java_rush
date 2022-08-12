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

        MyProducerConsumer eggOrHen = new MyProducerConsumer(count);

        Thread egg = new Thread() {
            @Override
            public void run() {
                try {
                    eggOrHen.produce("Egg");
                } catch (InterruptedException e) {
                    System.err.println("Something went wrong...");
                }
            }
        };

        Thread hen = new Thread() {
            @Override
            public void run() {
                try {
                    eggOrHen.consume("Hen");
                } catch (InterruptedException e) {
                    System.err.println("Something went wrong...");
                }
            }
        };

        hen.start();
        egg.start();
    }
}
