package baslangic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusteriMethodlar {
    private List<Musteri> alisverisSepeti = new ArrayList<>() ;
    private static List<Musteri> bakiyeYuklemeGecmisi = new ArrayList<>() ;
    private static List<Musteri> bakiyeCekmeGecmisi = new ArrayList<>() ;
    private static List<Musteri> alinanUrunGecmisi = new ArrayList<>() ;

    void yeniHesapAc(Scanner scan){
        /*constructerlere uygun tum bilgileri al
        Yeni bir hesap açılır./hesap acılınca otomatık gırıs yapsın.*/

        //Omer Faruk Bey

    }


    void urunleriGoruntule(){
        /*1- Burada 10 farklı kategori olacak.
        Kullanıcı katogorılerden birini secince 10 farklı ürün ve fiyatını görecek.
        2- Ürünleri sepete ekleyebilecek.
        3- Ödeme en sonda sepetten devam edilerek yapılacak.*/
        //urunleri UrunMethodlar classindan cagirmalisin.

        //Ubeyde bey

    }

    void sepeteEkle(){
        //alisveris tamamlandiktan sonra sepet sifirlanacak

        //Ubeyde bey
    }

    void bakiyeYukle(double miktar){
//bonusu hesaba TL olarak yukle

        //Caner
    }

    void nakiteCevir(double miktar){
        //Caner
    }

    void sepetiGoruntule(){
    //hangi odeme yontemiyle odenecekse ona gore odeme methodlari buradan cagrilacak
    //Ubeyde bey
    }

    void indirimliUrunleriGoruntule(){
//%25 indirim uygulansin ve hem indirimli hali hem de eski hali gozuksun.
        //Caner
    }

    void hesapGecmisiniGoruntule(){

        /*Bakiye yükleme geçmişi
        Bakiye çekme geçmişi
        Biriken bonuslar/Müsteri alışveriş yaptıkca bonus kazansın
        Alınan ürünler geçmişi*/

        /*
       private static List<KullaniciKodlari> bakiyeYuklemeGecmisi = new ArrayList<>() ;
    private static List<KullaniciKodlari> bakiyeCekmeGecmisi = new ArrayList<>() ;
    private static List<KullaniciKodlari> alinanUrunGecmisi = new ArrayList<>() ;*/


    //Yavuz Bey
    }
    void hesapAyarlari(){
    //Caner
    }
    static Musteri musteriHesapBul (Scanner scan , String kullaniciNumarasi) {
//hata vermemesi icin oylesine bir hesap olusturduk. sen kendin dogru hesabi olustur.
        Musteri hesap = new Musteri();

        return hesap;

        //Efehan bey

    }
    void musteriGirisi(Scanner scan ){
        //burada kontrol saglandiktan sonra 'mevcutMusteriHesabi' diye bir degisken olusturulacak.
        //buradan musteriMenu methodu cagrilacak
        //kullanici adi dogru ama sifre 5 defa yanlis ise kullanici engellensin.

        //Omer Faruk Bey

    }

    void siteBakiyesiIleOde(){

        //Cemal Bey
    }

    void bankaKartiIleOde(){
        //eger banka karti ile ode methodu misafir girisinden cagrildiysa
        // burada banka kartinin kullaniciya ait oldugu tekrar  yapilacak

        //Cemal Bey

    }

    void makbuz (){
        //odeme tamamlandiktan sonra bir makbuz yazilsin.
        // alinan urunler fiyatlari vs ve toplam miktar vs vs yazsin.

        //Yavuz Bey
    }


}