package baslangic;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MusteriMethodlar {
    private List<Musteri> alisverisSepeti = new ArrayList<>();
    private static List<Musteri> bakiyeYuklemeGecmisi = new ArrayList<>();
    private static List<Musteri> bakiyeCekmeGecmisi = new ArrayList<>();
    private static List<Musteri> alinanUrunGecmisi = new ArrayList<>();

    public static int intScanner(Scanner scan) {
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Hata: Lütfen geçerli bir tamsayı girin.");
                scan.nextLine(); // Hatalı girişi temizliyorum.
            }
        }
    }


    public static String stringScanner(Scanner scan) {
        scan.nextLine();
        String degiskenIsmi;
        while (true) {

            degiskenIsmi = scan.nextLine();
            if (degiskenIsmi.matches("[a-zA-Z\\u0061-\\u007A\\u0041-\\u005A\\u00C0-\\u021E]+")) {
                return degiskenIsmi.trim();
            } else System.out.println("Lütfen geçerli bir ifade giriniz !\n");
        }
    }

    public static void yeniHesapAc(Scanner scan) {
        scan.nextLine();
        System.out.println("Lutfen adinizi giriniz");
        String kullaniciAdi = scan.next();
        boolean flag = true;
        String kullaniciSifre;
        do {
            scan.nextLine();
            System.out.println("lutfen en az sekiz karakterden olusan bir buyuk bir kucuk ve " +
                    "bir de buyuk harf olsuturan bir kullaniciSifre belirleyiniz");
            kullaniciSifre = scan.nextLine();
            if (kullaniciSifre.length() > 7) {
                for (int i = 0; i < kullaniciSifre.length(); i++) {
                    if (kullaniciSifre.matches(".*[0-9].*") && kullaniciSifre.matches(".*[A-Z].*") && kullaniciSifre.matches(".*[a-z].*")) {
                        System.out.println("\u001B[32mStrong Password\u001B[0m");
                        flag = false;
                        break;
                    }
                }
            } else {
                System.out.println("\u001B[34m Parola  en az sekiz karakter olmali \u001B[0m ");

            }
        } while (flag);

        System.out.println("Lutfen yasinizi giriniz");
        int kullaniciYasi = intScanner(scan);
        System.out.println("lutfen cinsiyetinizi giriniz");
        String kullaniciCinsiyeti = stringScanner(scan);
        scan.nextLine();
        System.out.println("Lutfen 16 haneden olusan bank kart numaranizi giriniz");
        String bankaKartiNumarasi = scan.nextLine();
        //String yildizKn = bankaKartiNumarasi.substring(12, 16).replaceAll("[0-9]", "*");
        System.out.println("Lutfen kartin arkasinda bulunan 3 haneli guvenlik kodunu giriniz");
        String bankaKartiGuvenlikKodu = scan.next();
        scan.nextLine();
        System.out.println("Lutfen urunleri ulastirabilecegimiz kargo adresiniz giriniz");

        String kargoAdresi = scan.nextLine();
        System.out.println("Lutfen telefon numaranizi giriniz");
        String tel = scan.nextLine();
        System.out.println("Lutfen mail adresinizi giriniz");
        String mailAdresi = scan.nextLine();
        System.out.println("Lutfen yuklemek istediginiz bakiyenizi giriniz");
        double siteBakiyesi = scan.nextDouble();
        //System.out.println("bonuss");
        double musteriBonus = siteBakiyesi / 20;
        System.out.println("Guncel bonusunuz : " + musteriBonus);
        //double musteriBonus = scan.nextDouble();
        String kullaniciNumarasi = kullaniciAdi;
        Musteri musTeri = new Musteri(kullaniciAdi, kullaniciSifre, kullaniciYasi,
                kullaniciCinsiyeti, bankaKartiNumarasi, bankaKartiGuvenlikKodu,
                kargoAdresi, tel, mailAdresi, siteBakiyesi, musteriBonus, kullaniciNumarasi);

        Musteri.getTumKullanicilar().add(musTeri);

    }

   /* public Musteri musteriHesabinaGiris(LinkedList<Musteri> musteriList) {
        System.out.println("musteri Hesabina giris yapmak icin Kullanici adinizi ve sekiz haneden olusan sifrenizi giriniz");
        String musteriHesabi = stringScanner(scan);
        for (Musteri mus : musteriList) {
            if (mus.getKullaniciAdi().equals(getKullaniciAdi()) && mus.getKullanıcıSifre().equals(getKullanıcıSifre())) {
                if (mus.getKullaniciCinsiyeti().equals("Kadin")) {
                    System.out.println(getKullaniciAdi() + " Hanim Hesabiniza hosgeldiniz keyifli alisveriler");
                } else System.out.println(getKullaniciAdi() + " Bey Hesabiniza hosgeldiniz keyifli alisveriler ");

                return mus;
            } else {
                System.out.println("lutfen kullanici adinizi ve sifrenizi kontrol edip tekrar deneyiniz");
            }
        }
        return null;
    }

}*/


    void urunleriGoruntule() {
        /*1- Burada 10 farklı kategori olacak.
        Kullanıcı katogorılerden birini secince 10 farklı ürün ve fiyatını görecek.
        2- Ürünleri sepete ekleyebilecek.
        3- Ödeme en sonda sepetten devam edilerek yapılacak.*/
        //urunleri UrunMethodlar classindan cagirmalisin.

        //Ubeyde bey

    }

    void sepeteEkle() {
        //alisveris tamamlandiktan sonra sepet sifirlanacak

        //Ubeyde bey
    }

    public void bakiyeYukle(Scanner scan, Musteri mevcupHesap) {

    }


    void nakiteCevir(double miktar) {
        //Caner
    }

    void sepetiGoruntule() {
        //hangi odeme yontemiyle odenecekse ona gore odeme methodlari buradan cagrilacak
        //Ubeyde bey
    }

    void indirimliUrunleriGoruntule() {
//%25 indirim uygulansin ve hem indirimli hali hem de eski hali gozuksun.
        //Caner
    }

    void hesapGecmisiniGoruntule() {

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

    void hesapAyarlari() {
        //Caner
    }

    static Musteri musteriHesapBul(String kullaniciNumarasi) {

        for (Musteri hesap : Musteri.getTumKullanicilar()) {
            if (hesap.getKullaniciNumarasi().equals(kullaniciNumarasi)) {
                return hesap;

            }
        }
        return null;

    }

    static Musteri engellenenMusteriHesapBul(String kullaniciNumarasi) {

        for (Musteri hesap : Musteri.getEngellenenKullanicilar()) {
            if (hesap.getKullaniciNumarasi().equals(kullaniciNumarasi)) {
                return hesap;

            }
        }
        return null;

    }

    static void musteriGirisi(Scanner scan) {
        //burada kontrol saglandiktan sonra 'mevcutMusteriHesabi' diye bir degisken olusturulacak.
        //buradan musteriMenu methodu cagrilacak
        //kullanici adi dogru ama sifre 5 defa yanlis ise kullanici engellensin.
        scan.nextLine();
        System.out.print("Lutfen kullanici adinizi giriniz :");

        String girilenMusteriHesabi = scan.nextLine();
        Musteri engellenenKullanici = engellenenMusteriHesapBul(girilenMusteriHesabi);
        if (engellenenKullanici == null) {

            Musteri mevcutMusteriHesabi = musteriHesapBul(girilenMusteriHesabi);
            int counter = 5;
            if (mevcutMusteriHesabi != null) {
                boolean girisBasarili = false;
                do {
                    System.out.println("Lutfen sifrenizi giriniz");
                    String girilenSifre = scan.nextLine();
                    if (mevcutMusteriHesabi.getKullanıcıSifre().equals(girilenSifre)) {
                        System.out.println("Giris basarili !");
                        MusteriMenusu.musteriMenu(scan);
                        girisBasarili = true;
                    } else {
                        counter--;
                        System.out.println("Sifreniz yanlis !" + counter + " defa deneme hakkiniz var. Tekrar deneyiniz.");

                    }

                    if (counter == 0) {

                        Musteri.getEngellenenKullanicilar().add(mevcutMusteriHesabi);
                        Musteri.getTumKullanicilar().remove(mevcutMusteriHesabi);

                        System.out.println("Sifrenizi 5 defa hatali girdiniz !\n" +
                                "Hesabiniz bloke edildi !\n" +
                                "Lutfen musteri hizmetlerine ulasiniz.");

                        //eger kullanici bloke olduysa giriste onun uyarisini gorsun. bunu ayarla!

                    }


                } while (!girisBasarili || counter == 0);

            } else {
                System.out.print("Kullanici hesabi bulunamadi !\n" +
                        "1 : Tekrar deneyiniz\n" +
                        "2 : Yeni hesap ac\n" +
                        "Ana menuye donmek icin herhangi bir tusa basabilirsiniz.\n" +
                        "Lutfen hangi islemi yapmak istediginizi belirtiniz :");

                int secim = intScanner(scan);
                if (secim == 1) {
                    musteriGirisi(scan);
                } else if (secim == 2) {
                    yeniHesapAc(scan);
                } else {

                }

            }


        } else {
            System.out.println("Bu hesap bloke olmustur. Lutfen musteri hizmetlerine ulasiniz.\n" +
                    "Veya yeni bir hesap olusturunuz.");

        }

        //Omer Faruk Bey

    }

    static void siteBakiyesiIleOde ( double bakiye, double tutar ){
            if (bakiye >= tutar) {
                bakiye -= tutar;
                System.out.println("Site Bakiyesinden : " + tutar + "tutarında ödeme yapılmıştır. Kalan Bakiye: " + bakiye);
            } else {
                System.out.println("Yetersiz Bakiye. Ödeme yapılamadı.");
            }
            //Cemal Bey
        }


    static void bankaKartiIleOde(String kartNo, String sonKullanmaTarihi, String cvv, double tutar) {
        if (kartNo == null || kartNo.isEmpty() || kartNo == null || kartNo.isEmpty() || cvv == null || cvv.isEmpty()) {
            System.out.println("Hata: Geçersiz veya eksik parametreler. Ödeme işlemi gerçekleştirilemedi.");
            return;
        }
        if (tutar <= 0) {
            System.out.println("Hata: Geçersiz ödeme miktarı. Ödeme işlemi gerçekleştirilemedi.");
            return;
        }
        System.out.println("Banka Kartı ile : " + tutar + " TL. tutarında ödeme yapımıştır.");

        //eger banka karti ile ode methodu misafir girisinden cagrildiysa
        // burada banka kartinin kullaniciya ait oldugu tekrar  yapilacak
        //Cemal Bey;

    }

    void makbuz() {
        //odeme tamamlandiktan sonra bir makbuz yazilsin.
        // alinan urunler fiyatlari vs ve toplam miktar vs vs yazsin.

        //Yavuz Bey
    }


}

