package fr.imie.training.cdi13.dav.thread.sample2;

public class ThreadTest {
  
  public static void main(String[] args) {
    
    System.out.println("==========  THREAD TEST - REMPLISSAGE  ==========" );
    // creation de l'objet commun au thread
    Recipient recipient = new Recipient();
    
    
    // creation thread de remplissage
    ThreadAction t1 = new ThreadAction("Thread 1",recipient,100,500);
    ThreadAction t2 = new ThreadAction("Thread 2",recipient,10,100);
    
    // lancement du remplissage
    t1.start();
    t2.start();
  }

}
