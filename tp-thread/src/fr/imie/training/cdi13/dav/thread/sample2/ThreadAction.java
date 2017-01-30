package fr.imie.training.cdi13.dav.thread.sample2;

public class ThreadAction extends Thread {

  private String id = null;
  private Recipient recipient = null;
  private long increment = 0;
  private long time = 0;
  
  public ThreadAction(String aId,Recipient aRecipient,long aIncrement,long aTime) {
    // TODO Auto-generated constructor stub
    this.id = aId;
    this.recipient = aRecipient;
    this.increment = aIncrement;
    this.time = aTime;
  }

  public void run() {
    System.out.println("---- RUN " + this.id);

    while( !isInterrupted()) {     
      recipient.incrementLevel(this.increment);
      System.out.println("---- " + this.id + " >>>> "+ recipient.getRecipientState());      
      //System.out.println("---- " + this.id + " - attente " + " : " + String.valueOf(this.time) + " ms");
      if (recipient.isFull()){
        System.out.println("---- STOP " + this.id);
        this.stop();
      }
      try {
          Thread.sleep(this.time);
      } catch (InterruptedException e) {}
    }
      
  }
  
}
