package baslangic;

import java.util.Scanner;

public class MisafirMenu {
    public static void misafirMenu() {
        Musteri misafirHesap = new Musteri();
        Scanner scan = new Scanner(System.in);
        int secim;
        do {

            System.out.println("xxx Sitesine Hosgeldiniz.\n" +
                    "1. Ürünleri görüntüle\n" +
                    "2. Alışveriş sepetini görüntüle\n" +
                    "3. Ödeme noktasına ilerle.");
            secim = scan.nextInt();

            switch (secim) {
                case 1:

                    MusteriMethodlar.urunleriGoruntule(scan, misafirHesap);

                    break;
                case 2:
                    MusteriMethodlar.sepetiGoruntule(scan, misafirHesap);

                    break;
                case 3:

                   // MusteriMethodlar.misafirBankaKartiIleOde(misafirHesap,scan,misafirHesap.getAlisverisSepeti().);

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
