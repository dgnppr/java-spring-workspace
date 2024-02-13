package me.dgpr;

import java.util.concurrent.locks.ReentrantLock;

public class VirtualThreadSynchronized {

    private static final ReentrantLock lock = new ReentrantLock();

    // Synchronized 사용 (pinning 발생)
    public synchronized String accessResource() {
        return "Resource";
    }

    // ReentrantLock 사용 (pinning 발생 X)
    public String accessResourceWithLock() {
        lock.lock();
        try {
            return "Resource";
        } finally {
            lock.unlock();
        }
    }
}
