package me.dgpr;

class SynchronizedTest {

    static final int MAX = 10000;

    public static void main(String[] args) throws InterruptedException {
        increment1(); // 메서드 전체에 synchronized(클래스 자체가 모니터락 소유)-> 50000
        increment2(); // 메서드 내부에서 synchronized -> 50000
        increment3(); // 쓰레드마다 다른 모니터락 객체 인스턴스 설정 -> 49998
        increment4(); // 쓰레드마다 같은 모니터락 객체 인스턴스 설정 -> 50000
    }

    static void increment1() throws InterruptedException {
        Monitor.init();

        Thread[] threads = createThreads();

        start(threads, () -> {
            for (int j = 0; j < MAX; j++) {
                Monitor.increment1();
            }
        });

        join(threads);

        System.out.println("[Ex1] count = " + Monitor.count);
    }

    static void increment2() throws InterruptedException {
        Monitor.init();

        Thread[] threads = createThreads();

        start(threads, () -> {
            for (int j = 0; j < MAX; j++) {
                Monitor.increment2();
            }
        });

        join(threads);

        System.out.println("[Ex2] count = " + Monitor.count);

    }


    private static void increment3() throws InterruptedException {
        Monitor.init();

        Thread[] threads = createThreads();

        for (int i = 0; i < threads.length; i++) {
            Monitor monitor = new Monitor();
            threads[i] = new Thread(() -> {
                for (int j = 0; j < MAX; j++) {
                    monitor.increment3();
                }
            });

            threads[i].start();
        }

        join(threads);

        System.out.println("[Ex3] count = " + Monitor.count);
    }

    static void increment4() throws InterruptedException {
        Monitor.init();

        Monitor monitor = new Monitor();
        Thread[] threads = createThreads();

        start(threads, () -> {
            for (int j = 0; j < MAX; j++) {
                monitor.increment3();
            }
        });

        join(threads);

        System.out.println("[Ex4] count = " + Monitor.count);
    }

    private static Thread[] createThreads() {
        return new Thread[5];
    }

    private static void start(Thread[] threads, Runnable task) {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }
    }

    private static void join(Thread[] threads) throws InterruptedException {
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
    }
}

class Monitor {
    static int count = 0;
    static Object object = new Object();

    static void init() {
        count = 0;
    }

    synchronized public static void increment1() {
        count++;
    }

    static void increment2() {
        synchronized (object) {
            count++;
        }
    }

    public void increment3() {
        synchronized (this) {
            count++;
        }
    }
}
