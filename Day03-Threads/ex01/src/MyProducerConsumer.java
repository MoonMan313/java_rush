public class MyProducerConsumer {
    private Boolean isFull;
    private int cont;

    public MyProducerConsumer(int cont) {
        this.cont = cont;
        isFull = false;
    }

    public void produce(String word) throws InterruptedException {
        for (int i = 0; i < cont; ++i) {
            synchronized (this) {
                if (isFull) {
                    wait();
                }
                System.out.println(word);
                isFull = true;
                notify();
            }
        }
    }

    public void consume(String word) throws InterruptedException {
        for (int i = 0; i < cont; ++i) {
            synchronized (this) {
                if (!isFull) {
                    wait();
                }
                System.out.println(word);
                isFull = false;
                notify();
            }
        }
    }
}
