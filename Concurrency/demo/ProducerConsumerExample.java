public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        Drop drop = new Drop();
        Thread t1 = new Thread(new Producer(drop));
        Thread t2 = new Thread(new Consumer(drop));
        t1.start();
        t2.start();

        Thread.sleep(5000);
        t1.interrupt();
    }
}
