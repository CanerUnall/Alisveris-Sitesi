package baslangic;

import java.util.Scanner;

public class MusteriMenusu {

    public static void musteriMenu(Scanner scan, Musteri mevcutMusteriHesabi) {

        int secim;
        do {
            System.out.print("\n" +
                    "\n" +
                    "\u001B[32mSayın " + mevcutMusteriHesabi.getKullaniciAdi() +
                    " Hoş Geldiniz ! Keyifli Alışverişler Dileriz :-)\n" +
                    "1. Ürünleri Görüntüle\n" +
                    "2. Hesaba Bakiye Yükle\n" +
                    "3. Hesap Bakiyesini Nakite Çevir\n" +
                    "4. Alışveriş Sepetini Görüntüle\n" +
                    "5. İndirimli Ürünleri Görüntüle\n" +
                    "6. Hesap Geçmişini Görüntüle\n" +
                    "7. Hesap Ayarları\n" +
                    "8. Çıkış Yap\n" +
                    "Lütfen Seçiminizi Yapınız : \u001B[0m");
            secim = MusteriMethodlar.intScanner(scan);
            switch (secim) {
                case 1:
                    MusteriMethodlar.urunleriGoruntule(scan, mevcutMusteriHesabi);
                    break;
                case 2:
                    MusteriMethodlar.bakiyeYukle(scan, mevcutMusteriHesabi);
                    break;
                case 3:
                    MusteriMethodlar.nakiteCevir(scan, mevcutMusteriHesabi);
                    break;
                case 4:
                    MusteriMethodlar.sepetiGoruntule(scan, mevcutMusteriHesabi);
                    break;
                case 5:
                    MusteriMethodlar.indirimliUrunleriGoruntule(scan, mevcutMusteriHesabi);
                    break;
                case 6:
                    MusteriMethodlar.hesapGecmisiniGoruntule(mevcutMusteriHesabi, scan);
                    break;
                case 7:
                    MusteriMethodlar.hesapAyarlari(scan, mevcutMusteriHesabi);
                    break;
                case 8:
                    System.out.println("\u001B[31mÇıkış Yapılıyor !\u001B[0m");
                    System.out.println();
                    break;
                default:
                    System.out.println("\u001B[31m Geçersiz Bir Tuşlama Yaptınız ! Lütfen Geçerli Bir Seçenek Seçiniz !\u001B[0m");
                    break;
            }
        } while (secim != 8);
    }
}