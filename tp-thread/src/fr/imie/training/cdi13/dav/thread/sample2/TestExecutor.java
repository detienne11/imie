package fr.imie.training.cdi13.dav.thread.sample2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public class TestExecutor {

  private final ExecutorService pool;
  
  public TestExecutor(ExecutorService pool) {
    this.pool = pool;
  }
  
  public void start(){
        
    System.out.println("START POOL");
    
    CountDownLatch doneSignal = new CountDownLatch(5);
    
    for (int i = 1; i < 6; i++) {
      pool.execute(new TestRunnable(doneSignal,i,3000));
    }
    
    try {
      doneSignal.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("END POOL");
  }
    
}
