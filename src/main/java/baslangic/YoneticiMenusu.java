package baslangic;

import java.util.Scanner;

public class YoneticiMenusu {
    public static void yoneticiMenu(Yonetici mevcutYoneticiHesabi) {
        Scanner scan = new Scanner(System.in);
        int secim;
        do {
            System.out.println();
            System.out.print("\u001B[35mSayın " + mevcutYoneticiHesabi.getYoneticiID() + " Hoş Geldiniz !\n" +
                    "Hesabınıza Başarıyla Giriş Yapıldı\n" +
                    "1. Müşteri Sayısı\n" +
                    "2. Tüm Müşteri İsimleri\n" +
                    "3. Satılan Ürünleri Görüntüle\n" +
                    "4. Ürün Stoğunu Görüntüle\n" +
                    "5. Müsteri İstatistiklerini Görüntüle\n" +
                    "6. Kullanıcı Engelle\n" +
                    "7. Çıkış Yap\n" +
                    "Lütfen Seçiminizi Yapınız : \u001B[0m");
            secim = MusteriMethodlar.intScanner(scan);

            switch (secim) {
                case 1:
                    YoneticiMethodlar.toplamMusteriSayisi();
                    break;
                case 2:
                    YoneticiMethodlar.tumMusteriIsimleri();
                    break;
                case 3:
                    YoneticiMethodlar.satilanUrunler();
                    break;
                case 4:
                    YoneticiMethodlar.tumUrunStogunuGoruntule();
                    break;
                case 5:
                    YoneticiMethodlar.musteriIstatikleriniGoruntule();
                    break;
                case 6:
                    YoneticiMethodlar.musteriEngelle(scan);
                    break;
                case 7:
                    System.out.println("\u001B[31mÇıkıs Yapılıyor !\u001B[0m");
                    break;
                default:
                    System.out.println("\u001B[31mGeçersiz Bir Tuşlama Yaptınız. Lütfen Geçerli Bir Seçim Giriniz.\u001B[0m");
                    break;
            }
            scan.nextLine();
            System.out.print("\nYeni Bir İşlem Yapmak İster Misiniz? Evet ise 1, Hayır ise 2'yi Seçiniz : ");
            int devamMi = MusteriMethodlar.intScanner(scan);
            if (devamMi != 1) {
                break;
            }
        } while (secim != 7);
    }
}
