package lesson11.task1;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class PubSubTask {

    private final static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(8);
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Subscriber()).start();
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        while (!message.equals("exit")) {
            new Thread(new Publisher(message)).start();
            message = scanner.nextLine();
        }
        flag = false;
    }

    static class Publisher implements Runnable {
        private final String message;

        public Publisher(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println("Publisher (издатель) добавляет слово в очередь: " + message);
            try {
                messageQueue.put(message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class Subscriber implements Runnable {
        @Override
        public void run() {
            while (flag) {

                try {
                    String message = messageQueue.take();
                    System.out.println("Subscriber (подписчик) извлекает слово из очереди: " + message);
                } catch (InterruptedException e) {
                    e.getCause();
                }
            }
        }
    }
}
