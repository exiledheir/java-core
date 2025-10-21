package lesson11.task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CustomThreadPool customThreadPool = new CustomThreadPool(Runtime.getRuntime().availableProcessors());

        for(int i =0; i<30;i++){
            customThreadPool.execute(new Job(i));
        }

        Thread.sleep(1000);
        customThreadPool.shutdown();
    }
}
