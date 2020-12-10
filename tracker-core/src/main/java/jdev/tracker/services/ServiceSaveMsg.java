package jdev.tracker.services;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServiceSaveMsg {
    // Создан объект блокирующей очереди по типу FIFO
    private static BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(100);

    // Запиcь в очередь
    public static void putMsg(String msg) throws InterruptedException {
        blockingQueue.put(msg);
    }

    // Чтение из очереди
    public static String takeMsg() throws InterruptedException {
        return blockingQueue.take();
    }

    // Получение очереди сообщений
    public static BlockingQueue<String> getBlockingQueue() {
        return blockingQueue;
    }
}
