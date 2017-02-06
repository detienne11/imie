package fr.imie.training.cdi13.dav.thread.sample2;

import java.util.concurrent.Executors;

public class ThreadSample {

  public static void test() {

//    ThreadPoolExecutor pool =
//        new ThreadPoolExecutor(
//            3,
//            3,
//            0L,
//            TimeUnit.NANOSECONDS,
//            new LinkedBlockingQueue<Runnable>());
//    TestExecutor t = new TestExecutor(pool);
    TestExecutor t = new TestExecutor(Executors.newFixedThreadPool(3));    
    t.start();

  }
}
