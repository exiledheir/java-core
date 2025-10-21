package lesson11.task2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CustomThreadPool {
    private int poolSize;
    private Worker[] workers;
    private BlockingQueue<Job> jobs;

    public CustomThreadPool(int poolSize) {
        this.poolSize = poolSize;
        workers = new Worker[poolSize];
        jobs = new ArrayBlockingQueue<>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Worker("thread: " + i, jobs);
            workers[i].start();
        }
    }

    public void execute(Job job) {
        try {
            jobs.put(job);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown(){
        for(Worker worker: workers){
            worker.interrupt();
        }
    }
}
