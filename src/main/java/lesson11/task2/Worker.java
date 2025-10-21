package lesson11.task2;

import java.util.concurrent.BlockingQueue;

public class Worker extends Thread {

    private BlockingQueue<Job> jobs;

    public Worker(String name, BlockingQueue<Job> jobs) {
        super(name);
        this.jobs = jobs;
    }

    @Override
    public void run() {
        while (true) {
            try {
                jobs.take().run();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

}
