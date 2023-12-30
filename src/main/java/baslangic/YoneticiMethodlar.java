package baslangic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YoneticiMethodlar {

    static List<Yonetici> tumYoneticiler = new ArrayList<>();

    public static void tumYoneticiler() {
        tumYoneticiler.add(new Yonetici("Mustafa Uzun", "12345"));
        tumYoneticiler.add(new Yonetici("Mustafa Ubeyde Kayhan", ""));
        tumYoneticiler.add(new Yonetici("Ömer Faruk Osmanoğlu", "123123"));
        tumYoneticiler.add(new Yonetici("Cemal Topal", ""));
        tumYoneticiler.add(new Yonetici("Efehan Akçel", ""));
        tumYoneticiler.add(new Yonetici("Görkem Turhan", ""));
        tumYoneticiler.add(new Yonetici("Rümeysa Dağtekin", ""));
        tumYoneticiler.add(new Yonetici("Yavuz Yılmaz", ""));
        tumYoneticiler.add(new Yonetici("Caner Ünal", ""));
        tumYoneticiler.add(new Yonetici("Büşra İdil", ""));
        tumYoneticiler.add(new Yonetici("Selim Deniz", ""));
    }

    private static Yonetici yoneticiHesapBul(String yoneticiID) {
        for (Yonetici yoneticiHesabi : tumYoneticiler) {
            if (yoneticiHesabi.getYoneticiID().equals(yoneticiID)) {
                return yoneticiHesabi;
            }
        }
        return null;
    }

    static void yoneticiGirisi(Scanner scan) {

        scan.nextLine();
        System.out.print("\nLütfen Yönetici ID nizi Giriniz : ");
        String yoneticiId = scan.nextLine();
        Yonetici mevcutYoneticiHesabi = yoneticiHesapBul(yoneticiId);
        if (mevcutYoneticiHesabi != null) {
            System.out.print("Şifrenizi Giriniz : ");
            String girilenSifre = scan.nextLine();
            if (mevcutYoneticiHesabi.getYoneticiSifre().equals(girilenSifre)) {
                System.out.println();
                YoneticiMenusu.yoneticiMenu(mevcutYoneticiHesabi);
            } else {
                System.out.print("Şifreniz Yanlış !" +
                        "Tekrar Denemek İster Misiniz ?\n" +
                        "Evet ise 1'e\n" +
                        "Ana Menüye Dönmek İsterseniz 2'ye\n" +
                        "Çıkış Yapmak İsterseniz Herhangi Bir Tuşa Basınız : ");

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
            System.out.print("Hesap Bulunamadı !" +
                    "Tekrar Denemek İster Misiniz ?\n" +
                    "Evet ise 1'e\n" +
                    "Ana Menüye Dönmek İsterseniz 2'ye\n" +
                    "Çıkış Yapmak İsterseniz Herhangi Bir Tuşa Basınız : ");

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
        System.out.printf("\u001B[33m Toplam Kullanıcı Sayısı:%8d , Aktif Kullanıcı Sayısı : %5d, Engellenen Kullanıcı Sayısı :%5d%n \u001B[0m",
                toplamKullaniciSayisi, Musteri.getTumKullanicilar().size(), Musteri.getEngellenenKullanicilar().size());
        System.out.println();

    }

    static void tumMusteriIsimleri() {
        System.out.printf("\u001B[33m Kullanıcı İsimleri : %n \u001B[0m");
        for (Musteri musteri : Musteri.getTumKullanicilar()) {
            System.out.printf("%s%n", musteri.getKullaniciAdi());
            System.out.println();
        }
    }

    static void satilanUrunler() {


        System.out.printf("| %-15s | %-35s | %-15s | %-15s | %-20s |\n", "İşlem Tarihi", "Satılan Ürün Adı", "Adet", "Ürün Fiyatı", "Toplam Gelir");
        System.out.println("-------------------------------------------------------------------------------------");

        for (Musteri musteri : Musteri.getTumKullanicilar()) {
            for (Urunler urun : musteri.getAlinanUrunGecmisi()) {
                System.out.printf("| %-15s | %-35s | %-15d | %-15.2f | %-20.2f |\n",
                        urun.getIslemTarihi(), urun.getUrunAdi(), urun.getAlinanUrunAdeti(), urun.getUrunFiyati(), (urun.getUrunFiyati() * urun.getAlinanUrunAdeti()));
            }
        }

        System.out.println("-------------------------------------------------------------------------------------");


    }

    static void tumUrunStogunuGoruntule() {

        System.out.printf("\u001B[%sm%-35s%-20s%-20s\u001B[0m%n", "34", "Ürün Adı",
                "Ürün Fiyatı", "Stok Adeti");
        for (List<Urunler> herBirKategori : UrunlerMethodlar.tumKategoriler) {
            for (Urunler urun : herBirKategori) {
                System.out.printf("\u001B[%sm%-35s%-20.2f%-20d\u001B[0m%n",
                        "37", urun.getUrunAdi(), urun.getUrunFiyati(), urun.getStokAdeti());
            }
        }
    }

    static void musteriIstatikleriniGoruntule() {
        int toplamKullaniciSayisi = Musteri.getTumKullanicilar().size() + Musteri.getEngellenenKullanicilar().size();
        System.out.printf("\u001B[33m Toplam Kullanıcı Sayısı: %8d , Kadın Kullanıcı Sayısı : %5d, Erkek Kullanıcı Sayısı :%5d%n \u001B[0m",
                toplamKullaniciSayisi, kadinMusteriSayisi(), erkekMusteriSayisi());
        System.out.println();
    }

    static void musteriEngelle(Scanner scan) {

        while (true) {
            System.out.print("\nMüşteri Engellemek İstediğinize Emin Misiniz?\n" +
                    "Evet ise 1'e\n" +
                    "Hayır İse Herhangi Bir Rakama Basınız. " +
                    "Seçiminiz : ");
            int devamSecimi = MusteriMethodlar.intScanner(scan);
            if (devamSecimi == 1) {
                scan.nextLine();
                System.out.print("Lütfen Engellemek İstediğiniz Kullanıcı Adını Giriniz : ");
                String engellenecekKullanici = scan.nextLine();
                Musteri engellenecekHesap = MusteriMethodlar.musteriHesapBul(engellenecekKullanici);
                if (engellenecekHesap != null) {
                    Musteri.getEngellenenKullanicilar().add(engellenecekHesap);
                    System.out.println("Kullanıcı Başarıyla Engellenmiştir.");
                    Musteri.getTumKullanicilar().remove(engellenecekHesap);
                    break;

                } else {
                    System.out.print("\nEngellemek İstediğiniz Kullanıcı Adı Bulunamadı ! \n" +
                            "Tekrar Denemek İster misiniz? " +
                            "Evet ise 1'e\n" +
                            "Ana Menüye Dönmek İsterseniz Herhangi Bir Rakama Basınız : ");


                    int cikisSecim = MusteriMethodlar.intScanner(scan);

                    if (cikisSecim != 1) {
                        break;
                    }
                }
            } else {
                break;
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