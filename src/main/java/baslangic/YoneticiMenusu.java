package baslangic;

import java.util.Scanner;

public class YoneticiMenusu {
    public static void yoneticiMenu() {
        Scanner scan = new Scanner(System.in);
        int secim;
        do {

            System.out.println("Hesabiniza Basariyla Giris Yapildi.\n" +
                    "1. Müşteri Sayısı\n" +
                    "2. Tüm Müşteri İsimleri\n" +
                    "3. Satılan ürünleri görüntülesin\n" +
                    "4. Sitedeki ürün stogunu görüntülesin\n" +
                    "5. Müsteri istatistiklerini görüntüle\n" +
                    "6. Kullanici engelle\n" +
                    "7. Çıkış Yap\n" +
                    "Lutfen seciminizi yapiniz.");
            secim = scan.nextInt();

            switch (secim) {
                case 1:
                    //Müşteri Sayısı görüntülemek icin bir method olusturmam lazim.
                    YoneticiMethodlar.toplamMusteriSayisi();
                    break;
                case 2:
                    // Tüm Müşteri İsimleri gormek icin method olusturmam lazim.
                    YoneticiMethodlar.tumMusteriIsimleri();
                    break;
                case 3:
                    //Satılan ürünleri görüntülemek icin gerekli methodlari olusturmam lazim
                    YoneticiMethodlar.satilanUrunler();
                    break;
                case 4:
                    //Sitedeki ürün stogunu görüntülemek icin method olusturmam lazim
                    YoneticiMethodlar.tumUrunStogunuGoruntule();

                    break;
                case 5:
                    //Müsteri istatistiklerini görüntüleyebilmek icin method olusturmam lazim
                    YoneticiMethodlar.musteriIstatikleriniGoruntule();

                    break;
                case 6:
                    YoneticiMethodlar.musteriEngelle(scan);
                case 7:
                    System.out.println("Cikis yapiliyor");
                    break;
                default:
                    System.out.println("Gecersiz bir tuslama yaptuniz. Lutfen gecerli bir secenek seciniz.");
                    break;
            }

            System.out.println("Yeni bir islem yapmak ister misiniz? evet ise 1, hayir ise 2 yi seciniz.");

            int devamMi = scan.nextInt();

            if (devamMi != 1) {
                break;
            }

        } while (secim != 6);

    }
}
