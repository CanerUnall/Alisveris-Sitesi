package baslangic;

import java.util.Scanner;

public class MisafirMenu {
    public static void misafirMenu() {
        Scanner scan = new Scanner(System.in);
        do {

            System.out.println("xxx Sitesine Hosgeldiniz.\n" +
                    "1. Ürünleri görüntüle\n" +
                    "2. Alışveriş sepetini görüntüle\n" +
                    "3. Ödeme noktasına ilerle.");
            int secim = scan.nextInt();

            switch (secim) {
                case 1:
                    //Ürünleri görüntülemek icin bir method olusturmam lazim.

                    System.out.println("Ürünleri görüntülemek icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 2:

                    //Alışveriş sepetini görüntülemek icin method olusturmam lazim.
                    System.out.println("Alışveriş sepetini görüntülemek icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                case 3:
                    //Odeme noktasina ilerlemek icin gerekli methodlari olusturmam lazim
                    System.out.println("Ödeme noktasina ilerlemek icin methodlar henuz hazir degil\n" +
                            "ama dongu calisiyor.");
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız. Lütfen geçerli bir seçim yapınız.");
                    break;
            }

            System.out.println("Yeni bir işlem yapmak ister misiniz? (Evet ise 1, Hayır ise 2'yi seçiniz.)");

            int devamMi = scan.nextInt();

            if (devamMi != 1) {
                break;
            }

        } while (true);

    }


}
