package baslangic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YoneticiMethodlar {

    static List<Yonetici> tumYoneticiler = new ArrayList<>();

    public static void tumYoneticiler() {
        tumYoneticiler.add(new Yonetici("Caner", "sifreyok"));
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

    private static Yonetici yoneticiHesapBul(String yoneticiNumarasi) {
        //hata vermemesi icin oylesine bir hesap olusturduk. sen kendin dogru hesabi olustur.
        for (Yonetici yoneticiHesabi : tumYoneticiler) {
            if (yoneticiHesabi.getYoneticiID().equals(yoneticiNumarasi)) {
                return yoneticiHesabi;
            }
        }
        return null;
    }

    static void yoneticiGirisi(Scanner scan) {
        //burada kontrol saglandiktan sonra 'mevcutYoneticiHesabi' diye bir degisken olusturulacak.
        //kontroller saglandiktan sonra yoneticiMenu buradan cagrilacak
        scan.nextLine();
        System.out.print("Lutfen Yonetici ID nizi giriniz : ");
        String yoneticiId = scan.nextLine();
        Yonetici mevcutYoneticiHesabi = yoneticiHesapBul(yoneticiId);
        if (mevcutYoneticiHesabi != null) {
            System.out.print("Sifrenizi giriniz : ");
            String girilenSifre = scan.nextLine();
            if (mevcutYoneticiHesabi.getYoneticiSifre().equals(girilenSifre)) {
                System.out.println("Yonetici hesabina basariyla giris yapildi.");
                YoneticiMenusu.yoneticiMenu();
            } else {
                System.out.println("Sifreniz yanlis !" +
                        "Tekrar denemek ister misiniz?\n" +
                        "Evet ise 1'e\n" +
                        "Ana menuye donmek isterseniz 2'ye\n" +
                        "Cikis yapmak isterseniz istediginiz bir tusa basiniz : ");

                int cikisSecim = MusteriMethodlar.intScanner(scan);

                if (cikisSecim == 1) {
                    yoneticiGirisi(scan);
                } else if (cikisSecim == 2) {
                    AnaSayfa.Application();
                } else {
                    System.exit(0);
                }
            }

        } else {
            System.out.println("Hesap Bulunamadi !" +
                    "Tekrar denemek ister misiniz?\n" +
                    "Evet ise 1'e\n" +
                    "Ana menuye donmek isterseniz 2'ye\n" +
                    "Cikis yapmak isterseniz istediginiz bir tusa basiniz : ");

            int cikisSecim = MusteriMethodlar.intScanner(scan);

            if (cikisSecim == 1) {
                yoneticiGirisi(scan);
            } else if (cikisSecim == 2) {
                AnaSayfa.Application();
            } else {
                System.exit(0);
            }

        }
    }

    static void toplamMusteriSayisi() {

        int toplamKullaniciSayisi = Musteri.getTumKullanicilar().size() + Musteri.getEngellenenKullanicilar().size();
        System.out.printf("\u001B[33m Toplam Kullanici Sayisi:%8d , Aktif Kullanici Sayisi : %5d, Engellenen Kullanici Sayisi :%5d%n \u001B[0m",
                toplamKullaniciSayisi, Musteri.getTumKullanicilar().size(), Musteri.getEngellenenKullanicilar().size());
        System.out.println();

    }

    static void tumMusteriIsimleri() {
        System.out.printf("\u001B[33m Kullanici Isimleri:%n \u001B[0m");
        for (Musteri musteri : Musteri.getTumKullanicilar()) {
            System.out.printf("%s%n", musteri.getKullaniciAdi());
        }
    }

    static void satilanUrunler() {

        for (Musteri musteri : Musteri.getTumKullanicilar()) {
            for (Urunler urun : musteri.getAlinanUrunGecmisi()) {
                System.out.printf("\u001B[33m Islem Tarihi : %8s , Satilan Urun Adi : %5s, Satilan Urun Adeti :%5d Urun Fiyati : %5f Toplam Gelir : %5f%n \u001B[0m",
                        urun.getIslemTarihi(), urun.getUrunAdi(), urun.getAlinanUrunAdeti(), urun.getUrunFiyati(), (urun.getUrunFiyati() * urun.getAlinanUrunAdeti()));
            }

        }

    }

    static void tumUrunStogunuGoruntule() {

        System.out.printf("\u001B[%sm%-12s%-20s%-20s%-20s\u001B[0m%n", "34", "Urun Adi",
                "Indirimsiz Fiyat", "Indirim Miktari", "Indirimli Fiyat");
        for (List<Urunler> herBirKategori : UrunlerMethodlar.tumKategoriler) {
            for (Urunler urun : herBirKategori) {
                System.out.printf("\u001B[%sm%-12s%-20.2f%-20.2f%-20.2f\u001B[0m%n",
                        "37", urun.getUrunAdi(), urun.getUrunFiyati(), (urun.getUrunFiyati() / 4), (urun.getUrunFiyati() / 4 * 3));
            }
        }

    }

    static void musteriIstatikleriniGoruntule() {
        int toplamKullaniciSayisi = Musteri.getTumKullanicilar().size() + Musteri.getEngellenenKullanicilar().size();
        System.out.printf("\u001B[33m Toplam Kullanici Sayisi: %8d , Kadin Kullanici Sayisi : %5d, Erkek Kullanici Sayisi :%5d%n \u001B[0m",
                toplamKullaniciSayisi, kadinMusteriSayisi(), erkekMusteriSayisi());
        System.out.println();
    }

    static void musteriEngelle(Scanner scan) {

        System.out.println("Musteri engellemek istediginize emin misiniz?\n" +
                "Evet ise 1'e\n" +
                "Hayir ise 2'e basiniz" +
                "Seciminiz : ");
        int devamSecimi = MusteriMethodlar.intScanner(scan);
        if (devamSecimi == 1) {
            scan.nextLine();
            System.out.print("Lutfen blocklamak istediginiz kullanici adini giriniz : ");
            String engellenecekKullanici = scan.nextLine();
            Musteri engellenecekHesap = MusteriMethodlar.musteriHesapBul(engellenecekKullanici);
            if (engellenecekHesap != null) {
                Musteri.getEngellenenKullanicilar().add(engellenecekHesap);
            } else {
                System.out.print("Engellemek istediginiz kullanici bulunamadi ! \n" +
                        "Tekrar denemek ister misiniz?\n" +
                        "Evet ise 1'e\n" +
                        "Ana menuye donmek isterseniz 2'ye\n" +
                        "Cikis yapmak isterseniz istediginiz bir tusa basiniz : ");

                int cikisSecim = MusteriMethodlar.intScanner(scan);

                if (cikisSecim == 1) {
                    musteriEngelle(scan);
                } else if (cikisSecim == 2) {
                    AnaSayfa.Application();
                } else {
                    System.exit(0);
                }
            }
        }

    }

    static int kadinMusteriSayisi() {
        int kadinSayisi = 0;
        for (Musteri each : Musteri.getTumKullanicilar()) {

            if (each.getKullaniciCinsiyeti().equalsIgnoreCase("kadin")) {
                kadinSayisi++;
            }
        }
        return kadinSayisi;
    }

    static int erkekMusteriSayisi() {
        int erkekSayisi = 0;
        for (Musteri each : Musteri.getTumKullanicilar()) {

            if (each.getKullaniciCinsiyeti().equalsIgnoreCase("erkek")) {
                erkekSayisi++;
            }
        }
        return erkekSayisi;
    }

}