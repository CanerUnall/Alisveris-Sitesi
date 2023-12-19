package baslangic;

import java.util.Scanner;

public class AnaSayfa {
    public void Application() {
        Scanner scan = new Scanner(System.in);
        int secim;
        do {

            System.out.println("xxx Sitesine Hoşgeldiniz.\n" +
                    "1. Yeni Müşteri Hesabi Aç.\n" +
                    "2. Müşteri Hesabına Giriş Yap\n" +
                    "3. Misafir olarak alışverişe devam et.\n" +
                    "4. Yönetici olarak Giriş Yap.\n" +
                    "5. Çıkış yap.\n" +
                    "Seçiminizi giriniz :");
            secim = scan.nextInt();

            switch (secim) {
                case 1:
                    //Yeni Müşteri Hesabı Açmak icin bir method olusturmam lazim.

                    MusteriMethodlar.yeniHesapAc(scan);
                    System.out.println("Yeni Müşteri Hesabı Açmak icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 2:
                    MusteriMethodlar.musteriGirisi(scan);
                    //Müşteri Hesabına Giriş Yapmak icin method olusturmam lazim.
                    System.out.println("Müşteri Hesabına Giriş Yapmak icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 3:
                    //Misafir olarak alışverişe devam etmek icin gerekli methodlari olusturmam lazim
                    MisafirMenu.misafirMenu();
                    System.out.println("Misafir olarak alışverişe devam etmek icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 4:
                    //Yönetici olarak Giriş Yapmak icin method olusturmam lazim
                    YoneticiMenusu.yoneticiMenu();
                    System.out.println("Yönetici olarak Giriş Yapmak icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 5:
                    System.out.println("Çıkış Yapılıyor.");
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız. Lütfen geçerli bir seçim yapınız.");
                    break;
            }


        } while (secim!=5);

    }



}
