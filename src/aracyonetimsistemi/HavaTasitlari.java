package aracyonetimsistemi;

import java.util.Scanner;

/**
 *
 * @author Koray
 */
abstract public class HavaTasitlari extends Arac implements Ozellikler { 
    Scanner scanner = new Scanner(System.in);
    public int hizlan(int hiz){      
        this.setHiz(this.getHiz() + hiz);
        return hiz;
    }
    
    public int yavasla(int hiz){
        this.setHiz(this.getHiz() - hiz);
        return hiz;
    }
    
    public void durdur(){
        int sayac = 0;
        int a = 0;
        System.out.println("Hava taşıtları anında duramazlar.Önce yavaşlaması gerekir.\nAraç ne kadar yavaşlayacak:");
        a = scanner.nextInt();
        while(this.getHiz() > a){
            this.setHiz(this.getHiz() - a);
            sayac++;
            System.out.println("Aracın hızı: "+this.getHiz());
        }
        this.setHiz(0);
        System.out.println("Aracın hızı: "+this.getHiz());
    }
}
