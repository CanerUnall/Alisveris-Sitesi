package baslangic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UrunlerMethodlar {

    //Ubeyde bey
    /*{
        tumKategoriler();;
    }*/
    static List<List<Urunler>> tumKategoriler = new ArrayList<>();
    static List<Urunler> satilanUrunler = new ArrayList<>();
    static List<Urunler> kirtasiye = new ArrayList<>();
    static List<Urunler> elektronik = new ArrayList<>();
    static List<Urunler> manav = new ArrayList<>();
    static List<Urunler> tekstil = new ArrayList<>();
    static List<Urunler> kisiselBakim = new ArrayList<>();
    static List<Urunler> hirdavat = new ArrayList<>();
    static List<Urunler> spor = new ArrayList<>();
    static List<Urunler> otoAksesuar = new ArrayList<>();
    static List<Urunler> hayvanUrunleri = new ArrayList<>();
    static List<Urunler> kozmetik = new ArrayList<>();

    static void indirimliFiyat(List<Urunler> kategori) {

        for (Urunler urun : kategori) {
            urun.setUrunAdi(urun.getUrunAdi() + " *İndirim*");
            urun.setUrunFiyati(urun.getUrunFiyati() / 4 * 3);

        }
    }

    static void indirimsizFiyat(List<Urunler> kategori) {
        for (Urunler urun : kategori) {
            urun.setUrunAdi(urun.getIndirimsizIsim());
            urun.setUrunFiyati(urun.getIndirimsizFiyat());
        }
    }

    static boolean elekronikUrunleriIndirimdemi = false;
    static boolean kirtasiyeUrunleriIndirimdemi = false;
    static boolean manavUrunleriIndirimdemi = false;
    static boolean tekstilUrunleriIndirimdemi = false;
    static boolean kisiselBakimUrunleriIndirimdemi = false;
    static boolean hirdavatUrunleriIndirimdemi = false;
    static boolean sporUrunleriIndirimdemi = false;
    static boolean otoAksesuarUrunleriIndirimdemi = false;
    static boolean hayvanUrunleriUrunleriIndirimdemi = false;
    static boolean kozmetikUrunleriIndirimdemi = false;

    static void indirimiAktiflestir() {
        int ayinKaci = LocalDate.now().getDayOfMonth();

        if (ayinKaci == 1 || ayinKaci == 2 || ayinKaci == 3) {
            elekronikUrunleriIndirimdemi = true;
            UrunlerMethodlar.indirimliFiyat(UrunlerMethodlar.elektronik);
        } else {
            UrunlerMethodlar.indirimsizFiyat(UrunlerMethodlar.elektronik);
            elekronikUrunleriIndirimdemi = false;
        }
        if (ayinKaci == 4 || ayinKaci == 5 || ayinKaci == 6) {
            kirtasiyeUrunleriIndirimdemi = true;
            UrunlerMethodlar.indirimliFiyat(UrunlerMethodlar.kirtasiye);
        } else {
            UrunlerMethodlar.indirimsizFiyat(UrunlerMethodlar.kirtasiye);
            kirtasiyeUrunleriIndirimdemi = false;
        }
        if (ayinKaci == 7 || ayinKaci == 8 || ayinKaci == 9) {
            manavUrunleriIndirimdemi = true;
            UrunlerMethodlar.indirimliFiyat(UrunlerMethodlar.manav);
        } else {
            UrunlerMethodlar.indirimsizFiyat(UrunlerMethodlar.manav);
            manavUrunleriIndirimdemi = false;
        }
        if (ayinKaci == 10 || ayinKaci == 11 || ayinKaci == 12) {
            tekstilUrunleriIndirimdemi = true;
            UrunlerMethodlar.indirimliFiyat(UrunlerMethodlar.tekstil);
        } else {
            UrunlerMethodlar.indirimsizFiyat(UrunlerMethodlar.tekstil);
            tekstilUrunleriIndirimdemi = false;
        }
        if (ayinKaci == 13 || ayinKaci == 14 || ayinKaci == 15) {
            kisiselBakimUrunleriIndirimdemi = true;
            UrunlerMethodlar.indirimliFiyat(UrunlerMethodlar.kisiselBakim);
        } else {
            UrunlerMethodlar.indirimsizFiyat(UrunlerMethodlar.kisiselBakim);
            kisiselBakimUrunleriIndirimdemi = false;
        }
        if (ayinKaci == 16 || ayinKaci == 17 || ayinKaci == 18) {
            hirdavatUrunleriIndirimdemi = true;
            UrunlerMethodlar.indirimliFiyat(UrunlerMethodlar.hirdavat);
        } else {
            UrunlerMethodlar.indirimsizFiyat(UrunlerMethodlar.hirdavat);
            hirdavatUrunleriIndirimdemi = false;
        }
        if (ayinKaci == 19 || ayinKaci == 20 || ayinKaci == 21) {
            sporUrunleriIndirimdemi = true;
            UrunlerMethodlar.indirimliFiyat(UrunlerMethodlar.spor);
        } else {
            UrunlerMethodlar.indirimsizFiyat(UrunlerMethodlar.spor);
            sporUrunleriIndirimdemi = false;
        }
        if (ayinKaci == 22 || ayinKaci == 23 || ayinKaci == 24) {
            otoAksesuarUrunleriIndirimdemi = true;
            UrunlerMethodlar.indirimliFiyat(UrunlerMethodlar.otoAksesuar);
        } else {
            UrunlerMethodlar.indirimsizFiyat(UrunlerMethodlar.otoAksesuar);
            otoAksesuarUrunleriIndirimdemi = false;
        }
        if (ayinKaci == 25 || ayinKaci == 26 || ayinKaci == 27) {
            hayvanUrunleriUrunleriIndirimdemi = true;
            UrunlerMethodlar.indirimliFiyat(UrunlerMethodlar.hayvanUrunleri);
        } else {
            hayvanUrunleriUrunleriIndirimdemi = false;
            UrunlerMethodlar.indirimsizFiyat(UrunlerMethodlar.hayvanUrunleri);
        }
        if (ayinKaci == 28 || ayinKaci == 29 || ayinKaci == 30 || ayinKaci == 31) {
            kozmetikUrunleriIndirimdemi = true;
            UrunlerMethodlar.indirimliFiyat(UrunlerMethodlar.kozmetik);
        } else {
            UrunlerMethodlar.indirimsizFiyat(UrunlerMethodlar.kozmetik);
            kozmetikUrunleriIndirimdemi = false;
        }
    }

    public static void tumKategoriler() {
        //urunAdi,  urunFiyati, stokAdeti larini eklemeyi unutma
        tumKategoriler.add(kirtasiye);
        tumKategoriler.add(elektronik);
        tumKategoriler.add(manav);
        tumKategoriler.add(tekstil);
        tumKategoriler.add(kisiselBakim);
        tumKategoriler.add(hirdavat);
        tumKategoriler.add(spor);
        tumKategoriler.add(otoAksesuar);
        tumKategoriler.add(hayvanUrunleri);
        tumKategoriler.add(kozmetik);
    }

    public static void kirtasiye() {
        //urunAdi,  urunFiyati, stokAdeti larini eklemeyi unutma
        if (kirtasiye.isEmpty()) {
            kirtasiye.add(new Urunler("Kalem", 6.50, 300));
            kirtasiye.add(new Urunler("Silgi", 2.50, 300));
            kirtasiye.add(new Urunler("Defter", 13.00, 350));
            kirtasiye.add(new Urunler("Ajanda", 17.00, 350));
            kirtasiye.add(new Urunler("A4 Kağıt", 3.00, 300));
            kirtasiye.add(new Urunler("Boya Seti", 12.50, 400));
            kirtasiye.add(new Urunler("Sticker", 1.00, 500));
            kirtasiye.add(new Urunler("Roman", 4.50, 350));
            kirtasiye.add(new Urunler("Hikaye", 3.50, 350));
            kirtasiye.add(new Urunler("Dergi", 4.00, 350));

        }
    }

    public static void manav() {
        //urunAdi,  urunFiyati, stokAdeti larini eklemeyi unutma
        if (manav.isEmpty()) {
            manav.add(new Urunler("Domates", 0.50, 500));
            manav.add(new Urunler("Salatalık", 0.45, 500));
            manav.add(new Urunler("Patates", 0.30, 600));
            manav.add(new Urunler("Soğan", 0.25, 600));
            manav.add(new Urunler("Portakal", 1.00, 500));
            manav.add(new Urunler("Avakado", 21.00, 100));
            manav.add(new Urunler("Lahana", 2.00, 400));
            manav.add(new Urunler("Mandalina", 0.80, 600));
            manav.add(new Urunler("Kayısı", 0.50, 550));
            manav.add(new Urunler("Şeftali", 1.30, 500));
        }
    }

    public static void tekstil() {
        //urunAdi,  urunFiyati, stokAdeti larini eklemeyi unutma
        if (tekstil.isEmpty()) {
            tekstil.add(new Urunler("Kazak", 8.00, 50));
            tekstil.add(new Urunler("T-shirt", 4.00, 60));
            tekstil.add(new Urunler("Gömlek", 5.00, 65));
            tekstil.add(new Urunler("Etek", 6.00, 45));
            tekstil.add(new Urunler("Atkı", 2.00, 80));
            tekstil.add(new Urunler("Şapka", 2.50, 85));
            tekstil.add(new Urunler("Pantolon", 5.00, 65));
            tekstil.add(new Urunler("Ceket", 11.00, 40));
            tekstil.add(new Urunler("Eşofman", 8.50, 65));
            tekstil.add(new Urunler("Süveter", 2.50, 55));
        }
    }

    public static void kisiselBakim() {
        //urunAdi,  urunFiyati, stokAdeti larini eklemeyi unutma
        if (kisiselBakim.isEmpty()) {
            kisiselBakim.add(new Urunler("El Kremi", 6.00, 75));
            kisiselBakim.add(new Urunler("Şampuan", 7.00, 65));
            kisiselBakim.add(new Urunler("Serum", 8.50, 55));
            kisiselBakim.add(new Urunler("Deodorant", 3.40, 90));
            kisiselBakim.add(new Urunler("Parfüm", 4.50, 85));
            kisiselBakim.add(new Urunler("Sıvı Sabun", 1.20, 120));
            kisiselBakim.add(new Urunler("Banyo Lifi", 2.30, 80));
            kisiselBakim.add(new Urunler("Traş Köpüğü", 5.30, 60));
            kisiselBakim.add(new Urunler("Traş Makinesi", 24.50, 40));
            kisiselBakim.add(new Urunler("Saç Kremi", 4.40, 80));
        }
    }

    public static void hirdavat() {
        //urunAdi,  urunFiyati, stokAdeti larini eklemeyi unutma
        if (hirdavat.isEmpty()) {
            hirdavat.add(new Urunler("Tornavida", 1.20, 300));
            hirdavat.add(new Urunler("Çivi", 0.50, 800));
            hirdavat.add(new Urunler("Pense", 3.50, 250));
            hirdavat.add(new Urunler("Şarjlı Matkap", 45.00, 35));
            hirdavat.add(new Urunler("Çekiç", 6.50, 100));
            hirdavat.add(new Urunler("Menteşe", 3.20, 250));
            hirdavat.add(new Urunler("Budama Makası", 8.50, 75));
            hirdavat.add(new Urunler("Testere", 9.80, 70));
            hirdavat.add(new Urunler("Somun", 0.40, 500));
            hirdavat.add(new Urunler("Civata", 0.45, 480));
        }
    }

    public static void spor() {
        //urunAdi,  urunFiyati, stokAdeti larini eklemeyi unutma
        if (spor.isEmpty()) {
            spor.add(new Urunler("Eşofman Takımı", 30.00, 50));
            spor.add(new Urunler("Çadır", 82.00, 15));
            spor.add(new Urunler("Dambıl", 3.00, 180));
            spor.add(new Urunler("Yüzme Gözlüğü", 4.50, 150));
            spor.add(new Urunler("Yüzme Bonesi", 4.20, 180));
            spor.add(new Urunler("Spor Ayakkabı", 17.50, 90));
            spor.add(new Urunler("Tenis Topu", 1.20, 230));
            spor.add(new Urunler("Tenis Raketi", 8.20, 90));
            spor.add(new Urunler("Bisiklet", 28.00, 25));
            spor.add(new Urunler("Kask", 4.00, 110));
        }
    }

    public static void otoAksesuar() {
        //urunAdi,  urunFiyati, stokAdeti larini eklemeyi unutma
        if (otoAksesuar.isEmpty()) {
            otoAksesuar.add(new Urunler("Telefon Tutucu", 3.20, 185));
            otoAksesuar.add(new Urunler("Oto Parfüm", 4.10, 190));
            otoAksesuar.add(new Urunler("Araç Şarjı", 4.30, 175));
            otoAksesuar.add(new Urunler("Bagaj Düzenleyici", 7.20, 140));
            otoAksesuar.add(new Urunler("Akü Takviye Cihazı", 14.20, 50));
            otoAksesuar.add(new Urunler("Kıs Lastiği", 18.50, 30));
            otoAksesuar.add(new Urunler("Bijon Anahtarı", 6.20, 120));
            otoAksesuar.add(new Urunler("Kriko", 5.30, 150));
            otoAksesuar.add(new Urunler("Jant", 8.30, 120));
            otoAksesuar.add(new Urunler("Far", 4.40, 150));
        }
    }

    public static void elektronik() {
        //urunAdi,  urunFiyati, stokAdeti larini eklemeyi unutma
        if (elektronik.isEmpty()) {
            elektronik.add(new Urunler("Laptop", 14.20, 70));
            elektronik.add(new Urunler("Cep Telefonu", 11.80, 90));
            elektronik.add(new Urunler("Şarj Aleti", 3.20, 250));
            elektronik.add(new Urunler("Mutfak Robotu", 7.40, 130));
            elektronik.add(new Urunler("Robot Süpürge", 12.10, 80));
            elektronik.add(new Urunler("Airfryer", 9.80, 100));
            elektronik.add(new Urunler("Buzdolabı", 14.40, 65));
            elektronik.add(new Urunler("Fırın", 13.20, 85));
            elektronik.add(new Urunler("Çamaşır Makinesi", 11.80, 95));
            elektronik.add(new Urunler("Bulaşık Makinesi", 11.50, 105));
        }
    }

    public static void hayvanUrunleri() {
        //urunAdi,  urunFiyati, stokAdeti larini eklemeyi unutma
        if (hayvanUrunleri.isEmpty()) {
            hayvanUrunleri.add(new Urunler("Kedi Maması", 4.00, 250));
            hayvanUrunleri.add(new Urunler("Köpek Maması", 4.00, 250));
            hayvanUrunleri.add(new Urunler("Kum Kabı", 5.00, 210));
            hayvanUrunleri.add(new Urunler("Kedi Tasması", 2.40, 300));
            hayvanUrunleri.add(new Urunler("Köpek Tasması", 2.40, 300));
            hayvanUrunleri.add(new Urunler("Akvaryum", 14.00, 80));
            hayvanUrunleri.add(new Urunler("Balık Yemi", 1.20, 350));
            hayvanUrunleri.add(new Urunler("Kuş Yemi", 1.30, 380));
            hayvanUrunleri.add(new Urunler("Kuş Kafesi", 6.00, 120));
            hayvanUrunleri.add(new Urunler("Hamster Kafesi", 5.50, 130));
        }
    }

    public static void kozmetik() {
        //urunAdi,  urunFiyati, stokAdeti larini eklemeyi unutma
        if (kozmetik.isEmpty()) {
            kozmetik.add(new Urunler("Ruj", 5.20, 150));
            kozmetik.add(new Urunler("Allık", 4.80, 170));
            kozmetik.add(new Urunler("Rimel", 5.10, 140));
            kozmetik.add(new Urunler("Maskara", 4.60, 135));
            kozmetik.add(new Urunler("Far", 3.80, 150));
            kozmetik.add(new Urunler("Eyeliner", 4.30, 160));
            kozmetik.add(new Urunler("Oje", 5.10, 120));
            kozmetik.add(new Urunler("Kaç Sabitleyici", 4.20, 130));
            kozmetik.add(new Urunler("Kapatıcı", 3.90, 140));
            kozmetik.add(new Urunler("Aydınlatıcı Krem", 4.40, 130));
        }
    }

}
