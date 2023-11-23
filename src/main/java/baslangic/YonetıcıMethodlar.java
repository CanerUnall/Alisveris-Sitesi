package baslangic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YonetıcıMethodlar {



    static List<Yonetici> tumYoneticiler = new ArrayList<>();

    public static void tumYoneticiler(){
        tumYoneticiler.add(new Yonetici());
        tumYoneticiler.add(new Yonetici());
        tumYoneticiler.add(new Yonetici());
        tumYoneticiler.add(new Yonetici());
        tumYoneticiler.add(new Yonetici());
        tumYoneticiler.add(new Yonetici());
        tumYoneticiler.add(new Yonetici());
        tumYoneticiler.add(new Yonetici());
        tumYoneticiler.add(new Yonetici());
        tumYoneticiler.add(new Yonetici());
    }

    private static Yonetici YoneticiHesapBul(Scanner scan, String yoneticiNumarasi) {
        //hata vermemesi icin oylesine bir hesap olusturduk. sen kendin dogru hesabi olustur.
        Yonetici hesap = new Yonetici();

        return hesap;
    }

    void yoneticiGirisi(Scanner scan){
        //burada kontrol saglandiktan sonra 'mevcutYoneticiHesabi' diye bir degisken olusturulacak.
        //kontroller saglandiktan sonra yoneticiMenu buradan cagrilacak

    }

    void toplamMusteriSayisi(){

    }

    void tumMusteriIsimleri(){

    }

    void satilanUrunler(){

    }

    void tumUrunStogunuGoruntule(){

    }

    void musteriIstatikleriniGoruntule (){

    }

    void musteriEngelle(){

    }


}