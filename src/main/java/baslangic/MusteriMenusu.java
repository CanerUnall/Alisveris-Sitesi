package baslangic;

import java.util.Scanner;

public class MusteriMenusu {

    public static void musteriMenu() {
        Scanner scan = new Scanner(System.in);
        do {

            System.out.println("Hesabiniza Basariyla Giris Yapildi.\n" +
                    "\n" +
                    "1. Ürünleri görüntüle\n" +
                    "2. Hesaba bakiye yükleme\n" +
                    "3. Hesap bakiyesini nakite çevirme\n" +
                    "4. Alışveriş sepetini görüntüle\n" +
                    "5. İndirimli ürünleri görüntüleyebilsin\n" +
                    "6. Hesap geçmişini görüntülesin\n" +
                    "7. Hesap ayarları\n" +
                    "8. Çıkış Yap\n" +
                    "Lutfen seciminizi yapiniz.");
            int secim = scan.nextInt();

            switch (secim) {
                case 1:
                    //Ürünleri görüntülemek icin bir method olusturmam lazim.

                    System.out.println("Ürünleri görüntülemek icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 2:
                    // Hesaba bakiye yüklemek icin method olusturmam lazim.
                    System.out.println("Hesaba bakiye yüklemek icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 3:
                    //Hesap bakiyesini nakite çevirmek icin gerekli methodlari olusturmam lazim
                    System.out.println("Hesap bakiyesini nakite çevirmek icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 4:
                    //Alışveriş sepetini görüntülemek icin method olusturmam lazim
                    System.out.println("Alışveriş sepetini görüntülemek icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 5:
                    //İndirimli ürünleri görüntüleyebilmek icin method olusturmam lazim
                    System.out.println("İndirimli ürünleri görüntüleyebilmek icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 6:
                    //Hesap geçmişini görüntülemek icin method olusturmam lazim
                    System.out.println("Hesap geçmişini görüntülemek icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 7:
                    //Hesap ayarları icin method olusturmam lazim
                    System.out.println("Hesap ayarları icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 8:

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

        } while (true);

    }
}
