package baslangic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MisafirMenu {
    public static void misafirMenu() {
        List<Urunler> misafirSepet = new ArrayList<>();
        List<Urunler> misafirAlinanUrunGecmisi = new ArrayList<>();

        Musteri misafirHesap = new Musteri(misafirSepet, misafirAlinanUrunGecmisi);

        Scanner scan = new Scanner(System.in);
        int secim;
        do {
            System.out.print("\nSayın Misafir Kullanıcı Hoş Geldiniz. Keyifli Alışverişler Dileriz :-)\n" +
                    "1. Ürünleri Görüntüle\n" +
                    "2. Alışveriş Sepetini Görüntüle\n" +
                    "3. İndirimli Ürünleri Görüntüle\n" +
                    "4. Ana Menüye Dön\n" +
                    "Seçiminizi Giriniz : "
            );
            secim = MusteriMethodlar.intScanner(scan);
            switch (secim) {
                case 1:
                    MusteriMethodlar.urunleriGoruntule(scan, misafirHesap);
                    break;
                case 2:
                    MusteriMethodlar.sepetiGoruntule(scan, misafirHesap);
                    break;
                case 3:
                    MusteriMethodlar.indirimliUrunleriGoruntule(scan, misafirHesap);
                    break;
                case 4:
                    System.out.println("\u001B[31mAna Menüye Dönülüyor.\u001B[0m");
                    break;
                default:
                    System.out.println("\u001B[31mGeçersiz Bir Seçim Yaptınız. Lütfen Lütfen Tekrar Deneyin.\u001B[0m");
                    break;
            }

        } while (secim!=4);
    }
}
