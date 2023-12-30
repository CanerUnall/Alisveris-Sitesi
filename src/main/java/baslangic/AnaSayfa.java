package baslangic;

import java.util.Scanner;

public class AnaSayfa {
    public static void Application() {

        Scanner scan = new Scanner(System.in);
        int secim;
        do {
            System.out.println();
            System.out.print("\u001B[36m***Dev01*** Alışveriş Sitesine Hoşgeldiniz.\n" +
                    "1. Yeni Müşteri Hesabı Aç\n" +
                    "2. Müşteri Hesabına Giriş Yap\n" +
                    "3. Misafir Olarak Alışverişe Devam Et\n" +
                    "4. Yönetici Olarak Giriş Yap\n" +
                    "5. Çıkış yap\n" +
                    "Seçiminizi Giriniz : \u001B[0m");
            secim = MusteriMethodlar.intScanner(scan);

            switch (secim) {
                case 1:
                    MusteriMethodlar.yeniHesapAc(scan);
                    break;
                case 2:
                    MusteriMethodlar.musteriGirisi(scan);
                    break;
                case 3:
                    MisafirMenu.misafirMenu();
                    break;
                case 4:
                    YoneticiMethodlar.yoneticiGirisi(scan);
                    break;
                case 5:
                    System.out.println("\u001B[31mÇıkış Yapılıyor.\u001B[0m");
                    break;
                default:
                    System.out.println("\u001B[31mGeçersiz Bir Seçim Yaptınız. Lütfen Tekrar Deneyin.\u001B[0m");
                    break;
            }
        } while (secim != 5);
    }
}
