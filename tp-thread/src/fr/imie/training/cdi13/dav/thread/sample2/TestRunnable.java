package fr.imie.training.cdi13.dav.thread.sample2;

import java.util.concurrent.CountDownLatch;

public class TestRunnable implements Runnable {

  private int index;
  private long timeout;
  
  private final CountDownLatch doneSignal;
  
  public TestRunnable(CountDownLatch doneSignal,int index,long timeout){
    this.doneSignal = doneSignal;
    this.index = index;
    this.timeout = timeout;
  }
      
  public void run() {

    System.out.println("START TestRunnable run " + String.valueOf(this.index));
    try {
      System.out.println("WAIT TestRunnable " + String.valueOf(this.index) + " : " + String.valueOf(this.timeout));
      Thread.sleep(timeout);
      this.doneSignal.countDown();
    } catch (InterruptedException e) {
    }
    System.out.println("END TestRunnable run " + String.valueOf(this.index));

  }

}