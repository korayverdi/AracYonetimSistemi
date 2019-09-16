package aracyonetimsistemi;

/**
 *
 * @author Koray
 */
abstract public class KaraTasitlari extends Arac implements Ozellikler { 
    public int hizlan(int hiz){
         this.setHiz(getHiz() + hiz);
         return hiz;
    }
    
    public int yavasla(int hiz){
         this.setHiz(getHiz() - hiz);
         return hiz;
    }
    
    public void durdur(){
         this.setHiz(0);
    }
}
