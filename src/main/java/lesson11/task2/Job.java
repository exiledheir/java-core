package lesson11.task2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Job implements Runnable {
    private int id;

    @Override
    public void run() {
        System.out.println("Job: " + id + " is runed by " + Thread.currentThread().getName());
    }
}
