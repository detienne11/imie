package fr.imie.training.cdi13.dav.thread.sample2;

import java.util.Random;

public class VaseCommuniquant {
  private static final int QUANTITE_INITIALE = 200;
  private static final int NB_THREAD_MAX = 3;
  
  private static int iteration = 0;
  
  private int[] vase = {QUANTITE_INITIALE / 2,QUANTITE_INITIALE / 2};

  public VaseCommuniquant() {
      for( int i = 0; i < NB_THREAD_MAX; i++)
          new ThreadTransfert().start();
  }
  public static void main(String[] args) {
      new VaseCommuniquant();
  }
  
  public int transfert(int qte) {
      // Ne pas enlever les System.out de ce test !
      System.out.print("-("+qte+") dans le vase 1 ");
      vase[0] -= qte;
      System.out.println("+("+qte+") dans le vase 2");
      vase[1] += qte;
      iteration++;
      if( iteration % 1000 == 0)
          System.out.println("" + iteration + " it�rations.");
      return vase[0]+vase[1];
  }
  
  public class ThreadTransfert extends Thread {
      Random r = new Random();
      int quantite;
      public void run() {
          while( !isInterrupted()) {
              quantite = r.nextInt(11)-6;
              vase[0] -= quantite;
              vase[1] += quantite;
              if( transfert(quantite) != QUANTITE_INITIALE) {
                  System.err.println("Quantit� totale invalide � l'it�ration " + iteration);
                  System.exit(-1);
              }
              
              try {
                  Thread.sleep(10);
              } catch (InterruptedException e) {}
          }
      }
      
  }
}