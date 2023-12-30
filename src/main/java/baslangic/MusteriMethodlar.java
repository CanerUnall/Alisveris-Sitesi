package baslangic;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class MusteriMethodlar {

    public static int intScanner(Scanner scan) {
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Hata: Lütfen Geçerli Bir Tamsayı Değer Girin.");
                scan.nextLine();
            }
        }
    }

    public static double doubleScanner(Scanner scan) {
        while (true) {
            try {
                return scan.nextDouble();
            } catch (InputMismatchException e) {
                System.err.println("Hata: Lütfen Geçerli Bir Double Değer Girin.");
                scan.nextLine();
            }
        }
    }

    public static void yeniHesapAc(Scanner scan) {
        scan.nextLine();
        System.out.print("Lütfen Adınızı Giriniz : ");

        String kullaniciAdi = scan.nextLine();

        String kullaniciSifre = sifreBelirle(scan);

        int kullaniciYasi;
        do {
            System.out.print("Lütfen Yaşınızı Giriniz : ");

            kullaniciYasi = intScanner(scan);
            //scan.nextLine();
            if (kullaniciYasi > 17) {
                break;
            } else {
                System.out.println("Kullanıcı Yaşı 18'den Büyük Olmalıdır ! ");
            }

        } while (true);
        String kullaniciCinsiyeti;
        scan.nextLine();
        while (true) {

            System.out.print("Lütfen cinsiyetinizi giriniz (erkek/kadin): ");
            kullaniciCinsiyeti = scan.next();
            if ((kullaniciCinsiyeti.equalsIgnoreCase("erkek")) || (kullaniciCinsiyeti.equalsIgnoreCase("kadin"))) {
                break;
            } else {
                System.out.println("Lütfen cinsiyetinizi 'erkek' ya da 'kadin' olarak giriniz!");
            }

        }

        String kartUstundekiIsim;
        scan.nextLine();
        boolean isimEslestiMi = false;
        while (!isimEslestiMi) {
            System.out.print("Kart Üzerindeki İsmi Giriniz : ");
            kartUstundekiIsim = scan.nextLine();

            if (kartUstundekiIsim.equals(kullaniciAdi)) {
                isimEslestiMi = true;

            } else {
                System.out.println("Sadece Kendi Adınıza Kayıtlı Kart ile İşlem Yapabilirsiniz ! ");
            }
        }

        String bankaKartiNumarasi = null;
        String bankaKartiGuvenlikKodu = null;
        String sonKullanmaTarihi = null;

        kartBilgileriniAl(scan, bankaKartiNumarasi, bankaKartiGuvenlikKodu, sonKullanmaTarihi);

        System.out.print("Lütfen Ürünlerin Teslimi İçin Bir Kargo Adresi Giriniz : ");
        String kargoAdresi = scan.nextLine();
        String tel = telefonBelirle(scan);

        String mailAdresi = mailBelirle(scan);

        System.out.print("Lütfen Yüklemek İstediğiniz Bakiyeyi Giriniz : ");
        double yuklenenBakiye = doubleScanner(scan);

        double musteriBonus = yuklenenBakiye / 20;

        System.out.println("\nHesabınız Başarıyla Olusturuldu.");
        System.out.println("Güncel Bonusunuz : " + musteriBonus);

        String kullaniciNumarasi = Musteri.getKullaniciKayitNumarasi() + "";
        Musteri.setKullaniciKayitNumarasi(Musteri.getKullaniciKayitNumarasi() + 1);

        System.out.println("Benzersiz Kullanıcı Numarası: " + kullaniciNumarasi);
        System.out.println("Siteye Giriş İçin Benzersiz Kullanıcı Numaranızı Veya Kullanıcı Adınızı Kullanabilirsiniz.");

        List<Urunler> alisverisSepetiAcilisi = new ArrayList<>();
        List<Musteri> bakiyeYuklemeGecmisiAcilisi = new ArrayList<>();
        List<Musteri> bakiyeCekmeGecmisiAcilisi = new ArrayList<>();
        List<Urunler> alinanUrunGecmisiAcilisi = new ArrayList<>();
        List<Musteri> bonusGecmisiAcilisi = new ArrayList<>();
        List<Musteri> harcamaGecmisi = new ArrayList<>();

        Musteri musTeri = new Musteri(kullaniciAdi, kullaniciSifre, kullaniciYasi,
                kullaniciCinsiyeti, bankaKartiNumarasi, sonKullanmaTarihi, bankaKartiGuvenlikKodu,
                kargoAdresi, tel, mailAdresi, yuklenenBakiye, musteriBonus, kullaniciNumarasi,
                alisverisSepetiAcilisi, alinanUrunGecmisiAcilisi, bakiyeCekmeGecmisiAcilisi,
                bakiyeYuklemeGecmisiAcilisi, bonusGecmisiAcilisi, harcamaGecmisi);

        Musteri.getTumKullanicilar().add(musTeri);

        Musteri bakiyeYuklemeIslemi = new Musteri(LocalDate.now().toString(), 0, yuklenenBakiye, yuklenenBakiye);
        musTeri.getBakiyeYuklemeGecmisi().add(bakiyeYuklemeIslemi);

        Musteri bonusGecmisi = new Musteri(musteriBonus, LocalDate.now().toString(), musTeri.getMusteriBonus());
        musTeri.getBonusGecmisi().add(bonusGecmisi);

        MusteriMenusu.musteriMenu(scan, musTeri);

    }

    public static String sifreBelirle(Scanner scan) {

        do {
            System.out.print("Lütfen En Az Sekiz Karakterden Oluşan ve Bir Büyük, Bir Küçük İçeren Bir Kullanıcı Şifresi Belirleyiniz : ");
            String kullaniciSifre = scan.nextLine();
            if (kullaniciSifre.length() > 7) {
                for (int i = 0; i < kullaniciSifre.length(); i++) {
                    if (kullaniciSifre.matches(".*[0-9].*") && kullaniciSifre.matches(".*[A-Z].*") && kullaniciSifre.matches(".*[a-z].*")) {
                        System.out.println("\u001B[32mStrong Password\u001B[0m");
                        return kullaniciSifre;
                    }
                }
            } else {
                System.out.println("\u001B[34m Şifre En Az Sekiz Karakter Olmalı \u001B[0m ");

            }
        } while (true);
    }

    public static String telefonBelirle(Scanner scan) {

        do {
            System.out.print("Lütfen 10 Haneden Oluşan Telefon Numaranızı Başında Sıfır Olmadan Giriniz : ");
            String tel = scan.nextLine();
            if (tel.matches("\\d{10}")) {
                return tel;
            } else System.out.println("Lütfen En Az 10 Haneden Oluşan Bir Telefon Numarası Giriniz !");
        } while (true);
    }

    public static String mailBelirle(Scanner scan) {

        do {
            System.out.print("Lütfen Mail Adresinizi Giriniz (...@gmail.com||@outlook.com||@hotmail.com) : ");
            String mailAdresi = scan.nextLine();
            if (mailAdresi.endsWith("@gmail.com") || (mailAdresi.endsWith("@outlook.com") || (mailAdresi.endsWith("@hotmail.com")))) {
                return mailAdresi;
            } else
                System.out.println("Lütfen Mail Adresi Formatında Giriniz (...@gmail.com || @outlook.com || @hotmail.com) !");
        } while (true);
    }

    static void kartBilgileriniAl(Scanner scan, String kartNumarasi, String sonKullanmaTarihi,
                                  String cvv) {
        scan.nextLine();
        while (true) {
            System.out.print("Lütfen 16 Haneden Oluşan ****-****-****-**** Formatında Bank Kart Numaranızı girin : ");
            kartNumarasi = scan.nextLine();
            if (validKartNo(kartNumarasi)) {
                break;
            } else System.out.println("Kart Numarası 16 Haneden Oluşmalıdır.");
        }

        do {
            System.out.print("Lütfen Karıtınızın Son Kullanma Tarihini(MM/YYYY) Formatında Girin : ");
            sonKullanmaTarihi = scan.nextLine();
            if (validSonKullanmaTarihi(sonKullanmaTarihi)) {
                break;
            } else System.out.println("lutfen belirtilen formatta giriniz");

        } while (true);
        do {
            System.out.print("Lütfen Kartın Arkasında Bulunan 3 Haneli Güvenlik Kodunu girin : ");
            cvv = scan.nextLine();
            if (validCVV(cvv)) {
                break;
            } else {
                System.out.println("Lütfen 3 Haneden Oluşan Bank Kart Numarası Giriniz !");
            }
        } while (true);
    }

    static void bankKartIsimKontrolu(Scanner scan, Musteri mevcutMusteriHesabi, String bankaKartiUzerindekiISim) {

        scan.nextLine();
        do {

            bankaKartiUzerindekiISim = scan.nextLine();
            if (mevcutMusteriHesabi.getKullaniciAdi().equals(bankaKartiUzerindekiISim)) {
                break;
            } else {
                System.out.print("Sadece Kendi Adiniza Kayıtlı Bir Banka Kartı ile İşlem Yapabilirsiniz ! Tekrar Deneyiniz : ");
            }
        } while (true);
    }

    static boolean sifreKontrolu(Scanner scan, Musteri mevcutMusteriHesabi, int counter) {
        do {
            scan.nextLine();
            System.out.print("\nGüvenlik Amaciyla Lütfen Önce Şifrenizi Giriniz : ");
            String eskiSifre = scan.nextLine();
            if (mevcutMusteriHesabi.getKullanıcıSifre().equals(eskiSifre)) {
                return true;

            } else {
                counter--;
                System.out.print("Şifrenizi Yanlış Girdiniz !" + counter + " Defa Deneme Hakkınız Kaldı !\n" +
                        "Tekrar Denemek İçin 1'e\n" +
                        "Geri Dönmek İçin Herhangi Bir Rakama Basınız :  ");

                int devamMi = intScanner(scan);
                if (devamMi != 1) {
                    return false;
                }

                if (counter == 0) {

                    Musteri.getEngellenenKullanicilar().add(mevcutMusteriHesabi);
                    Musteri.getTumKullanicilar().remove(mevcutMusteriHesabi);

                    System.out.println("Şifrenizi 5 defa Yanlış Girdiniz !\n" +
                            "Hesabınız Bloke Edildi !\n" +
                            "Lütfen Müşteri Hizmetlerine Ulaşınız !");
                    System.exit(0);
                }

            }
        } while (true);
    }

    static void urunleriGoruntule(Scanner scan, Musteri mevcutMusteriHesabi) {
        do {
            System.out.println();
            System.out.println("\u001B[34mLutfen kategori seciniz.\n" +
                    "1. Kırtasiye\n" +
                    "2. Manav\n" +
                    "3. Tekstil\n" +
                    "4. Kişisel Bakım\n" +
                    "5. Hırdavat\n" +
                    "6. Spor\n" +
                    "7. Oto Eksesuar\n" +
                    "8. Elektronik\n" +
                    "9. Hayvan Ürünleri\n" +
                    "10. Kozmetik\u001B[0m");
            int secim = 0;

            while (true) {
                System.out.print("Lütfen 1 ile 10 arasında bir sayı giriniz : ");
                secim = intScanner(scan);
                if (secim > 0 && secim < 11) {
                    break;
                } else {
                    System.out.println("Hatalı Seçim ! Lütfen tekrar deneyiniz.");
                }
            }

            switch (secim) {
                case 1:
                    if (UrunlerMethodlar.kirtasiyeUrunleriIndirimdemi) {
                        urunKategorisiniPrintFYazdir(UrunlerMethodlar.kirtasiye, scan, mevcutMusteriHesabi);
                    } else {
                        urunleriListele(UrunlerMethodlar.kirtasiye, mevcutMusteriHesabi);
                    }
                    break;

                case 2:
                    if (UrunlerMethodlar.manavUrunleriIndirimdemi) {
                        urunKategorisiniPrintFYazdir(UrunlerMethodlar.manav, scan, mevcutMusteriHesabi);
                    } else {
                        urunleriListele(UrunlerMethodlar.manav, mevcutMusteriHesabi);
                    }

                    break;

                case 3:
                    if (UrunlerMethodlar.tekstilUrunleriIndirimdemi) {
                        urunKategorisiniPrintFYazdir(UrunlerMethodlar.tekstil, scan, mevcutMusteriHesabi);
                    } else {
                        urunleriListele(UrunlerMethodlar.tekstil, mevcutMusteriHesabi);
                    }

                    break;

                case 4:
                    if (UrunlerMethodlar.kisiselBakimUrunleriIndirimdemi) {
                        urunKategorisiniPrintFYazdir(UrunlerMethodlar.kisiselBakim, scan, mevcutMusteriHesabi);
                    } else {
                        urunleriListele(UrunlerMethodlar.kisiselBakim, mevcutMusteriHesabi);
                    }

                    break;

                case 5:
                    if (UrunlerMethodlar.hirdavatUrunleriIndirimdemi) {
                        urunKategorisiniPrintFYazdir(UrunlerMethodlar.hirdavat, scan, mevcutMusteriHesabi);
                    } else {
                        urunleriListele(UrunlerMethodlar.hirdavat, mevcutMusteriHesabi);
                    }

                    break;

                case 6:
                    if (UrunlerMethodlar.sporUrunleriIndirimdemi) {
                        urunKategorisiniPrintFYazdir(UrunlerMethodlar.spor, scan, mevcutMusteriHesabi);
                    } else {
                        urunleriListele(UrunlerMethodlar.spor, mevcutMusteriHesabi);
                    }

                    break;

                case 7:
                    if (UrunlerMethodlar.otoAksesuarUrunleriIndirimdemi) {
                        urunKategorisiniPrintFYazdir(UrunlerMethodlar.otoAksesuar, scan, mevcutMusteriHesabi);
                    } else {
                        urunleriListele(UrunlerMethodlar.otoAksesuar, mevcutMusteriHesabi);
                    }

                    break;

                case 8:
                    if (UrunlerMethodlar.elekronikUrunleriIndirimdemi) {
                        urunKategorisiniPrintFYazdir(UrunlerMethodlar.elektronik, scan, mevcutMusteriHesabi);
                    } else {
                        urunleriListele(UrunlerMethodlar.elektronik, mevcutMusteriHesabi);
                    }

                    break;

                case 9:
                    if (UrunlerMethodlar.hayvanUrunleriUrunleriIndirimdemi) {
                        urunKategorisiniPrintFYazdir(UrunlerMethodlar.hayvanUrunleri, scan, mevcutMusteriHesabi);
                    } else {
                        urunleriListele(UrunlerMethodlar.hayvanUrunleri, mevcutMusteriHesabi);
                    }

                    break;

                case 10:
                    if (UrunlerMethodlar.kisiselBakimUrunleriIndirimdemi) {
                        urunKategorisiniPrintFYazdir(UrunlerMethodlar.kozmetik, scan, mevcutMusteriHesabi);
                    } else {
                        urunleriListele(UrunlerMethodlar.kozmetik, mevcutMusteriHesabi);
                    }

                    break;
            }

            System.out.print("\nÜrün Seçmeye Devam Etmek İster Misiniz ? " +
                    "\nEvet İçin 1'e " +
                    "\nMüsteri Menüsüne Dönmek İçin Herhangi Bir Tuşa basınız : ");
            int secimDevam = intScanner(scan);
            if (secimDevam != 1) {
                break;
            }

        } while (true);

    }

    public static void urunleriListele(List<Urunler> urunListesi, Musteri mevcutMusteriHesabi) {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        int urunNo = 0;
        int urunKodu = 1;
        System.out.printf("\u001B[34m%-35s   %-20s   %-20s  \n", "Ürün Adı", "Fiyatı", "Stokta Kalan\u001B[0m");
        System.out.printf("%-35s   %-20s   %-20s  \n", "--------", "------", "------------");
        for (Urunler w : urunListesi) {
            System.out.printf("\u001B[36m%-35s   %-20.2f   %-20d  \u001B[0m", urunKodu + ") " + w.getUrunAdi(), w.getUrunFiyati(), w.getStokAdeti());
            urunKodu++;
            System.out.println();
        }

        System.out.print("Sepete Ürüm Eklemek İsterseniz 1'e\n" +
                "Ana Menüye Gitmek İçin Herhangi Bir Tuşa Basabilirsiniz : ");
        int eklemeyeDevam = intScanner(scan);
        if (eklemeyeDevam == 1) {
            System.out.print("\nLütfen Sepete Eklemek İstediğiniz Ürünü Seçiniz : ");
            urunNo = scan.nextInt();
            sepeteEkle(mevcutMusteriHesabi, urunListesi, urunNo);

        }
    }

    static void sepeteEkle(Musteri mevcutMusteriHesabi, List<Urunler> urunListesi, int urunNo) {

        Scanner scan = new Scanner(System.in);
        double toplam = 0;
        if (urunNo > 0 && urunNo <= urunListesi.size()) {
            Urunler secilenUrun = urunListesi.get(urunNo - 1);

            System.out.print("Kaç adet eklemek istiyorsunuz ? : ");
            int adet = intScanner(scan);
            System.out.println();
            if (adet > 0 && adet <= secilenUrun.getStokAdeti()) {

                mevcutMusteriHesabi.getAlisverisSepeti().add(new Urunler(secilenUrun.getUrunAdi(), secilenUrun.getUrunFiyati(), adet));

                sepettekiUrunler(mevcutMusteriHesabi, toplam);

                urunListesi.get(urunNo - 1).setStokAdeti(secilenUrun.getStokAdeti() - adet);
            } else {
                System.out.println("Geçersiz Adet Seçimi Yaptınız ! Lütfen Stok Durumunu Kontrol Edip Tekrar Deneyiniz.");
            }
        } else {
            System.out.println("Geçersiz Ürün Numarası.");
        }
    }

    static void sepetiGoruntule(Scanner scan, Musteri mevcutMusteriHesabi) {
        System.out.println();
        double toplam = 0;

        sepettekiUrunler(mevcutMusteriHesabi, toplam);

        if (musteriHesapBul(mevcutMusteriHesabi.getKullaniciAdi()) != null) {
            System.out.print("\nHesap Bakiyesi ile Ödeme Yapmak İçin 1'e\n" +
                    "Banka Kartı ile Ödeme Yapmak icin 2'e\n" +
                    "Ana Menüye Donmek İçin İstediginiz Herhangi Bir Tuşa\n" +
                    "Basınız : ");

            int secim = intScanner(scan);

            if (secim == 1) {
                siteBakiyesiIleOde(scan, toplam, mevcutMusteriHesabi);
            } else if (secim == 2) {
                bankaKartiIleOde(mevcutMusteriHesabi, scan, toplam);

            }
        } else {
            System.out.print(
                    "\nBanka Kartı ile Ödeme Yapmak İçin 1'e\n" +
                            "Ana Menüye Dönmek İçin İstediğiniz Herhangi Bir Tuşa\n" +
                            "Basınız : ");

            int secim = intScanner(scan);

            if (secim == 1) {
                bankaKartiIleOde(mevcutMusteriHesabi, scan, toplam);
            }
        }
    }

    static void sepettekiUrunler(Musteri mevcutMusteriHesabi, double toplam) {

        System.out.printf("%-35s%-20s%-20s%-20s%n", "Ürün Adı", "Adet", "Fiyat", "Toplam Fiyat");
        System.out.printf("%-35s%-20s%-20s%-20s%n", "-------------------", "--------------------", "--------------------", "-------------");

        for (Urunler sepet : mevcutMusteriHesabi.getAlisverisSepeti()) {

            double toplamFiyat = sepet.getUrunFiyati() * sepet.getStokAdeti();

            System.out.printf("%-35s%-20d%-20.2f%-20.2f%n", sepet.getUrunAdi(), sepet.getStokAdeti(), sepet.getUrunFiyati(), toplamFiyat);
            toplam += toplamFiyat;
        }

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("Toplam Fiyat: %66.2f%n", toplam);
    }

    static public void bakiyeYukle(Scanner scan, Musteri mevcutMusteriHesabi) {

        System.out.print("\nBonuslari Site Bakiyesine Dönüştürerek Bakiye Yüklemek İsterseniz 1'e\n" +
                "Banka Kartı Aracılığıyla Bakiye Yüklemek İsterseniz 2'e Basınız : ");
        int ilkSecim = intScanner(scan);
        if (ilkSecim == 1) {
            double islemOncesiSiteBakiyesi = mevcutMusteriHesabi.getSiteBakiyesi();
            double donusturulenPara = mevcutMusteriHesabi.getMusteriBonus() * 0.10;
            mevcutMusteriHesabi.setSiteBakiyesi(mevcutMusteriHesabi.getSiteBakiyesi() + donusturulenPara);
            mevcutMusteriHesabi.setMusteriBonus(0);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedDouble = decimalFormat.format(donusturulenPara);

            System.out.println("\nHesabınızdaki Bonuslardan Kazancınız " + formattedDouble + "\nMevcut Bakiyeniz : " +
                    mevcutMusteriHesabi.getSiteBakiyesi() + "\nGüncel Bonusunuz : 0");
            Musteri yuklenenBakiye = new Musteri(LocalDate.now().toString(), islemOncesiSiteBakiyesi, donusturulenPara, mevcutMusteriHesabi.getSiteBakiyesi());
            mevcutMusteriHesabi.getBakiyeYuklemeGecmisi().add(yuklenenBakiye);
        } else if (ilkSecim == 2) {


            System.out.print("\nMevcut Banka Kartınızı Kullanarak Yükleme Yapmak İçin 1'e\n" +
                    "Yeni Bir Banka Kartı Kullanmak İçin 2'ye Basınız : ");
            int secim = intScanner(scan);
            if (secim == 1) {

                System.out.print("\nNe Kadar Bakiye Yüklemek İstersiniz ? : ");
                double yuklenecekMiktar = doubleScanner(scan);
                double islemOncesiSiteBakiyesi = mevcutMusteriHesabi.getSiteBakiyesi();
                mevcutMusteriHesabi.setSiteBakiyesi(mevcutMusteriHesabi.getSiteBakiyesi() + yuklenecekMiktar);
                System.out.println("Sistemde Kayıtlı Banka Kartınız ile "
                        + LocalDate.now() + " Tarihinde " + yuklenecekMiktar + " Tutarında Bakiye Yükleme İşlemi Başarıyla Tamamlandı. \n" +
                        "Mevcut Bakiyeniz : " + mevcutMusteriHesabi.getSiteBakiyesi());

                Musteri yuklenenBakiye = new Musteri(LocalDate.now().toString(), islemOncesiSiteBakiyesi,
                        yuklenecekMiktar, mevcutMusteriHesabi.getSiteBakiyesi());
                mevcutMusteriHesabi.getBakiyeYuklemeGecmisi().add(yuklenenBakiye);

            } else if (secim == 2) {

                String bankaKartiUzerindekiISim = null;
                System.out.print("Lütfen Banka Kartı Üzerindeki İsmi Giriniz : ");
                bankKartIsimKontrolu(scan, mevcutMusteriHesabi, bankaKartiUzerindekiISim);

                String kartNumarasi = null;
                String sonKullanmaTarihi = null;
                String cvv = null;
                kartBilgileriniAl(scan, kartNumarasi, sonKullanmaTarihi, cvv);

                System.out.print("Lütfen Yüklemek İstediğiniz Miktari Giriniz : ");
                double miktar = doubleScanner(scan);
                double islemOncesiSiteBakiyesi = mevcutMusteriHesabi.getSiteBakiyesi();
                double yeniBakiye = mevcutMusteriHesabi.getSiteBakiyesi() + miktar;
                mevcutMusteriHesabi.setSiteBakiyesi(yeniBakiye);

                String islemTarihi = LocalDate.now().toString();

                Musteri islemGecmisi = new Musteri(islemTarihi, islemOncesiSiteBakiyesi, miktar, mevcutMusteriHesabi.getSiteBakiyesi());
                mevcutMusteriHesabi.getBakiyeYuklemeGecmisi().add(islemGecmisi);

                double bonus = mevcutMusteriHesabi.getMusteriBonus() + miktar / 10;
                mevcutMusteriHesabi.setMusteriBonus(bonus);
                double guncelBonus = mevcutMusteriHesabi.getMusteriBonus();

                Musteri bonusIslemi = new Musteri(bonus, islemTarihi, guncelBonus);
                mevcutMusteriHesabi.getBonusGecmisi().add(bonusIslemi);

                System.out.println("\nBakiye Yükleme İşlemi Başarıyla Tamamlandı.\n" +
                        "Güncel Bakiyeniz : " + mevcutMusteriHesabi.getSiteBakiyesi());
            }
        }
    }

    static void nakiteCevir(Scanner scan, Musteri mevcutMusteriHesabi) {
        scan.nextLine();
        String gonderilecekHesapAdi = null;
        System.out.print("Lütfen Para Göndereceğiniz Hesap Adını Giriniz : ");

        bankKartIsimKontrolu(scan, mevcutMusteriHesabi, gonderilecekHesapAdi);

        String girilenBankaKartiNumarasi;
        while (true) {
            System.out.print("Lütfen 16 Haneden Oluşan ****-****-****-**** Formatında Bank Kart Numaranızı girin : ");
            girilenBankaKartiNumarasi = scan.nextLine();
            if (validKartNo(girilenBankaKartiNumarasi)) {
                break;
            } else System.out.println("Kart Numarası 16 Haneden Oluşmalıdır.");
        }


        double islemOncesiSiteBakiyesi = mevcutMusteriHesabi.getSiteBakiyesi();
        double miktar;
        double yeniBakiye;
        do {
            System.out.print("Lütfen Nakite Çevirmek İstediğiniz Miktari Giriniz :");
            miktar = doubleScanner(scan);
            yeniBakiye = mevcutMusteriHesabi.getSiteBakiyesi() - miktar;
            if (miktar <= islemOncesiSiteBakiyesi) {

                mevcutMusteriHesabi.setSiteBakiyesi(yeniBakiye);
                break;
            } else {
                System.out.println("Site Bakiyenizden Fazla Para Gönderemezsiniz. Tekrar Deneyiniz : ");
            }
        } while (true);

        String islemTarihi = LocalDate.now().toString();
        Musteri islemGecmisi = new Musteri(islemTarihi, islemOncesiSiteBakiyesi, miktar, yeniBakiye);
        mevcutMusteriHesabi.getBakiyeCekmeGecmisi().add(islemGecmisi);

        System.out.println("\nNakite Çevirme İşlemi Basarıyla Tamamlandı\n" +
                "Mevcut Bakiyeniz : " + mevcutMusteriHesabi.getSiteBakiyesi());
    }

    static void urunKategorisiniPrintFYazdir(List<Urunler> kategori, Scanner scan, Musteri mevcutMusteriHesabi) {
        System.out.println();
        int urunKodu = 1;
        System.out.printf("\u001B[36m%-35s%-20s%-20s%-20s\u001B[0m%n", "    Ürün Adi    ", "İndirimsiz Fiyat", "İndirim Miktari", "İndirimli Fiyat");
        System.out.printf("\u001B[36m%-35s%-20s%-20s%-20s\u001B[0m%n", "----------------", "----------------", "---------------", "---------------");

        for (Urunler urun : kategori) {
            System.out.printf("\u001B[36m%-35s%-20.2f%-20.2f%-20.2f\u001B[0m%n",
                    (urunKodu + ") " + urun.getUrunAdi()), urun.getUrunFiyati() / 3 * 4, (urun.getUrunFiyati() / 3), urun.getUrunFiyati());
            urunKodu++;
        }


        System.out.print("Sepete Ürün Eklemek İsterseniz 1'e\n" +
                "Ana Menüye Gitmek İçin Herhangi Bir Tuşa Basabilirsiniz : ");
        int eklemeyeDevam = intScanner(scan);
        if (eklemeyeDevam == 1) {
            System.out.print("\nLütfen sepete eklemek istediğiniz ürünü seçiniz : ");
            int urunNo = intScanner(scan);
            sepeteEkle(mevcutMusteriHesabi, kategori, urunNo);

        }
    }

    static void indirimliUrunleriGoruntule(Scanner scan, Musteri mevcutMusteriHesabi) {

        LocalDate localDate = LocalDate.now();
        int ayinKacinciGunu = localDate.getDayOfMonth();

        switch (ayinKacinciGunu) {
            case 1:
            case 2:
            case 3:
                urunKategorisiniPrintFYazdir(UrunlerMethodlar.elektronik, scan, mevcutMusteriHesabi);
                break;
            case 4:
            case 5:
            case 6:
                urunKategorisiniPrintFYazdir(UrunlerMethodlar.kirtasiye, scan, mevcutMusteriHesabi);
                break;
            case 7:
            case 8:
            case 9:
                urunKategorisiniPrintFYazdir(UrunlerMethodlar.manav, scan, mevcutMusteriHesabi);
                break;
            case 10:
            case 11:
            case 12:
                urunKategorisiniPrintFYazdir(UrunlerMethodlar.tekstil, scan, mevcutMusteriHesabi);
                break;
            case 13:
            case 14:
            case 15:
                urunKategorisiniPrintFYazdir(UrunlerMethodlar.kisiselBakim, scan, mevcutMusteriHesabi);
                break;
            case 16:
            case 17:
            case 18:
                urunKategorisiniPrintFYazdir(UrunlerMethodlar.hirdavat, scan, mevcutMusteriHesabi);
                break;
            case 19:
            case 20:
            case 21:
                urunKategorisiniPrintFYazdir(UrunlerMethodlar.spor, scan, mevcutMusteriHesabi);
                break;
            case 22:
            case 23:
            case 24:
                urunKategorisiniPrintFYazdir(UrunlerMethodlar.otoAksesuar, scan, mevcutMusteriHesabi);
                break;
            case 25:
            case 26:
            case 27:
                urunKategorisiniPrintFYazdir(UrunlerMethodlar.hayvanUrunleri, scan, mevcutMusteriHesabi);
                break;
            case 28:
            case 29:
            case 30:
                urunKategorisiniPrintFYazdir(UrunlerMethodlar.kozmetik, scan, mevcutMusteriHesabi);
                break;
            case 31:
            default:
                System.out.println("Ne YazIk ki Geçici Olarak İndirimde Ürünümüz Bulunmamaktadır.");
                break;
        }
    }


    static void hesapGecmisiniGoruntule(Musteri mevcutMusteriHesabi, Scanner scan) {

        int secim;
        do {
            System.out.print("\nHangi İşlem Geçmişini Sorgulamak İstersiniz ?\n" +
                    "1 . Bakiye Yükleme Geçmişi\n" +
                    "2 . Bakiye Çekme Geçmişi\n" +
                    "3 . Bonus Geçmişi\n" +
                    "4 . Alınan Ürün Geçmişi\n" +
                    "5 . Yapılan Harcama Gecmişi\n" +
                    "6 . Çıkış Yap\n" +
                    "Seciminiz : ");
            secim = intScanner(scan);

            switch (secim) {

                case 1:
                    System.out.printf("\u001B[%sm%-20s%-20s%-20s%-20s\u001B[0m%n", "34", "İşlem Tarihi :", "Önceki Bakiye",
                            "Yüklenen Tutar", "Güncel Site Bakiyesi");

                    for (Musteri each : mevcutMusteriHesabi.getBakiyeYuklemeGecmisi()) {
                        System.out.printf("\u001B[%sm%-20s%-20.2f%-20.2f%-20.2f\u001B[0m%n",
                                "37", each.getIslemTarihi(), each.getIslemOncesiSiteBakiyesi(), each.getIslemTutari(), each.getSiteBakiyesi());

                    }
                    break;

                case 2:
                    System.out.printf("\u001B[%sm%-20s%-20s%-20s%-20s\u001B[0m%n", "34", "İşlem Tarihi :", "Önceki Bakiye",
                            "Çekilen Tutar", "Güncel Site Bakiyesi");

                    for (Musteri each : mevcutMusteriHesabi.getBakiyeCekmeGecmisi()) {
                        System.out.printf("\u001B[%sm%-20s%-20.2f%-20.2f%-20.2f\u001B[0m%n",
                                "37", each.getIslemTarihi(), each.getIslemOncesiSiteBakiyesi(), each.getIslemTutari(), each.getSiteBakiyesi());


                    }
                    break;

                case 3:
                    System.out.printf("\u001B[%sm%-20s%-20s%-20s\u001B[0m%n", "34", "İşlem Tarihi :",
                            "Kazanılan Bonus", "Toplam Bonus");

                    for (Musteri each : mevcutMusteriHesabi.getBonusGecmisi()) {
                        System.out.printf("\u001B[%sm%-20s%-20.2f%-20.2f\u001B[0m%n",
                                "37", each.getIslemTarihi(), each.getKazanilanBonus(), each.getMusteriBonus());


                    }
                    break;

                case 4:
                    System.out.printf("\u001B[%sm%-20s%-20s%-20s%-20s%-20s\u001B[0m%n", "34", "İşlem Tarihi",
                            "Ürün Adı", "Ürün Fiyati", "Alınan Ürün Adeti", "Toplam");

                    for (Urunler each : mevcutMusteriHesabi.getAlinanUrunGecmisi()) {
                        System.out.printf("\u001B[%sm%-20s%-20s%-20.2f%-20d%-20.2f\u001B[0m%n",
                                "37", each.getIslemTarihi(), each.getUrunAdi(), each.getUrunFiyati(), each.getAlinanUrunAdeti(), (each.getUrunFiyati() * each.getAlinanUrunAdeti()));

                    }
                    break;

                case 5:
                    System.out.printf("\u001B[%sm%-20s%-20s%-20s%-20s\u001B[0m%n", "34", "İşlem Tarihi :", "Önceki Bakiye",
                            "Harcanan Tutar", "Güncel Site Bakiyesi");

                    for (Musteri each : mevcutMusteriHesabi.getHarcamaGecmisi()) {
                        System.out.printf("\u001B[%sm%-20s%-20.2f%-20.2f%-20.2f\u001B[0m%n",
                                "37", each.getIslemTarihi(), each.getIslemOncesiSiteBakiyesi(), each.getIslemTutari(), each.getSiteBakiyesi());
                    }
                    break;

                case 6:
                    System.out.println("\u001B[31mMüşteri Menüye Dönülüyor.\u001B[0m");

                    break;
                default:
                    System.out.println("Lütfen Geçerli Bir Tuşlama Yapınız !");
                    break;
            }
        } while (secim != 6);
    }


    static void hesapAyarlari(Scanner scan, Musteri mevcutMusteriHesabi) {
        scan.nextLine();
        int secim;
        do {

            System.out.print("\nHesap Başkasına Devredilemez. Bu Sebeple Kullanıcı Adınızı Değiştiremezsiniz !\n" +
                    "\n1. Şifreyi Değiştir\n" +
                    "2. Telefon Numarasını Değiştir\n" +
                    "3. Kargo Adresini Değiştir\n" +
                    "4. Mail Adresini Değiştir\n" +
                    "5. Hesap Sil\n" +
                    "6. Kullanıcı Menüsüne Dön\n" +
                    "Lütfen Hangi İşlemi Yapmak İstediğinizi Seçiniz : ");
            secim = intScanner(scan);
            switch (secim) {
                case 1:

                    if (sifreKontrolu(scan, mevcutMusteriHesabi, 5)) {
                        String yeniSifre = sifreBelirle(scan);

                        mevcutMusteriHesabi.setKullanıcıSifre(yeniSifre);

                        System.out.println("\nŞifreniz Başarıyla Değiştirilmiştir. Lütfen Şifrenizi Kimse ile Paylaşmayın.");
                    }
                    break;
                case 2:

                    if (sifreKontrolu(scan, mevcutMusteriHesabi, 5)) {
                        String yeniTel = telefonBelirle(scan);

                        mevcutMusteriHesabi.setTel(yeniTel);

                        System.out.println("\nTelefon Numaranız Başarıyla Değiştirilmiştir.");
                    }


                    break;
                case 3:

                    if (sifreKontrolu(scan, mevcutMusteriHesabi, 5)) {
                        System.out.print("Lütfen Yeni Kargo Adresinizi Giriniz :");
                        String yeniKargoAdresi = scan.nextLine();
                        mevcutMusteriHesabi.setKargoAdresi(yeniKargoAdresi);

                        System.out.println("\nKargo Adresiniz Başarıyla Değiştirilmiştir.");
                    }

                    break;
                case 4:

                    if (sifreKontrolu(scan, mevcutMusteriHesabi, 5)) {
                        String yeniMailAdresi = mailBelirle(scan);

                        mevcutMusteriHesabi.setMailAdresi(yeniMailAdresi);

                        System.out.println("\nMail Adresiniz Başarıyla Değiştirilmiştir.");
                    }

                    break;
                case 5:
                    do {
                        scan.nextLine();
                        System.out.print("\nDikkat Hesabınız Silinmek Üzere. Bu İşlemi Yapmak İstediğinizden Emin Misiniz?\n" +
                                "Evet ise 1'e\n" +
                                "Hayır ise 2'ye\n" +
                                "Basınız :");
                        int devamSecimi = intScanner(scan);
                        if (devamSecimi == 1) {

                            if (sifreKontrolu(scan, mevcutMusteriHesabi, 5)) {
                                System.out.print("Lütfen Hesabınızı Neden Silmek istediğinizi Bizimle Paylaşın :");
                                String silmeSebebi = scan.nextLine();
                                System.out.println("Hesabınızı Silmek İstediğinizden Emin Misiniz?\n" +
                                        "Lütfen Ekranda Gördüğünüz Yazıyı Büyük Küçük Harfe Dikkat Ederek Yazınız. !eMiNiM!");
                                String dogrulama = scan.next();
                                if (dogrulama.equals("!eMiNiM!")) {
                                    System.out.println("Hesabınız \n" +
                                            silmeSebebi + "\n" +
                                            "Gerekçesi ile Başarıyla Silinmiştir. Tekrar bekleriz :D" +
                                            "\n Uygulamadan Çıkış Yapıldı !");
                                    Musteri.getTumKullanicilar().remove(mevcutMusteriHesabi);
                                    System.exit(0);
                                } else {
                                    System.out.println("Doğrulama Kodunu Yanlış Girdiniz !\n" +
                                            "Doğrulama Kodunu Yanlış Girdiğiniz İçin Hesap Silme Gercekleştirilemedi.");
                                    break;
                                }
                            }
                            break;
                        }
                    } while (true);
                    break;
                case 6:
                    System.out.println("\u001B[31mKullanıcı Menüye Dönülüyor !\u001B[0m");
                    break;
            }
        } while (secim != 6);
    }

    static Musteri musteriHesapBul(String kullaniciNumarasi) {

        for (Musteri hesap : Musteri.getTumKullanicilar()) {
            if (hesap.getKullaniciNumarasi().equals(kullaniciNumarasi) ||
                    hesap.getKullaniciAdi().equals(kullaniciNumarasi)) {
                return hesap;

            }
        }
        return null;
    }

    static Musteri engellenenMusteriHesapBul(String kullaniciNumarasi) {

        for (Musteri hesap : Musteri.getEngellenenKullanicilar()) {
            if (hesap.getKullaniciNumarasi().equals(kullaniciNumarasi) || hesap.getKullaniciAdi().equals(kullaniciNumarasi)) {
                return hesap;
            }
        }
        return null;
    }

    static void musteriGirisi(Scanner scan) {

        scan.nextLine();
        System.out.print("Lütfen Kullanıcı Numaranızı veya Kullanıcı Adınızı Giriniz : ");

        String girilenMusteriHesabi = scan.nextLine();
        Musteri engellenenKullanici = engellenenMusteriHesapBul(girilenMusteriHesabi);
        if (engellenenKullanici == null) {

            Musteri mevcutMusteriHesabi = musteriHesapBul(girilenMusteriHesabi);
            int counter = 5;
            if (mevcutMusteriHesabi != null) {

                if (sifreKontrolu(scan, mevcutMusteriHesabi, counter)) {

                    MusteriMenusu.musteriMenu(scan, mevcutMusteriHesabi);
                }

            } else {
                System.out.print("Girdiğiniz Kullanıcı Hesabı Bulunamadı !\n" +
                        "1 : Farklı Bir Hesap ile Deneyiniz\n" +
                        "2 : Yeni Hesap Aç\n" +
                        "Ana menüye Dönmek İçin Herhangi Bir Sayıya Basabilirsiniz.\n" +
                        "Lütfen Hangi İşlemi Yapmak İstediğinizi Belirtiniz :");

                int secim = intScanner(scan);
                if (secim == 1) {
                    musteriGirisi(scan);
                } else if (secim == 2) {
                    yeniHesapAc(scan);
                }
            }

        } else {
            System.out.println("\nBu hesap Bloke Olmuştur. Lütfen Müşteri Hizmetlerine Ulaşınız.\n" +
                    "Veya Yeni Bir Hesap Oluşturunuz.\n");

        }
    }

    static void makbuz(Musteri mevcutMusteriHesabi) {

        double toplam = 0;
        System.out.println("\nÖdemeniz Başarıyla Gerçekleşmiştir. Makbuzunuz Aşağıdaki Gibidir.\n");

        System.out.printf("\u001B[36m%-15s%-35s%-20s%-20s%-20s\u001B[0m%n", "İşlem Tarihi", "Ürün Adı", "Alınan Ürün Adeti",
                "Ürün Fiyatı", "Toplam Fiyat");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (Urunler alinanUrun : mevcutMusteriHesabi.getAlisverisSepeti()) {

            System.out.printf("\u001B[36m%-15s%-35s%-20d%-20.2f%-20.2f\u001B[0m%n",
                    LocalDate.now().toString(), alinanUrun.getUrunAdi(), alinanUrun.getStokAdeti(),
                    alinanUrun.getUrunFiyati(), (alinanUrun.getStokAdeti() * alinanUrun.getUrunFiyati()));
            toplam += (alinanUrun.getStokAdeti() * alinanUrun.getUrunFiyati());
        }

        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("\u001B[33m%-89s %-20.2f%n\u001B[0m",
                "Toplam Fiyat", toplam);
        System.out.println();

    }

    static void siteBakiyesiIleOde(Scanner scan, double tutar, Musteri mevcutMusteriHesabi) {
        if (mevcutMusteriHesabi.getSiteBakiyesi() >= tutar) {
            double islemOncesiBakiye = mevcutMusteriHesabi.getSiteBakiyesi();
            mevcutMusteriHesabi.setSiteBakiyesi(mevcutMusteriHesabi.getSiteBakiyesi() - tutar);
            double islemSonrasiBakiye = mevcutMusteriHesabi.getSiteBakiyesi();
            String islemTarihi = LocalDate.now().toString();

            for (Urunler sepettekiUrun : mevcutMusteriHesabi.getAlisverisSepeti()) {
                Urunler alinanUrun = new Urunler(islemTarihi, sepettekiUrun.getUrunAdi(),
                        sepettekiUrun.getUrunFiyati(), sepettekiUrun.getStokAdeti());
                mevcutMusteriHesabi.getAlinanUrunGecmisi().add(alinanUrun);

            }

            Musteri harcamaGecmisi = new Musteri(islemTarihi, islemOncesiBakiye, tutar, islemSonrasiBakiye);
            mevcutMusteriHesabi.getHarcamaGecmisi().add(harcamaGecmisi);
            makbuz(mevcutMusteriHesabi);
            System.out.println("\nKalan Bakiye: " + mevcutMusteriHesabi.getSiteBakiyesi());
            mevcutMusteriHesabi.getAlisverisSepeti().clear();
        } else {
            System.out.print("Yetersiz Bakiye. Ödeme Yapılamadı.\n" +
                    "Hesabınıza Bakiye Yüklemek İsterseniz 1'e,\n" +
                    "Ana Menüye Dönmek İsterseniz 2'ye\n" +
                    "Çıkış Yapmak İsterseniz Herhangi Bir Tuşa Basınız : ");
            int secim = intScanner(scan);
            if (secim == 1) {
                bakiyeYukle(scan, mevcutMusteriHesabi);
            } else if (secim == 2) {
                AnaSayfa.Application();
            } else {
                System.exit(0);
            }
        }
    }

    static void bankaKartiIleOde(Musteri mevcutMusteriHesabi, Scanner scan, double tutar) {


        if (musteriHesapBul(mevcutMusteriHesabi.getKullaniciAdi()) != null) {


            System.out.print("\nMevcut Banka Kartınızı Kullanarak Ödeme Yapmak İçin 1'e\n" +
                    "Yeni Bir Banka Kartı Kullanmak İçin 2'ye Basınız : ");
            int secim = intScanner(scan);
            if (secim == 1) {



            } else if (secim == 2) {

                System.out.print("Lütfen Banka Kartınızın Üzerinde Yazan İsmi Giriniz : ");
                String bankaKartiUzerindekiISim = null;

                bankKartIsimKontrolu(scan, mevcutMusteriHesabi, bankaKartiUzerindekiISim);

                String kartNo = null;
                String sonKullanmaTarihi = null;
                String cvv = null;
                kartBilgileriniAl(scan, kartNo, sonKullanmaTarihi, cvv);

            }

            for (Urunler sepettekiUrun : mevcutMusteriHesabi.getAlisverisSepeti()) {
                Urunler alinanUrun = new Urunler(LocalDate.now().toString(), sepettekiUrun.getUrunAdi(),
                        sepettekiUrun.getUrunFiyati(), sepettekiUrun.getStokAdeti());
                mevcutMusteriHesabi.getAlinanUrunGecmisi().add(alinanUrun);

            }

            Musteri harcamaGecmisi = new Musteri(LocalDate.now().toString(),
                    mevcutMusteriHesabi.getSiteBakiyesi(), tutar, mevcutMusteriHesabi.getSiteBakiyesi());

            mevcutMusteriHesabi.getHarcamaGecmisi().add(harcamaGecmisi);

            makbuz(mevcutMusteriHesabi);

            mevcutMusteriHesabi.getAlisverisSepeti().clear();



        } else {
            System.out.print("Lütfen Banka Kartınızın Üzerinde Yazan İsmi Giriniz : ");
            String bankaKartiUzerindekiISim = scan.nextLine();

            String kartNo = null;
            String sonKullanmaTarihi = null;
            String cvv = null;
            kartBilgileriniAl(scan, kartNo, sonKullanmaTarihi, cvv);

            System.out.print("Ürünlerin Teslimi İçin Kargo Adresinizi Giriniz : ");
            String kargoAdresi = scan.nextLine();
            System.out.println();
            System.out.println("Banka Kartı ile: " + tutar + " TL. Tutarında Ödeme Yapılmıştır.");
            makbuz(mevcutMusteriHesabi);
            mevcutMusteriHesabi.getAlisverisSepeti().clear();

        }
    }


    static boolean validKartNo(String kartNo) {
        return kartNo.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}");
    }

    static boolean validSonKullanmaTarihi(String sonKullanmaTarihi) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(sonKullanmaTarihi);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    static boolean validCVV(String cvv) {
        return cvv.matches("\\d{3}");
    }
}