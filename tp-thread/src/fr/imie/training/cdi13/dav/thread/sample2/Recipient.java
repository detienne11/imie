package fr.imie.training.cdi13.dav.thread.sample2;

public class Recipient {

  private long capacity;
  private long level;
   
  public Recipient() {
    // initialisation de la taille et niveau du recipient
    this.capacity = 1000;
    this.level = 0;
  }
  
  public void incrementLevel(long aIncrement) {
    
    // incrementation du niveau;    
    if ((this.level + aIncrement) < this.capacity){
      this.level = this.level + aIncrement;
    }
    else {
      this.level = this.capacity; 
    }
    
  }
  
  public boolean isFull() {
    
    // indique si le recipient est plein
    boolean isFull = false;
    if (this.level >= this.capacity){
      isFull = true;
    }
    return isFull;
  }
  
  public String getRecipientState(){
    
    // retourne l'etat du recipient
    StringBuffer str = new StringBuffer();
    str.append("Etat : ");
    str.append(this.level);
    str.append(" / ");
    str.append(this.capacity);
    return str.toString();
  }

}
