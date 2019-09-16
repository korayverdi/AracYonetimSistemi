package aracyonetimsistemi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Koray
 */
public class AracYonetimSistemi {
    
    static int o1 = 0;
    static int b1 = 0;
    static int g1 = 0;
    static int u1 = 0;
    static int ug1 = 0;
    static ArrayList<Otomobil> otomobilList = new ArrayList<Otomobil>();
    static ArrayList<Bisiklet> bisikletList = new ArrayList<Bisiklet>();
    static ArrayList<Gemi> gemiList = new ArrayList<Gemi>();
    static ArrayList<Ucak> ucakList = new ArrayList<Ucak>();
    static UcanGemiA a = new UcanGemiA();
    static UcanGemiA.UcanGemi b = a.new UcanGemi();
    static ArrayList<UcanGemiA.UcanGemi> ucanGemiList = new ArrayList<UcanGemiA.UcanGemi>();
    static File path = new File("AracKayit.txt");

    public static void main(String[] args) throws IOException {
        readFile();
        menu();
    }

    public static void readFile() throws FileNotFoundException, UnsupportedEncodingException, IOException {

        System.setProperty("file.encoding", "UTF-8");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));

        String line;
        String[] line1;

        while ((line = br.readLine()) != null) {
            line = line.replace("﻿", "");

            line1 = line.split("-");
            int sayac = 0;

            for (String l : line1) {
                l = l.replace(" ", "");
            }

            if (line1[0].toLowerCase().contains("otomobil")) {
                Otomobil turOto = new Otomobil();
                otomobilList.add(turOto);

                int temp = Integer.parseInt(line1[0].toLowerCase().replace("otomobil", ""));
                if (temp > o1) {
                    o1 = temp;
                }
                turOto.setId(line1[0]);
                turOto.setMarka(line1[1]);
                turOto.setRenk(line1[2]);
                turOto.setYakıtTürü(line1[3]);
                turOto.setFiyat(Integer.parseInt(line1[4]));
                turOto.setHiz(Integer.parseInt(line1[5]));
                turOto.setMaxKapasite(Integer.parseInt(line1[6]));
                turOto.setUretimYili(Integer.parseInt(line1[7]));
                turOto.setTekerlekSay(Integer.parseInt(line1[8]));

            } else if (line1[0].toLowerCase().contains("bisiklet")) {
                Bisiklet turBike = new Bisiklet();
                bisikletList.add(turBike);

                int temp = Integer.parseInt(line1[0].toLowerCase().replace("bisiklet", ""));
                if (temp > b1) {
                    b1 = temp;
                }
                turBike.setId(line1[0]);
                turBike.setMarka(line1[1]);
                turBike.setRenk(line1[2]);
                turBike.setFiyat(Integer.parseInt(line1[3]));
                turBike.setHiz(Integer.parseInt(line1[4]));
                turBike.setMaxKapasite(Integer.parseInt(line1[5]));
                turBike.setUretimYili(Integer.parseInt(line1[6]));
                turBike.setTekerlekSay(Integer.parseInt(line1[7]));

            } else if (line1[0].toLowerCase().contains("gemi") && !line1[0].toLowerCase().contains("ucangemi")) {
                Gemi turGemi = new Gemi();
                gemiList.add(turGemi);

                int temp = Integer.parseInt(line1[0].toLowerCase().replace("gemi", ""));
                if (temp > g1) {
                    g1 = temp;
                }

                turGemi.setId(line1[0]);
                turGemi.setMarka(line1[1]);
                turGemi.setRenk(line1[2]);
                turGemi.setYakıtTürü(line1[3]);
                turGemi.setFiyat(Integer.parseInt(line1[4]));
                turGemi.setHiz(Integer.parseInt(line1[5]));
                turGemi.setMaxKapasite(Integer.parseInt(line1[6]));
                turGemi.setUretimYili(Integer.parseInt(line1[7]));

            } else if (line1[0].toLowerCase().contains("ucak")) {
                Ucak turUcak = new Ucak();
                ucakList.add(turUcak);

                int temp = Integer.parseInt(line1[0].toLowerCase().replace("ucak", ""));
                if (temp > u1) {
                    u1 = temp;
                }

                turUcak.setId(line1[0]);
                turUcak.setMarka(line1[1]);
                turUcak.setRenk(line1[2]);
                turUcak.setYakıtTürü(line1[3]);
                turUcak.setFiyat(Integer.parseInt(line1[4]));
                turUcak.setHiz(Integer.parseInt(line1[5]));
                turUcak.setMaxKapasite(Integer.parseInt(line1[6]));
                turUcak.setUretimYili(Integer.parseInt(line1[7]));
                turUcak.setTekerlekSay(Integer.parseInt(line1[8]));

            }

            if (line1[0].toLowerCase().contains("ucangemi")) {
                UcanGemiA a = new UcanGemiA();
                UcanGemiA.UcanGemi turUcanGemi = a.new UcanGemi();
                
                ucanGemiList.add(turUcanGemi);
                
                int temp = Integer.parseInt(line1[0].toLowerCase().replace("ucangemi", ""));
                if (temp > ug1) {
                    ug1 = temp;
                }
                
                turUcanGemi.setId(line1[0]);
                turUcanGemi.setMarka(line1[1]);
                turUcanGemi.setRenk(line1[2]);
                turUcanGemi.setYakıtTürü(line1[3]);
                turUcanGemi.setFiyat(Integer.parseInt(line1[4]));
                turUcanGemi.setHiz(Integer.parseInt(line1[5]));
                turUcanGemi.setMaxKapasite(Integer.parseInt(line1[6]));
                turUcanGemi.setUretimYili(Integer.parseInt(line1[7]));
                turUcanGemi.setTekerlekSay(Integer.parseInt(line1[8]));
            }
        }
        br.close();
    }
    
    public static void menu() throws FileNotFoundException, IOException {
        int sayi;
        String yazi;
        int secim;
        Scanner scanner = new Scanner(System.in);
        do {
            Otomobil turOto = new Otomobil();
            Bisiklet turBike = new Bisiklet();
            Gemi turGemi = new Gemi();
            Ucak turUcak = new Ucak();
            UcanGemiA a = new UcanGemiA();
            UcanGemiA.UcanGemi b = a.new UcanGemi();
            UcanGemiA turUcanGemia = new UcanGemiA();
            UcanGemiA.UcanGemi turUcanGemi = turUcanGemia.new UcanGemi();
            
            int satirSay = 0;
            String line;
            String secim1;
            
            System.out.println("\nYapmak İstediğiniz İşlemi Seçiniz:");
            System.out.println("1.Veri Girişinde Bulun\n2.Veri Listele\n3.Veri Güncelle\n0.ÇIKIŞ");
            secim = scanner.nextInt();
            
            switch (secim) {
                case 1:
                    System.out.println("\nVeri Girişinde Bulunacağınız Aracı Seçiniz:\n1:Otomobil\n2:Bisiklet\n3:Gemi\n4:Ucak\n5:Ucan Gemi\n6:Bir önceki menüye dönünüz\n0:ÇIKIŞ");
                    secim = scanner.nextInt();
                    if (secim == 1) { //Otomobil 
                        o1 = otomobilList.size();
                        otomobilList.add(turOto);
                        System.out.println("\nMarka Giriniz:");
                        yazi = scanner.next();
                        turOto.setMarka(yazi);
                        
                        System.out.println("Renk Giriniz:");
                        yazi = scanner.next();
                        turOto.setRenk(yazi);
                        
                        System.out.println("Yakıt Türü Giriniz:");
                        yazi = scanner.next();
                        turOto.setYakıtTürü(yazi);
                        
                        System.out.println("Fiyat giriniz:");
                        sayi = scanner.nextInt();
                        turOto.setFiyat(sayi);
                        
                        System.out.println("Hızını giriniz:");
                        sayi = scanner.nextInt();
                        turOto.setHiz(sayi);
                        
                        System.out.println("Max Kapasitesini Giriniz:");
                        sayi = scanner.nextInt();
                        turOto.setMaxKapasite(sayi);
                        
                        System.out.println("Üretim Yılını giriniz:");
                        sayi = scanner.nextInt();
                        turOto.setUretimYili(sayi);
                        
                        System.out.println("Tekerlek Sayisini Giriniz:");
                        sayi = scanner.nextInt();
                        turOto.setTekerlekSay(sayi);
                        turOto.setId("Otomobil" + (o1 + 1));
                                               
                        System.out.println("\nAracın durumunu giriniz:\n1.Hızlanma"
                                + "\n2.Yavaşlama\n3.Durma\n4.İşlem Yapmayacağım.");
                        int secim2 = 0;
                        int degisim = 0;
                        secim2 = scanner.nextInt();
                        if(secim2 == 1){
                            System.out.println("Arac ne kadar hızlanacak:");
                            degisim = scanner.nextInt();
                            turOto.hizlan(degisim);
                        }
                        else if(secim2 == 2){
                            System.out.println("Arac ne kadar yavaşlayacak:");
                            degisim = scanner.nextInt();
                            turOto.yavasla(degisim);
                        }
                        else if(secim2 == 3){
                            System.out.println("Aracın hızı 0 oldu.");
                            turOto.durdur();
                        }
                        else if(secim == 4){
                            
                        }
                        
                        writeFile();
                        
                    } else if (secim == 2) { // Bisiklet
                        b1 = bisikletList.size();
                        bisikletList.add(turBike);
                        System.out.println("\nMarka Giriniz:");
                        yazi = scanner.next();
                        turBike.setMarka(yazi);
                        
                        System.out.println("Renk Giriniz:");
                        yazi = scanner.next();
                        turBike.setRenk(yazi);
                        
                        System.out.println("Fiyat giriniz:");
                        sayi = scanner.nextInt();
                        turBike.setFiyat(sayi);
                        
                        System.out.println("Hızını giriniz:");
                        sayi = scanner.nextInt();
                        turBike.setHiz(sayi);
                        
                        System.out.println("Max Kapasitesini Giriniz:");
                        sayi = scanner.nextInt();
                        turBike.setMaxKapasite(sayi);
                        
                        System.out.println("Üretim Yılını giriniz:");
                        sayi = scanner.nextInt();
                        turBike.setUretimYili(sayi);
                        
                        System.out.println("Tekerlek Sayisini Giriniz:");
                        sayi = scanner.nextInt();
                        turBike.setTekerlekSay(sayi);
                        turBike.setId("Bisiklet" + (b1 + 1));
                        
                        System.out.println("\nAracın durumunu giriniz:\n1.Hızlanma"
                                + "\n2.Yavaşlama\n3.Durma\n4.İşlem Yapmayacağım.");
                        int secim2 = 0;
                        int degisim = 0;
                        secim2 = scanner.nextInt();
                        if(secim2 == 1){
                            System.out.println("Arac ne kadar hızlanacak:");
                            degisim = scanner.nextInt();
                            turBike.hizlan(degisim);                      
                        }
                        else if(secim2 == 2){
                            System.out.println("Arac ne kadar yavaşlayacak:");
                            degisim = scanner.nextInt();
                            turBike.yavasla(degisim);
                        }
                        else if(secim2 == 3){
                            System.out.println("Aracın hızı 0 oldu.");
                            turBike.durdur();
                        }
                        else if(secim == 4){
                            
                        }
                        
                        writeFile();
                        
                    } else if (secim == 3) { // Gemi
                        g1 = gemiList.size();
                        gemiList.add(turGemi);
                        System.out.println("\nMarka Giriniz:");
                        yazi = scanner.next();
                        turGemi.setMarka(yazi);
                        
                        System.out.println("Renk Giriniz:");
                        yazi = scanner.next();
                        turGemi.setRenk(yazi);
                        
                        System.out.println("Yakıt Türü Giriniz:");
                        yazi = scanner.next();
                        turGemi.setYakıtTürü(yazi);
                        
                        System.out.println("Fiyat giriniz:");
                        sayi = scanner.nextInt();
                        turGemi.setFiyat(sayi);
                        
                        System.out.println("Hızını giriniz:");
                        sayi = scanner.nextInt();
                        turGemi.setHiz(sayi);
                        
                        System.out.println("Max Kapasitesini Giriniz:");
                        sayi = scanner.nextInt();
                        turGemi.setMaxKapasite(sayi);
                        
                        System.out.println("Üretim Yılını giriniz:");
                        sayi = scanner.nextInt();
                        turGemi.setUretimYili(sayi);
                        turGemi.setId("Gemi" + (g1 + 1));
                        
                        System.out.println("\nAracın durumunu giriniz:\n1.Hızlanma"
                                + "\n2.Yavaşlama\n3.Durma\n4.İşlem Yapmayacağım.");
                        int secim2 = 0;
                        int degisim = 0;
                        secim2 = scanner.nextInt();
                        if(secim2 == 1){
                            System.out.println("Arac ne kadar hızlanacak:");
                            degisim = scanner.nextInt();
                            turGemi.hizlan(degisim);                      
                        }
                        else if(secim2 == 2){
                            System.out.println("Arac ne kadar yavaşlayacak:");
                            degisim = scanner.nextInt();
                            turGemi.yavasla(degisim);
                        }
                        else if(secim2 == 3){
                            System.out.println("Aracın hızı 0 oldu.");
                            turGemi.durdur();
                        }
                        else if(secim == 4){
                            
                        }
                        
                        writeFile();
                        
                    } else if (secim == 4) {//Uçak
                        u1 = ucakList.size();
                        ucakList.add(turUcak);
                        System.out.println("\nMarka Giriniz:");
                        yazi = scanner.next();
                        turUcak.setMarka(yazi);
                        
                        System.out.println("Renk Giriniz:");
                        yazi = scanner.next();
                        turUcak.setRenk(yazi);
                        
                        System.out.println("Yakıt Türü Giriniz:");
                        yazi = scanner.next();
                        turUcak.setYakıtTürü(yazi);
                        
                        System.out.println("Fiyat giriniz:");
                        sayi = scanner.nextInt();
                        turUcak.setFiyat(sayi);
                        
                        System.out.println("Hızını giriniz:");
                        sayi = scanner.nextInt();
                        turUcak.setHiz(sayi);
                        
                        System.out.println("Max Kapasitesini Giriniz:");
                        sayi = scanner.nextInt();
                        turUcak.setMaxKapasite(sayi);
                        
                        System.out.println("Üretim Yılını giriniz:");
                        sayi = scanner.nextInt();
                        turUcak.setUretimYili(sayi);
                        
                        System.out.println("Tekerlek Sayisini Giriniz:");
                        sayi = scanner.nextInt();
                        turUcak.setTekerlekSay(sayi);
                        turUcak.setId("Ucak" + (u1 + 1));
                        
                        System.out.println("\nAracın durumunu giriniz:\n1.Hızlanma"
                                + "\n2.Yavaşlama\n3.Durma\n4.İşlem Yapmayacağım.");
                        int secim2 = 0;
                        int degisim = 0;
                        secim2 = scanner.nextInt();
                        if(secim2 == 1){
                            System.out.println("Arac ne kadar hızlanacak:");
                            degisim = scanner.nextInt();
                            turUcak.hizlan(degisim);                      
                        }
                        else if(secim2 == 2){
                            System.out.println("Arac ne kadar yavaşlayacak:");
                            degisim = scanner.nextInt();
                            turUcak.yavasla(degisim);
                        }
                        else if(secim2 == 3){
                            turUcak.durdur();
                        }
                        else if(secim == 4){
                            
                        }
                        
                        writeFile();
                        
                    } else if (secim == 5) { //Uçan Gemi
                        ug1 = ucanGemiList.size();
                        ucanGemiList.add(turUcanGemi);
                        System.out.println("\nMarka Giriniz:");
                        yazi = scanner.next();
                        turUcanGemi.setMarka(yazi);
                        
                        System.out.println("Renk Giriniz:");
                        yazi = scanner.next();
                        turUcanGemi.setRenk(yazi);
                        
                        System.out.println("Yakıt Türü Giriniz:");
                        yazi = scanner.next();
                        turUcanGemi.setYakıtTürü(yazi);
                        
                        System.out.println("Fiyat giriniz:");
                        sayi = scanner.nextInt();
                        turUcanGemi.setFiyat(sayi);
                        
                        System.out.println("Hızını giriniz:");
                        sayi = scanner.nextInt();
                        turUcanGemi.setHiz(sayi);
                        
                        System.out.println("Max Kapasitesini Giriniz:");
                        sayi = scanner.nextInt();
                        turUcanGemi.setMaxKapasite(sayi);
                        
                        System.out.println("Üretim Yılını giriniz:");
                        sayi = scanner.nextInt();
                        turUcanGemi.setUretimYili(sayi);
                        
                        System.out.println("Tekerlek Sayisini Giriniz:");
                        sayi = scanner.nextInt();
                        turUcanGemi.setTekerlekSay(sayi);
                        turUcanGemi.setId("UcanGemi" + (ug1 + 1));
                        
                        System.out.println("\nAracın durumunu giriniz:\n1.Hızlanma"
                                + "\n2.Yavaşlama\n3.Durma\n4.İşlem Yapmayacağım.");
                        int secim2 = 0;
                        int degisim = 0;
                        secim2 = scanner.nextInt();
                        if(secim2 == 1){
                            System.out.println("Arac ne kadar hızlanacak:");
                            degisim = scanner.nextInt();
                            turUcanGemi.hizlan(degisim);                      
                        }
                        else if(secim2 == 2){
                            System.out.println("Arac ne kadar yavaşlayacak:");
                            degisim = scanner.nextInt();
                            turUcanGemi.yavasla(degisim);
                        }
                        else if(secim2 == 3){
                            turUcanGemi.durdur();
                        }
                        else if(secim == 4){
                            
                        }
                        
                        writeFile();
                        
                    } else if (secim == 6) {
                        
                    }
                    
                    break;
                case 2:
                    System.out.println("\nListelemek İstediğiniz Veri Tipini Seçiniz2");
                    System.out.println("1.Kara Taşıtları\n2.Hava Taşıtları"
                            + "\n3.Deniz taşıtları\n4.Bir Önceki menüye geri dön\n0.ÇIKIŞ");
                    secim = scanner.nextInt();
                    if (secim == 1) {
                        System.out.println("ID --- Marka --- Renk --- Yakıt --- Fiyat --- Hız --- Kapasite --- Model --- Tekerlek Sayısı");
                        listele("otomobil");
                        listele("bisiklet");
                    } else if (secim == 2) {
                        System.out.println("ID --- Marka --- Renk --- Yakıt --- Fiyat --- Hız --- Kapasite --- Model --- Tekerlek Sayısı");
                        listele("ucak");
                        listele("ucangemi");
                    } else if (secim == 3) {
                        System.out.println("ID --- Marka --- Renk --- Yakıt --- Fiyat --- Hız --- Kapasite --- Model --- Tekerlek Sayısı");
                        listele("gemi");
                        listele("ucangemi");
                    } else if (secim == 4) {
                        System.out.println("önceki menüye dönülüyor");
                    }
                    break;
                case 3:
                    do {
                        System.out.println("VERİ GÜNCELLE");
                        
                        System.out.println("ID --- Marka --- Renk --- Yakıt --- Fiyat --- Hız --- Kapasite --- Model --- Tekerlek Sayısı");
                        listele("otomobil");
                        listele("bisiklet");
                        listele("ucak");
                        listele("ucangemi");
                        listele("gemi");
                        System.out.println("Güncellemek istediğiniz aracın ID numarasını yazınız ( Üst menüye çıkmak için -1 ) ");
                        secim1 = scanner.next();
                        
                        if (secim1.toLowerCase().contains("otomobil")) {
                            for (int i = 0; i < otomobilList.size(); i++) {
                                if (otomobilList.get(i).getId().equalsIgnoreCase(secim1)) {
                                    System.out.println("ID : " + otomobilList.get(i).getId() + " Marka : " + otomobilList.get(i).getMarka()
                                            + " Renk : " + otomobilList.get(i).getRenk() + " Yakıt : " + otomobilList.get(i).getYakıtTürü()
                                            + " Fiyat : " + otomobilList.get(i).getFiyat() + " Hız : " + otomobilList.get(i).getHiz()
                                            + " Araç Kapasitesi : " + otomobilList.get(i).getMaxKapasite() + " Üretim Yılı : " + otomobilList.get(i).getUretimYili()
                                            + " Tekerlek Sayısı : " + otomobilList.get(i).getTekerlekSay());
                                    System.out.println("1 : Marka 2 : Renk 3 : Yakıt 4 : Fiyat 5 : Hız 6 : Kapasite 7 :"
                                            + "Ürtim yılı 8 : Tekerlek Sayısı");
                                    System.out.print("Düzenlemek istediğiniz özelliği seçin : ");
                                    secim = scanner.nextInt();
                                    
                                    switch (secim) {
                                        case 1:
                                            System.out.print("Aracın yeni markasını giriniz: ");
                                            String model = scanner.next();
                                            otomobilList.get(i).setMarka(model);
                                            break;
                                        case 2:
                                            System.out.print("Aracın yeni renk giriniz: ");
                                            String renk = scanner.next();
                                            otomobilList.get(i).setRenk(renk);
                                            break;
                                        case 3:
                                            System.out.print("Aracın yeni yakıt türünü giriniz: ");
                                            String yakit = scanner.next();
                                            otomobilList.get(i).setYakıtTürü(yakit);
                                            break;
                                        case 4:
                                            System.out.print("Aracın yeni fiyatını giriniz: ");
                                            int fiyat = scanner.nextInt();
                                            otomobilList.get(i).setFiyat(fiyat);
                                            break;
                                        case 5:
                                            System.out.print("Aracın yeni hıznı giriniz: ");
                                            int hiz = scanner.nextInt();
                                            otomobilList.get(i).setHiz(hiz);
                                            break;
                                        case 6:
                                            System.out.print("Aracın yeni maksimum kapasitesini giriniz: ");
                                            int kapasite = scanner.nextInt();
                                            otomobilList.get(i).setMaxKapasite(kapasite);
                                            break;
                                        case 7:
                                            System.out.print("Aracın yeni üretim yılını giriniz: ");
                                            int year = scanner.nextInt();
                                            otomobilList.get(i).setUretimYili(year);
                                            break;
                                        case 8:
                                            System.out.print("Aracın yeni tekerlek sayısını giriniz: ");
                                            int tekerlek = scanner.nextInt();
                                            otomobilList.get(i).setTekerlekSay(tekerlek);
                                            break;
                                        default:
                                            System.out.println("Yanlış girdiniz.");
                                            break;
                                    }
                                }
                            }
                        } else if (secim1.toLowerCase().contains("bisiklet")) {
                            for (int i = 0; i < bisikletList.size(); i++) {
                                if (bisikletList.get(i).getId().equalsIgnoreCase(secim1)) {
                                    System.out.println("ID : " + bisikletList.get(i).getId() + " Marka : " + bisikletList.get(i).getMarka()
                                            + " Renk : " + bisikletList.get(i).getRenk() + " Fiyat : " + bisikletList.get(i).getFiyat() + " Hız : " + bisikletList.get(i).getHiz()
                                            + " Araç Kapasitesi : " + bisikletList.get(i).getMaxKapasite() + " Üretim Yılı : " + bisikletList.get(i).getUretimYili()
                                            + " Tekerlek Sayısı : " + bisikletList.get(i).getTekerlekSay());
                                    System.out.println("1 : Marka 2 : Renk 3 : Fiyat 4 : Hız 5 : Kapasite 6 :"
                                            + "Ürtim yılı 7 : Tekerlek Sayısı");
                                    System.out.print("Düzenlemek istediğiniz özelliği seçin : ");
                                    secim = scanner.nextInt();
                                    
                                    switch (secim) {
                                        case 1:
                                            System.out.print("Aracın yeni markasını giriniz: ");
                                            String model = scanner.next();
                                            bisikletList.get(i).setMarka(model);
                                            break;
                                        case 2:
                                            System.out.print("Aracın yeni renk giriniz: ");
                                            String renk = scanner.next();
                                            bisikletList.get(i).setRenk(renk);
                                            break;
                                        case 3:
                                            System.out.print("Aracın yeni fiyatını giriniz: ");
                                            int fiyat = scanner.nextInt();
                                            bisikletList.get(i).setFiyat(fiyat);
                                            break;
                                        case 4:
                                            System.out.print("Aracın yeni hıznı giriniz: ");
                                            int hiz = scanner.nextInt();
                                            bisikletList.get(i).setHiz(hiz);
                                            break;
                                        case 5:
                                            System.out.print("Aracın yeni maksimum kapasitesini giriniz: ");
                                            int kapasite = scanner.nextInt();
                                            bisikletList.get(i).setMaxKapasite(kapasite);
                                            break;
                                        case 6:
                                            System.out.print("Aracın yeni üretim yılını giriniz: ");
                                            int year = scanner.nextInt();
                                            bisikletList.get(i).setUretimYili(year);
                                            break;
                                        case 7:
                                            System.out.print("Aracın yeni tekerlek sayısını giriniz: ");
                                            int tekerlek = scanner.nextInt();
                                            bisikletList.get(i).setTekerlekSay(tekerlek);
                                            break;
                                        default:
                                            System.out.println("Yanlış girdiniz.");
                                            break;
                                    }
                                }
                            }
                        } else if (secim1.toLowerCase().contains("gemi") && !secim1.toLowerCase().contains("ucangemi")) {
                            for (int i = 0; i < gemiList.size(); i++) {
                                if (gemiList.get(i).getId().equalsIgnoreCase(secim1)) {
                                    System.out.println("ID : " + gemiList.get(i).getId() + " Marka : " + gemiList.get(i).getMarka()
                                            + " Renk : " + gemiList.get(i).getRenk() + " Fiyat : " + gemiList.get(i).getFiyat() + " Hız : " + gemiList.get(i).getHiz()
                                            + " Araç Kapasitesi : " + gemiList.get(i).getMaxKapasite() + " Üretim Yılı : " + gemiList.get(i).getUretimYili()
                                            + " Tekerlek Sayısı : " + gemiList.get(i).getTekerlekSay());
                                    System.out.println("1 : Marka 2 : Renk 3 : Fiyat 4 : Hız 5 : Kapasite 6 :"
                                            + "Ürtim yılı 7 : Yakıt Türü");
                                    System.out.print("Düzenlemek istediğiniz özelliği seçin : ");
                                    secim = scanner.nextInt();
                                    
                                    switch (secim) {
                                        case 1:
                                            System.out.print("Aracın yeni markasını giriniz: ");
                                            String model = scanner.next();
                                            gemiList.get(i).setMarka(model);
                                            break;
                                        case 2:
                                            System.out.print("Aracın yeni renk giriniz: ");
                                            String renk = scanner.next();
                                            gemiList.get(i).setRenk(renk);
                                            break;
                                        case 3:
                                            System.out.print("Aracın yeni fiyatını giriniz: ");
                                            int fiyat = scanner.nextInt();
                                            gemiList.get(i).setFiyat(fiyat);
                                            break;
                                        case 4:
                                            System.out.print("Aracın yeni hıznı giriniz: ");
                                            int hiz = scanner.nextInt();
                                            gemiList.get(i).setHiz(hiz);
                                            break;
                                        case 5:
                                            System.out.print("Aracın yeni maksimum kapasitesini giriniz: ");
                                            int kapasite = scanner.nextInt();
                                            gemiList.get(i).setMaxKapasite(kapasite);
                                            break;
                                        case 6:
                                            System.out.print("Aracın yeni üretim yılını giriniz: ");
                                            int year = scanner.nextInt();
                                            gemiList.get(i).setUretimYili(year);
                                            break;
                                        case 7:
                                            System.out.print("Aracın yeni yakıt türünü  giriniz: ");
                                            String yakit = scanner.next();
                                            gemiList.get(i).setYakıtTürü(yakit);
                                            break;
                                        default:
                                            System.out.println("Yanlış girdiniz.");
                                            break;
                                    }
                                }
                            }
                        } else if (secim1.toLowerCase().contains("ucak")) {
                            for (int i = 0; i < ucakList.size(); i++) {
                                if (ucakList.get(i).getId().equalsIgnoreCase(secim1)) {
                                    System.out.println("ID : " + ucakList.get(i).getId() + " Marka : " + ucakList.get(i).getMarka()
                                            + " Renk : " + ucakList.get(i).getRenk() + " Yakıt : " + ucakList.get(i).getYakıtTürü()
                                            + " Fiyat : " + ucakList.get(i).getFiyat() + " Hız : " + ucakList.get(i).getHiz()
                                            + " Araç Kapasitesi : " + ucakList.get(i).getMaxKapasite() + " Üretim Yılı : " + ucakList.get(i).getUretimYili()
                                            + " Tekerlek Sayısı : " + ucakList.get(i).getTekerlekSay());
                                    System.out.println("1 : Marka 2 : Renk 3 : Yakıt 4 : Fiyat 5 : Hız 6 : Kapasite 7 :"
                                            + "Ürtim yılı 8 : Tekerlek Sayısı");
                                    System.out.print("Düzenlemek istediğiniz özelliği seçin : ");
                                    secim = scanner.nextInt();
                                    
                                    switch (secim) {
                                        case 1:
                                            System.out.print("Aracın yeni markasını giriniz: ");
                                            String model = scanner.next();
                                            ucakList.get(i).setMarka(model);
                                            break;
                                        case 2:
                                            System.out.print("Aracın yeni renk giriniz: ");
                                            String renk = scanner.next();
                                            ucakList.get(i).setRenk(renk);
                                            break;
                                        case 3:
                                            System.out.print("Aracın yeni yakıt türünü giriniz: ");
                                            String yakit = scanner.next();
                                            ucakList.get(i).setYakıtTürü(yakit);
                                            break;
                                        case 4:
                                            System.out.print("Aracın yeni fiyatını giriniz: ");
                                            int fiyat = scanner.nextInt();
                                            ucakList.get(i).setFiyat(fiyat);
                                            break;
                                        case 5:
                                            System.out.print("Aracın yeni hıznı giriniz: ");
                                            int hiz = scanner.nextInt();
                                            ucakList.get(i).setHiz(hiz);
                                            break;
                                        case 6:
                                            System.out.print("Aracın yeni maksimum kapasitesini giriniz: ");
                                            int kapasite = scanner.nextInt();
                                            ucakList.get(i).setMaxKapasite(kapasite);
                                            break;
                                        case 7:
                                            System.out.print("Aracın yeni üretim yılını giriniz: ");
                                            int year = scanner.nextInt();
                                            ucakList.get(i).setUretimYili(year);
                                            break;
                                        case 8:
                                            System.out.print("Aracın yeni tekerlek sayısını giriniz: ");
                                            int tekerlek = scanner.nextInt();
                                            ucakList.get(i).setTekerlekSay(tekerlek);
                                            break;
                                        default:
                                            System.out.println("Yanlış girdiniz.");
                                            break;
                                    }
                                }
                            }
                        } else if (secim1.toLowerCase().contains("ucangemi")) {
                            for (int i = 0; i < ucanGemiList.size(); i++) {
                                if (ucanGemiList.get(i).getId().equalsIgnoreCase(secim1)) {
                                    System.out.println("ID : " + ucanGemiList.get(i).getId() + " Marka : " + ucanGemiList.get(i).getMarka()
                                            + " Renk : " + ucanGemiList.get(i).getRenk() + " Yakıt : " + ucanGemiList.get(i).getYakıtTürü()
                                            + " Fiyat : " + ucanGemiList.get(i).getFiyat() + " Hız : " + ucanGemiList.get(i).getHiz()
                                            + " Araç Kapasitesi : " + ucanGemiList.get(i).getMaxKapasite() + " Üretim Yılı : " + ucanGemiList.get(i).getUretimYili()
                                            + " Tekerlek Sayısı : " + ucanGemiList.get(i).getTekerlekSay());
                                    System.out.println("1 : Marka 2 : Renk 3 : Yakıt 4 : Fiyat 5 : Hız 6 : Kapasite 7 :"
                                            + "Ürtim yılı 8 : Tekerlek Sayısı");
                                    System.out.print("Düzenlemek istediğiniz özelliği seçin : ");
                                    secim = scanner.nextInt();
                                    
                                    switch (secim) {
                                        case 1:
                                            System.out.print("Aracın yeni markasını giriniz: ");
                                            String model = scanner.next();
                                            ucanGemiList.get(i).setMarka(model);
                                            break;
                                        case 2:
                                            System.out.print("Aracın yeni renk giriniz: ");
                                            String renk = scanner.next();
                                            ucanGemiList.get(i).setRenk(renk);
                                            break;
                                        case 3:
                                            System.out.print("Aracın yeni yakıt türünü giriniz: ");
                                            String yakit = scanner.next();
                                            ucanGemiList.get(i).setYakıtTürü(yakit);
                                            break;
                                        case 4:
                                            System.out.print("Aracın yeni fiyatını giriniz: ");
                                            int fiyat = scanner.nextInt();
                                            ucanGemiList.get(i).setFiyat(fiyat);
                                            break;
                                        case 5:
                                            System.out.print("Aracın yeni hıznı giriniz: ");
                                            int hiz = scanner.nextInt();
                                            ucanGemiList.get(i).setHiz(hiz);
                                            break;
                                        case 6:
                                            System.out.print("Aracın yeni maksimum kapasitesini giriniz: ");
                                            int kapasite = scanner.nextInt();
                                            ucanGemiList.get(i).setMaxKapasite(kapasite);
                                            break;
                                        case 7:
                                            System.out.print("Aracın yeni üretim yılını giriniz: ");
                                            int year = scanner.nextInt();
                                            ucanGemiList.get(i).setUretimYili(year);
                                            break;
                                        case 8:
                                            System.out.print("Aracın yeni tekerlek sayısını giriniz: ");
                                            int tekerlek = scanner.nextInt();
                                            ucanGemiList.get(i).setTekerlekSay(tekerlek);
                                            break;
                                        default:
                                            System.out.println("Yanlış girdiniz.");
                                            break;
                                    }
                                }
                            }
                        } else if (Integer.parseInt(secim1) != -1) {
                            System.out.println("Yanlış ID girdiniz.");
                        }
                        
                    } while (!secim1.equals("-1"));
                    writeFile();
                    break;
            }
        } while (secim!=0);
    }

    static void writeFile() {
        try {
            System.setProperty("file.encoding", "UTF-8");
            
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"ISO-8859-1"));
            
            for (int i = 0; i < otomobilList.size(); i++) {
                String satir = otomobilList.get(i).getId() 
                        + "-" + otomobilList.get(i).getMarka() 
                        + "-" + otomobilList.get(i).getRenk()
                        + "-" + otomobilList.get(i).getYakıtTürü()
                        + "-" + otomobilList.get(i).getFiyat()
                        + "-" + otomobilList.get(i).getHiz()
                        + "-" + otomobilList.get(i).getMaxKapasite()
                        + "-" + otomobilList.get(i).getUretimYili()
                        + "-" + otomobilList.get(i).getTekerlekSay();
                out.append(satir);
                out.write(System.getProperty("line.separator"));
            }
            
            for (int i = 0; i < bisikletList.size(); i++) {
                String satir = bisikletList.get(i).getId() 
                        + "-" + bisikletList.get(i).getMarka() 
                        + "-" + bisikletList.get(i).getRenk() 
                        + "-" + bisikletList.get(i).getFiyat() 
                        + "-" + bisikletList.get(i).getHiz() 
                        + "-" + bisikletList.get(i).getMaxKapasite() 
                        + "-" + bisikletList.get(i).getUretimYili() 
                        + "-" + bisikletList.get(i).getTekerlekSay();
                out.append(satir);
                out.write(System.getProperty("line.separator"));
            }
            
            for (int i = 0; i < gemiList.size(); i++) {
                String satir = gemiList.get(i).getId() 
                        + "-" +gemiList.get(i).getMarka() 
                        + "-" + gemiList.get(i).getRenk() 
                        + "-" + gemiList.get(i).getYakıtTürü() 
                        + "-" + gemiList.get(i).getFiyat() 
                        + "-" + gemiList.get(i).getHiz() 
                        + "-" + gemiList.get(i).getMaxKapasite() 
                        + "-" + gemiList.get(i).getUretimYili();
                out.append(satir);
                out.write(System.getProperty("line.separator"));
            }
            
            for (int i = 0; i < ucakList.size(); i++) {
                String satir = ucakList.get(i).getId() 
                        + "-" + ucakList.get(i).getMarka() 
                        + "-" + ucakList.get(i).getRenk() 
                        + "-" + ucakList.get(i).getYakıtTürü() 
                        + "-" + ucakList.get(i).getFiyat() 
                        + "-" + ucakList.get(i).getHiz() + "-" 
                        + ucakList.get(i).getMaxKapasite() 
                        + "-" + ucakList.get(i).getUretimYili() 
                        + "-" + ucakList.get(i).getTekerlekSay();
                out.append(satir);
                out.write(System.getProperty("line.separator"));
            }
            
            for (int i = 0; i < ucanGemiList.size(); i++) {
                String satir = ucanGemiList.get(i).getId() 
                        + "-" + ucanGemiList.get(i).getMarka() 
                        + "-" + ucanGemiList.get(i).getRenk() 
                        + "-" + ucanGemiList.get(i).getYakıtTürü() 
                        + "-" + ucanGemiList.get(i).getFiyat() 
                        + "-" + ucanGemiList.get(i).getHiz() 
                        + "-" + ucanGemiList.get(i).getMaxKapasite() 
                        + "-" + ucanGemiList.get(i).getUretimYili() 
                        + "-" + ucanGemiList.get(i).getTekerlekSay();
                out.append(satir);
                out.write(System.getProperty("line.separator"));
            }
            out.flush();
            out.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    static void listele(String s) {
        if (s.equalsIgnoreCase("otomobil")) {
            for (int i = 0; i < otomobilList.size(); i++) {
                System.out.println(otomobilList.get(i).getId() + " " + otomobilList.get(i).getMarka() + " "
                        + otomobilList.get(i).getRenk() + " " + otomobilList.get(i).getYakıtTürü() + " "
                        + otomobilList.get(i).getFiyat() + " " + otomobilList.get(i).getHiz() + " "
                        + otomobilList.get(i).getMaxKapasite() + " " + otomobilList.get(i).getUretimYili()
                        + " " + otomobilList.get(i).getTekerlekSay());
            }
        }
        
        if (s.equalsIgnoreCase("bisiklet")) {
            for (int i = 0; i < bisikletList.size(); i++) {
                System.out.println(bisikletList.get(i).getId() + " " + bisikletList.get(i).getMarka() + " "
                        + bisikletList.get(i).getRenk() + " " + "--- "
                        + bisikletList.get(i).getFiyat() + " " + bisikletList.get(i).getHiz() + " "
                        + bisikletList.get(i).getMaxKapasite() + " " + bisikletList.get(i).getUretimYili()
                        + " " + bisikletList.get(i).getTekerlekSay());
            }
        }
        
        if (s.equalsIgnoreCase("ucak")) {
            for (int i = 0; i < ucakList.size(); i++) {
                System.out.println(ucakList.get(i).getId() + " " + ucakList.get(i).getMarka() + " "
                        + ucakList.get(i).getRenk() + " " + ucakList.get(i).getYakıtTürü() + " "
                        + ucakList.get(i).getFiyat() + " " + ucakList.get(i).getHiz() + " "
                        + ucakList.get(i).getMaxKapasite() + " " + ucakList.get(i).getUretimYili()
                        + " " + ucakList.get(i).getTekerlekSay());
            }
        }
        
        if (s.equalsIgnoreCase("ucangemi")) {
            for (int i = 0; i < ucanGemiList.size(); i++) {
                System.out.println(ucanGemiList.get(i).getId() + " " + ucanGemiList.get(i).getMarka() + " "
                        + ucanGemiList.get(i).getRenk() + " " + ucanGemiList.get(i).getYakıtTürü() + " "
                        + ucanGemiList.get(i).getFiyat() + " " + ucanGemiList.get(i).getHiz() + " "
                        + ucanGemiList.get(i).getMaxKapasite() + " " + ucanGemiList.get(i).getUretimYili()
                        + " " + ucanGemiList.get(i).getTekerlekSay());
            }
        }
        
        if (s.equalsIgnoreCase("gemi")) {
            for (int i = 0; i < gemiList.size(); i++) {
                System.out.println(gemiList.get(i).getId() + " " + gemiList.get(i).getMarka() + " "
                        + gemiList.get(i).getRenk() + " " + gemiList.get(i).getYakıtTürü() + " "
                        + gemiList.get(i).getFiyat() + " " + gemiList.get(i).getHiz() + " "
                        + gemiList.get(i).getMaxKapasite() + " " + gemiList.get(i).getUretimYili()
                        + " " + "---- ");
            }
        }
    }
}
