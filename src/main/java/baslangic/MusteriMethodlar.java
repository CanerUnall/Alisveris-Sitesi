package baslangic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

//import static baslangic.UrunlerMethodlar.*;

public class MusteriMethodlar {
    /*private static List<Urunler> alisverisSepeti = new ArrayList<>();
    private static List<Musteri> bakiyeYuklemeGecmisi = new ArrayList<>();
    private static List<Musteri> bakiyeCekmeGecmisi = new ArrayList<>();
    private static List<Urunler> alinanUrunGecmisi = new ArrayList<>();
    private static List<Musteri> bonusGecmisi = new ArrayList<>();

    public static List<Urunler> getAlisverisSepeti() {
        return alisverisSepeti;
    }

    public static List<Musteri> getBakiyeYuklemeGecmisi() {
        return bakiyeYuklemeGecmisi;
    }

    public static List<Musteri> getBakiyeCekmeGecmisi() {
        return bakiyeCekmeGecmisi;
    }

    public static List<Urunler> getAlinanUrunGecmisi() {
        return alinanUrunGecmisi;
    }

    public static List<Musteri> getBonusGecmisi() {
        return bonusGecmisi;
    }
*/
    public static int intScanner(Scanner scan) {
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Hata: Lütfen geçerli bir tamsayı girin.");
                scan.nextLine(); // Hatalı girişi temizliyorum.
            }
        }
    }

    public static double doubleScanner(Scanner scan) {
        while (true) {
            try {
                return scan.nextDouble();
            } catch (InputMismatchException e) {
                System.err.println("Hata: Lütfen geçerli bir sayı girin.");
                scan.nextLine(); // Hatalı girişi temizliyorum.
            }
        }
    }

    public static String stringScanner(Scanner scan) {
        scan.nextLine();
        String degiskenIsmi;
        while (true) {

            degiskenIsmi = scan.nextLine();
            if (degiskenIsmi.matches("[a-zA-Z\\u0061-\\u007A\\u0041-\\u005A\\u00C0-\\u021E]+")) {
                return degiskenIsmi.trim();
            } else System.out.println("Lütfen geçerli bir ifade giriniz !\n");
        }
    }

    public static void yeniHesapAc(Scanner scan) {

        System.out.println("Lutfen adinizi giriniz");
        //scan.nextLine();
        String kullaniciAdi = scan.nextLine();
        boolean flag = true;
        String kullaniciSifre;
        do {
            scan.nextLine();
            System.out.println("lutfen en az sekiz karakterden olusan bir buyuk bir kucuk ve " +
                    "bir de buyuk harf olsuturan bir kullaniciSifre belirleyiniz");
            kullaniciSifre = scan.nextLine();
            if (kullaniciSifre.length() > 7) {
                for (int i = 0; i < kullaniciSifre.length(); i++) {
                    if (kullaniciSifre.matches(".*[0-9].*") && kullaniciSifre.matches(".*[A-Z].*") && kullaniciSifre.matches(".*[a-z].*")) {
                        System.out.println("\u001B[32mStrong Password\u001B[0m");
                        flag = false;
                        break;
                    }
                }
            } else {
                System.out.println("\u001B[34m Parola  en az sekiz karakter olmali \u001B[0m ");
            }
        } while (flag);

        System.out.println("Lutfen yasinizi giriniz");
        int kullaniciYasi = intScanner(scan);
        scan.nextLine();
        String kullaniciCinsiyeti;

        while (true) {
            System.out.println("Lütfen cinsiyetinizi giriniz (erkek/kadin): ");
            kullaniciCinsiyeti = scan.nextLine();
            if ((kullaniciCinsiyeti.equalsIgnoreCase("erkek")) || (kullaniciCinsiyeti.equalsIgnoreCase("kadin"))) {
                break;
            } else {
                System.out.println("Lütfen cinsiyetinizi 'erkek' ya da 'kadin' olarak giriniz.");
            }
        }

        String bankaKartiNumarasi;
        while (true) {
            System.out.println("Lutfen 16 haneden olusan ****-****-****-**** formatinda bank kart numaranizi giriniz ");
            bankaKartiNumarasi = scan.nextLine();
            if (validKartNo(bankaKartiNumarasi)) {
                break;
            } else System.out.println("kart numaraniz 16 haneden olusmalidir.");
        }
        String bankaKartiGuvenlikKodu;
        do {
            System.out.println("Lutfen kartin arkasinda bulunan 3 haneli guvenlik kodunu giriniz");
            bankaKartiGuvenlikKodu = scan.nextLine();
            if (validCVV(bankaKartiGuvenlikKodu)) {
                break;
            } else {
                System.out.println("lutfen 3 haneden olusan bank kart numarasi giriniz");
            }
        } while (true);

        String sonKullanmaTarihi;
        do {
            System.out.print("lutfen kartinizin son kullanma tarihini(MM/YYYY) formatında girin: ");
            sonKullanmaTarihi = scan.nextLine();
            if (validSonKullanmaTarihi(sonKullanmaTarihi)) {
                break;
            } else System.out.println("lutfen belirtilen formatta giriniz");

        } while (true);

        System.out.println("Lutfen urunleri ulastirabilecegimiz kargo adresiniz giriniz");
        String kargoAdresi = scan.nextLine();
        String tel;
        do {
            System.out.println("Lutfen 10 haneden olusan telefon numaranizi basinda sifir olmadan giriniz");
            tel = scan.nextLine();
            if (tel.matches("\\d{10}")) {
                break;
            } else System.out.println("lutfen en az 10 haneden olusan bir telefon numarasi giriniz");
        } while (true);

        String mailAdresi;

        do {
            System.out.println("Lutfen mail adresinizi giriniz");
            mailAdresi = scan.nextLine();
            if (mailAdresi.endsWith("@gmail.com") || (mailAdresi.endsWith("@outlook.com") || (mailAdresi.endsWith("@hotmail.com")))) {
                break;
            } else System.out.println("lutfen mail adresi formatinda giriniz");
        } while (true);

        System.out.println("Lutfen yuklemek istediginiz bakiyenizi giriniz");
        double yuklenenBakiye = doubleScanner(scan);
        double siteBakiyesi = yuklenenBakiye;
        double musteriBonus = siteBakiyesi / 20;
        System.out.println("Guncel bonusunuz : " + musteriBonus);

        String kullaniciNumarasi = Musteri.getKullaniciKayitNumarasi() + "";
        Musteri.setKullaniciKayitNumarasi(Musteri.getKullaniciKayitNumarasi() + 1);

        System.out.println("Benzersiz Kullanıcı Numarası: " + kullaniciNumarasi);

        List<Urunler> alisverisSepetiAcilisi = new ArrayList<>();
        List<Musteri> bakiyeYuklemeGecmisiAcilisi = new ArrayList<>();
        List<Musteri> bakiyeCekmeGecmisiAcilisi = new ArrayList<>();
        List<Urunler> alinanUrunGecmisiAcilisi = new ArrayList<>();
        List<Musteri> bonusGecmisiAcilisi = new ArrayList<>();
        List<Musteri> harcamaGecmisi = new ArrayList<>();

        Musteri musTeri = new Musteri(kullaniciAdi, kullaniciSifre, kullaniciYasi,
                kullaniciCinsiyeti, bankaKartiNumarasi, sonKullanmaTarihi, bankaKartiGuvenlikKodu,
                kargoAdresi, tel, mailAdresi, siteBakiyesi, musteriBonus, kullaniciNumarasi,
                alisverisSepetiAcilisi, alinanUrunGecmisiAcilisi, bakiyeCekmeGecmisiAcilisi,
                bakiyeYuklemeGecmisiAcilisi, bonusGecmisiAcilisi, harcamaGecmisi);

        Musteri.getTumKullanicilar().add(musTeri);

        Musteri bakiyeYuklemeIslemi = new Musteri(LocalDate.now().toString(), 0, yuklenenBakiye, siteBakiyesi);
        musTeri.getBakiyeYuklemeGecmisi().add(bakiyeYuklemeIslemi);

        Musteri bonusGecmisi = new Musteri(musteriBonus, LocalDate.now().toString(), musTeri.getMusteriBonus());
        musTeri.getBonusGecmisi().add(bonusGecmisi);

        MusteriMenusu.musteriMenu(scan, musTeri);

    }

    /* public Musteri musteriHesabinaGiris(LinkedList<Musteri> musteriList) {
         System.out.println("musteri Hesabina giris yapmak icin Kullanici adinizi ve sekiz haneden olusan sifrenizi giriniz");
         String musteriHesabi = stringScanner(scan);
         for (Musteri mus : musteriList) {
             if (mus.getKullaniciAdi().equals(getKullaniciAdi()) && mus.getKullanıcıSifre().equals(getKullanıcıSifre())) {
                 if (mus.getKullaniciCinsiyeti().equals("Kadin")) {
                     System.out.println(getKullaniciAdi() + " Hanim Hesabiniza hosgeldiniz keyifli alisveriler");
                 } else System.out.println(getKullaniciAdi() + " Bey Hesabiniza hosgeldiniz keyifli alisveriler ");

                 return mus;
             } else {
                 System.out.println("lutfen kullanici adinizi ve sifrenizi kontrol edip tekrar deneyiniz");
             }
         }
         return null;
     }

 }*/
    public static void urunleriListele(List<Urunler> urunListesi, Musteri mevcutMusteriHesabi) {
        Scanner scan = new Scanner(System.in);
        int urunNo = 0;
        int ürünKodu = 1;
        System.out.printf("%-20s   %-20s   %-20s  \n", "Urun Adi", "Fiyati", "Stokta Kalan");
        System.out.printf("%-20s   %-20s   %-20s  \n", "--------", "------", "------------");
        for (Urunler w : urunListesi) {
            System.out.printf("%-20s   %-20s   %-20s  \n", ürünKodu + ") " + w.getUrunAdi(), w.getUrunFiyati(), w.getStokAdeti());
            ürünKodu++;
        }

        System.out.println("Sepete urun eklemek isterseniz 1'e\n" +
                "Ana menuye gitmek icin herhangi bir tusa basabilirsiniz");
        int eklemeyeDevam = intScanner(scan);
        if (eklemeyeDevam == 1) {
            System.out.println("\nLütfen sepete eklemek istediğiniz ürünü seçiniz");
            urunNo = scan.nextInt();
            sepeteEkle(mevcutMusteriHesabi, urunListesi, urunNo);

        } else {

        }
    }

    static void urunleriGoruntule(Scanner scan, Musteri mevcutMusteriHesabi) {
        /*1- Burada 10 farklı kategori olacak
        Kullanıcı katogorılerden birini secince 10 farklı ürün ve fiyatını görecek.
        2- Ürünleri sepete ekleyebilecek.
        3- Ödeme en sonda sepetten devam edilerek yapılacak.*/
        //urunleri UrunMethodlar classindan cagirmalisin.
        System.out.println("Lutfen kategori seciniz.\n" +
                "1. Kırtasiye\n" +
                "2. Manav\n" +
                "3. Tekstil\n" +
                "4. Kişisel Bakım\n" +
                "5. Hırdavat\n" +
                "6. Spor\n" +
                "7. Oto Eksesuar\n" +
                "8. Elektronik\n" +
                "9. Hayvan Ürünleri\n" +
                "10. Kozmetik");
        int secim = 0;

        while (true) {
            try {
                System.out.println("Lütfen 1 ile 10 arasında bir sayı giriniz:");
                secim = scan.nextInt();

                if (secim > 0 && secim < 11) {
                    break;
                } else {
                    System.out.println("Hatalı seçim, lütfen tekrar deneyiniz.");
                }
            } catch (InputMismatchException e) {
                // Kullanıcı string ifade girdiğinde bu hatayı yakala
                System.out.println("Hatalı giriş. Lütfen bir sayı giriniz.\n");
                scan.next(); // Hatalı girişi temizle
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


    }

    static void sepeteEkle(Musteri mevcutMusteriHesabi, List<Urunler> urunListesi, int urunNo) {
        //alisveris tamamlandiktan sonra sepet sifirlanacak

        //Ubeyde bey
        Scanner scan = new Scanner(System.in);

        if (urunNo > 0 && urunNo <= urunListesi.size()) {
            Urunler secilenUrun = urunListesi.get(urunNo - 1);

            System.out.println("Kaç adet eklemek istiyorsunuz?");
            int adet = scan.nextInt();

            if (adet > 0 && adet <= secilenUrun.getStokAdeti()) {
                // Sepete ekleme işlemleri

                mevcutMusteriHesabi.getAlisverisSepeti().add(new Urunler(secilenUrun.getUrunAdi(), secilenUrun.getUrunFiyati(), adet));
                System.out.println(adet + " adet " + secilenUrun.getUrunAdi() + " sepete eklendi.\n\nSepetiniz:\n\n");

                System.out.printf("%-20s   %-20s   %-20s  \n", "Urun Adi", "Fiyati", "Sepetteki Miktar");
                System.out.printf("%-20s   %-20s   %-20s  \n", "--------", "------", "----------------");
                for (Urunler w : mevcutMusteriHesabi.getAlisverisSepeti()) {
                    System.out.printf("%-20s   %-20s   %-20s  \n", w.getUrunAdi(), w.getUrunFiyati(), w.getStokAdeti());
                }
                // Stok adetini güncelleme.secilenUrun.setStokAdeti(secilenUrun.getStokAdeti() - adet);
                urunListesi.get(urunNo - 1).setStokAdeti(secilenUrun.getStokAdeti() - adet);
            } else {
                System.out.println("Geçersiz adet. Lütfen stok durumunu kontrol edip tekrar deneyiniz.");
            }
        } else {
            System.out.println("Geçersiz ürün numarası.");
        }
    }

    static void sepetiGoruntule(Scanner scan, Musteri mevcutMusteriHesabi) {

        double toplam = 0;

        System.out.printf("\u001B[33m%-35s %-15s %-15s %-15s%n\u001B[0m",
                "Urun Adi", "Adet", "Fiyat", "Toplam Fiyat");
        System.out.println("---------------------------------------------------------------------------");
        for (Urunler sepet : mevcutMusteriHesabi.getAlisverisSepeti()) {

            System.out.printf("%-35s %-15d %-15.2f %-15.2f%n",
                    sepet.getUrunAdi(), sepet.getStokAdeti(), sepet.getUrunFiyati(),
                    sepet.getStokAdeti() * sepet.getUrunFiyati());

            toplam += (sepet.getStokAdeti() * sepet.getUrunFiyati());

        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("\u001B[33m%-67s %-20s%n\u001B[0m",
                "Toplam Fiyat", toplam);

        if (musteriHesapBul(mevcutMusteriHesabi.getKullaniciNumarasi()) != null) {
            System.out.print("Hesap bakiyesi ile odeme yapmak icin 1'e\n" +
                    "Banka karti ile odeme yapmak icin 2'e\n" +
                    "Ana menuye donmek icin istediginiz herhangi bir tusa\n" +
                    "Basiniz : ");

            int secim = intScanner(scan);

            if (secim == 1) {
                siteBakiyesiIleOde(scan, toplam, mevcutMusteriHesabi);
            } else if (secim == 2) {
                bankaKartiIleOde(mevcutMusteriHesabi, scan, toplam);

            } else {
                // Diğer durumlar için bir şey yapılabiliriz
            }
        } else {
            System.out.print(
                    "Banka karti ile odeme yapmak icin 1'e\n" +
                            "Ana menuye donmek icin istediginiz herhangi bir tusa\n" +
                            "Basiniz : ");

            int secim = intScanner(scan);

            if (secim == 1) {
                bankaKartiIleOde(mevcutMusteriHesabi, scan, toplam);
            } else {


            }
            // Diğer durumlar için bir şey yapılabiliriz

        }
    }


    static public void bakiyeYukle(Scanner scan, Musteri mevcutMusteriHesabi) {
        //bonusu hesaba TL olarak yukle
        //mevcut karttan mi yukleme olacak yoksa yeni karttan mi?
        System.out.print("Bonuslari Site Bakiyesine Donusturerek bakiye yuklemek isterseniz 1'e\n" +
                "Banka karti araciligiyla bakiye yuklemek isterseniz 2'e basiniz : ");
        int ilkSecim = intScanner(scan);
        if (ilkSecim == 1) {
            double islemOncesiSiteBakiyesi = mevcutMusteriHesabi.getSiteBakiyesi();
            double donusturulenPara = mevcutMusteriHesabi.getMusteriBonus() * 0.10;
            mevcutMusteriHesabi.setSiteBakiyesi(mevcutMusteriHesabi.getSiteBakiyesi() + donusturulenPara);
            mevcutMusteriHesabi.setMusteriBonus(0);

            System.out.println("Hesabinizdaki bonuslardan kazanciniz " + donusturulenPara + "\nMevcut bakiyeniz : " +
                    mevcutMusteriHesabi.getSiteBakiyesi() + "\nGuncel bonusunuz : 0");
            Musteri yuklenenBakiye = new Musteri(LocalDate.now().toString(), islemOncesiSiteBakiyesi, donusturulenPara, mevcutMusteriHesabi.getSiteBakiyesi());
            mevcutMusteriHesabi.getBakiyeYuklemeGecmisi().add(yuklenenBakiye);
        } else if (ilkSecim == 2) {


            System.out.print("Mevcut banka kartinizi kullanarak yukleme yapmak icin 1'e\n" +
                    "Yeni bir banka karti kullanmak icin 2'ye basiniz : ");
            int secim = intScanner(scan);
            if (secim == 1) {

                System.out.println("Ne kadar bakiye yuklemek istersiniz ? : ");
                double yuklenecekMiktar = doubleScanner(scan);
                double islemOncesiSiteBakiyesi = mevcutMusteriHesabi.getSiteBakiyesi();
                mevcutMusteriHesabi.setSiteBakiyesi(mevcutMusteriHesabi.getSiteBakiyesi() + yuklenecekMiktar);
                System.out.println(mevcutMusteriHesabi.getBankaKartiNumarasi() + " numarali banka kartiniz ile "
                        + LocalDate.now() + " tarihinde " + yuklenecekMiktar + " tutarinda bakiye yukleme islemi basariyla tamamlandi. \n" +
                        "Yeni bakiyeniz : " + mevcutMusteriHesabi.getSiteBakiyesi());

                Musteri yuklenenBakiye = new Musteri(LocalDate.now().toString(), islemOncesiSiteBakiyesi,
                        yuklenecekMiktar, mevcutMusteriHesabi.getSiteBakiyesi());
                mevcutMusteriHesabi.getBakiyeYuklemeGecmisi().add(yuklenenBakiye);
            } else if (secim == 2) {

                do {
                    scan.nextLine();
                    System.out.print("Lutfen Banka Karti Numaranizi giriniz : ");
                    String girilenBankaKartiNumarasi = scan.nextLine();
                    if (mevcutMusteriHesabi.getBankaKartiNumarasi().equals(girilenBankaKartiNumarasi)) {
                        break;
                    } else {
                        System.out.println("Yalnizca kendinize ait bir banka karti kullanabilirsiniz.\n" +
                                "Lutfen tekrar deneyiniz.");
                    }
                } while (true);

                System.out.println("Lutfen banka karti guvenlik kodunuzu giriniz.");
                String girilenBankaKartiGuvenlikKodu = scan.nextLine();

                System.out.println("Lutfen yuklemek istediginiz miktari giriniz.");
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


                System.out.println("Bakiye Yukleme islemi basariyla tamamlandi.\n" +
                        "Guncel bakiyeniz : " + mevcutMusteriHesabi.getSiteBakiyesi());
            }
        }
        //yukledıkce bonus kazansın
    }

    static void nakiteCevir(Scanner scan, Musteri mevcutMusteriHesabi) {
        scan.nextLine();
        do {
            System.out.print("Lutfen Para Aktaracaginiz Banka Karti Numaranizi giriniz :");
            String girilenBankaKartiNumarasi = scan.nextLine();
            if (mevcutMusteriHesabi.getBankaKartiNumarasi().equals(girilenBankaKartiNumarasi)) {
                break;
            }
            System.out.println("Yalnizca kendinize ait bir banka kartina para aktarabilirsiniz.\n" +
                    "Lutfen tekrar deneyiniz.");
        } while (true);

        System.out.print("Lutfen nakite cevirmek istediginiz miktari giriniz :");
        double miktar = doubleScanner(scan);
        double islemOncesiSiteBakiyesi = mevcutMusteriHesabi.getSiteBakiyesi();
        double yeniBakiye = mevcutMusteriHesabi.getSiteBakiyesi() - miktar;

        mevcutMusteriHesabi.setSiteBakiyesi(yeniBakiye);

        String islemTarihi = LocalDate.now().toString();
        Musteri islemGecmisi = new Musteri(islemTarihi, islemOncesiSiteBakiyesi, miktar, yeniBakiye);
        mevcutMusteriHesabi.getBakiyeCekmeGecmisi().add(islemGecmisi);

        System.out.println("Nakite cevirme islemi basariyla tamamlandi\n" +
                "Guncel bakiyeniz : " + mevcutMusteriHesabi.getSiteBakiyesi());
    }

    static void urunKategorisiniPrintFYazdir(List<Urunler> kategori, Scanner scan, Musteri mevcutMusteriHesabi) {

        int urunKodu = 1;
        System.out.printf("\u001B[%sm%-35s%-20s%-20s%-20s\u001B[0m%n", "34", "    Urun Adi    ", "Indirimsiz Fiyat", "Indirim Miktari", "Indirimli Fiyat");
        System.out.printf("%-35s%-20s%-20s%-20s\n", "----------------", "----------------", "---------------", "---------------");
        for (Urunler urun : kategori) {

            System.out.printf("\u001B[%sm%-45s%-20.2f%-20.2f%-10.2f\u001B[0m%n",
                    "36", urunKodu + ") " + urun.getUrunAdi(), urun.getUrunFiyati() / 3 * 4, (urun.getUrunFiyati() / 3), urun.getUrunFiyati());
            urunKodu++;
        }

        System.out.println("Sepete urun eklemek isterseniz 1'e\n" +
                "Ana menuye gitmek icin herhangi bir tusa basabilirsiniz");
        int eklemeyeDevam = intScanner(scan);
        if (eklemeyeDevam == 1) {
            System.out.println("\nLütfen sepete eklemek istediğiniz ürünü seçiniz");
            int urunNo = scan.nextInt();
            sepeteEkle(mevcutMusteriHesabi, kategori, urunNo);

        } else {

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
                System.out.println("Ne yazik ki gecici olarak indirimde urunumuz bulunmamaktadir.");
                break;
        }
        //Caner
    }


    static void hesapGecmisiniGoruntule(Musteri mevcutMusteriHesabi, Scanner scan) {

        /*Bakiye yükleme geçmişi
        Bakiye çekme geçmişi
        Biriken bonuslar/Müsteri alışveriş yaptıkca bonus kazansın
        Alınan ürünler geçmişi*/

        do {
            System.out.print("Hangi Islem Gecmisini sorgulamak istersiniz_\n" +
                    "1 . Bakiye yükleme geçmişi\n" +
                    "2 . Bakiye çekme geçmişi\n" +
                    "3 . Biriken bonuslar\n" +
                    "4 . Alınan ürünler geçmişi\n" +
                    "5 . Yapilan harcama gecmisi" +
                    "Seciminiz : ");
            int secim = intScanner(scan);

            switch (secim) {


                case 1:
                    System.out.printf("\u001B[%sm%-20s%-20s%-20s%-20s\u001B[0m%n", "34", "Islem Tarihi :", "Onceki Bakiye",
                            "Yuklenen Tutar", "Guncel Site Bakiyesi");

                    for (Musteri each : mevcutMusteriHesabi.getBakiyeYuklemeGecmisi()) {
                        System.out.printf("\u001B[%sm%-20s%-20.2f%-20.2f%-20.2f\u001B[0m%n",
                                "37", each.getIslemTarihi(), each.getIslemOncesiSiteBakiyesi(), each.getIslemTutari(), each.getSiteBakiyesi());

                    }
                    break;
                case 2:
                    System.out.printf("\u001B[%sm%-20s%-20s%-20s%-20s\u001B[0m%n", "34", "Islem Tarihi :", "Onceki Bakiye",
                            "Cekilen Tutar", "Guncel Site Bakiyesi");

                    for (Musteri each : mevcutMusteriHesabi.getBakiyeCekmeGecmisi()) {
                        System.out.printf("\u001B[%sm%-20s%-20.2f%-20.2f%-20.2f\u001B[0m%n",
                                "37", each.getIslemTarihi(), each.getIslemOncesiSiteBakiyesi(), each.getIslemTutari(), each.getSiteBakiyesi());


                    }
                    break;
                case 3:
                    System.out.printf("\u001B[%sm%-20s%-20s%-20s\u001B[0m%n", "34", "Islem Tarihi :",
                            "Kazanilan Bonus", "Toplam Bonus");

                    for (Musteri each : mevcutMusteriHesabi.getBonusGecmisi()) {
                        System.out.printf("\u001B[%sm%-20s%-20.2f%-20.2f\u001B[0m%n",
                                "37", each.getIslemTarihi(), each.getKazanilanBonus(), each.getMusteriBonus());


                    }
                    break;

                case 4:
                    System.out.printf("\u001B[%sm%-20s%-20s%-20s%-20s\u001B[0m%n", "34", "Islem Tarihi",
                            "Urun Adi", "Urun Fiyati", "Alinan Urun Adeti");

                    for (Urunler each : mevcutMusteriHesabi.getAlinanUrunGecmisi()) {
                        System.out.printf("\u001B[%sm%-20s%-20s%-20.2f%-20d\u001B[0m%n",
                                "37", each.getIslemTarihi(), each.getUrunAdi(), each.getUrunFiyati(), each.getAlinanUrunAdeti());

                    }
                    break;
                case 5:
                    System.out.printf("\u001B[%sm%-20s%-20s%-20s%-20s\u001B[0m%n", "34", "Islem Tarihi :", "Onceki Bakiye",
                            "Harcanan Tutar", "Guncel Site Bakiyesi");

                    for (Musteri each : mevcutMusteriHesabi.getHarcamaGecmisi()) {
                        System.out.printf("\u001B[%sm%-20s%-20.2f%-20.2f%-20.2f\u001B[0m%n",
                                "37", each.getIslemTarihi(), each.getIslemOncesiSiteBakiyesi(), each.getIslemTutari(), each.getSiteBakiyesi());


                    }
                    break;


                default:
                    System.out.println("Lutfen gecerli bir tuslama yapiniz.");
                    break;
            }

            System.out.println("Yeni bir islem yapmak ister misiniz?\n" +
                    "Evet ise 1'e\n" +
                    "Ana menuye donmek isterseniz 2'ye\n" +
                    "Cikis yapmak isterseniz istediginiz bir tusa basiniz : ");
            int cikisSecim = intScanner(scan);
            if (cikisSecim == 1) {
                hesapGecmisiniGoruntule(mevcutMusteriHesabi, scan);
            } else if (secim == 2) {
                AnaSayfa.Application();
                break;
            } else {
                System.exit(0);
            }


        } while (true);

        //Yavuz Bey
    }


    static void hesapAyarlari(Scanner scan, Musteri mevcutMusteriHesabi) {
        scan.nextLine();
        //Caner
        int secim;
        do {

            System.out.println("Hesap baskasina devredilemez. Bu sebeple kullanici adinizi degistiremezsiniz !\n" +
                    "1. Sifreyi degistir\n" +
                    "2. Telefon numarasini degistir\n" +
                    "3. Kargo adresini degistir\n" +
                    "4. Mail adresini degistir\n" +
                    "5. Hesap sil\n" +
                    "6. Kullanici menusune don\n" +
                    "Lutfen hangi islemi yapmak istediginizi seciniz : ");
            secim = intScanner(scan);
            switch (secim) {
                case 1:
                    boolean sifreDegistiMi = false;
                    do {
                        scan.nextLine();
                        System.out.println("Guvenlik amaciyla lutfen once sifrenizi giriniz");
                        String eskiSifre = scan.nextLine();
                        if (mevcutMusteriHesabi.getKullanıcıSifre().equals(eskiSifre)) {
                            System.out.print("Lutfen yeni sifrenizi belirleyiniz :");
                            String yeniSifre = scan.nextLine();
                            mevcutMusteriHesabi.setKullanıcıSifre(yeniSifre);
                            sifreDegistiMi = true;
                            System.out.println("Sifreniz basariyla degistirilmistir.Lutfen sifrenizi kimse ila paylasmayin.");
                        } else {
                            System.out.print("Sifrenizi yanlis girdiniz !\n" +
                                    "Lutfen tekrar deneyiniz.");
                        }
                    } while (!sifreDegistiMi);
                    break;
                case 2:
                    boolean telNoDegistiMi = false;
                    do {
                        scan.nextLine();
                        System.out.println("Guvenlik amaciyla lutfen once sifrenizi giriniz");
                        String sifre = scan.nextLine();
                        if (mevcutMusteriHesabi.getKullanıcıSifre().equals(sifre)) {
                            System.out.print("Lutfen yeni telefon numaranizi giriniz :");
                            String yeniTel = scan.nextLine();
                            mevcutMusteriHesabi.setTel(yeniTel);
                            telNoDegistiMi = true;
                            System.out.println("Telefon numaraniz basariyla degistirildi.");
                        } else {
                            System.out.print("Sifrenizi yanlis girdiniz !\n" +
                                    "Lutfen tekrar deneyiniz.");
                        }
                    } while (!telNoDegistiMi);
                    break;
                case 3:
                    boolean kargoAdresiDegistiMi = false;
                    do {
                        scan.nextLine();
                        System.out.println("Guvenlik amaciyla lutfen once sifrenizi giriniz");
                        String sifre = scan.nextLine();
                        if (mevcutMusteriHesabi.getKullanıcıSifre().equals(sifre)) {
                            System.out.print("Lutfen yeni kargo adresinizi giriniz :");
                            String yeniKargoAdresi = scan.nextLine();
                            mevcutMusteriHesabi.setKargoAdresi(yeniKargoAdresi);
                            kargoAdresiDegistiMi = true;
                            System.out.println("Kargo adresiniz basariyla degistirildi.");
                        } else {
                            System.out.print("Sifrenizi yanlis girdiniz !\n" +
                                    "Lutfen tekrar deneyiniz.");
                        }
                    } while (!kargoAdresiDegistiMi);
                    break;
                case 4:
                    boolean mailDegistiMi = false;
                    do {
                        scan.nextLine();
                        System.out.println("Guvenlik amaciyla lutfen once sifrenizi giriniz");
                        String sifre = scan.nextLine();
                        if (mevcutMusteriHesabi.getKullanıcıSifre().equals(sifre)) {
                            System.out.print("Lutfen yeni mail adresinizi giriniz :");
                            String yeniMailAdresi = scan.nextLine();
                            mevcutMusteriHesabi.setMailAdresi(yeniMailAdresi);
                            mailDegistiMi = true;
                            System.out.println("Mail adresiniz basariyla degistirildi.");
                        } else {
                            System.out.print("Sifrenizi yanlis girdiniz !\n" +
                                    "Lutfen tekrar deneyiniz.");
                        }
                    } while (!mailDegistiMi);
                    break;
                case 5:
                    boolean hesapSilindi = false;

                    do {
                        scan.nextLine();
                        System.out.print("Dikkat hesabiniz silinmek uzere. Bu islemi yapmak istediginizden emin misiniz?\n" +
                                "Evet ise 1'e\n" +
                                "Hayir ise 2'ye\n" +
                                "Basiniz :");
                        int devamSecimi = intScanner(scan);
                        if (devamSecimi == 1) {
                            scan.nextLine();
                            System.out.println("Guvenlik amaciyla lutfen once sifrenizi giriniz");
                            String sifre = scan.nextLine();
                            if (mevcutMusteriHesabi.getKullanıcıSifre().equals(sifre)) {

                                System.out.println("Lutfen hesabinizi neden sildiginizi bizimle paylasin :");
                                String silmeSebebi = scan.nextLine();
                                System.out.println("Hesabinizi silmek istediginizden emin misiniz?\n" +
                                        "Lutfen ekranda gordugunuz yaziyi buyuk kucuk harfe dikkat ederek yaziniz. !eMiNiM!");
                                String dogrulama = scan.next();
                                if (dogrulama.equals("!eMiNiM!")) {
                                    System.out.println("Hesabiniz \n" +
                                            silmeSebebi + "\n" +
                                            "gerekcesi ile basariyla silinmistir. Tekrar bekleriz :D" +
                                            "\n Uygulamadan Cikis yapildi !");
                                    Musteri.getTumKullanicilar().remove(mevcutMusteriHesabi);
                                    hesapSilindi = true;
                                    System.exit(0);
                                } else {
                                    System.out.println("Dogrulama kodunu yanlis girdiniz");
                                    System.out.println("Dogrulama kodunu hatali girdiginiz icin hesap silme gerceklestirilemedi.");
                                    break;


                                }

                            } else {
                                System.out.print("Sifrenizi yanlis girdiniz !\n" +
                                        "Sifrenizi yanlis girdiginiz icin hesap silme islemi gerceklestirilemedi !");
                                break;


                            }


                        } else {

                        }
                    } while (!hesapSilindi);

                case 6:


            }
        } while (secim != 6);


    }

    static Musteri musteriHesapBul(String kullaniciNumarasi) {

        for (Musteri hesap : Musteri.getTumKullanicilar()) {
            if (hesap.getKullaniciNumarasi().equals(kullaniciNumarasi)) {
                return hesap;

            }
        }
        return null;
    }

    static Musteri engellenenMusteriHesapBul(String kullaniciNumarasi) {

        for (Musteri hesap : Musteri.getEngellenenKullanicilar()) {
            if (hesap.getKullaniciNumarasi().equals(kullaniciNumarasi)) {
                return hesap;
            }
        }
        return null;

    }

    static void musteriGirisi(Scanner scan) {
        //burada kontrol saglandiktan sonra 'mevcutMusteriHesabi' diye bir degisken olusturulacak.
        //buradan musteriMenu methodu cagrilacak
        //kullanici adi dogru ama sifre 5 defa yanlis ise kullanici engellensin.
        scan.nextLine();
        System.out.print("Lutfen kullanici numaranizi giriniz :");

        String girilenMusteriHesabi = scan.nextLine();
        Musteri engellenenKullanici = engellenenMusteriHesapBul(girilenMusteriHesabi);
        if (engellenenKullanici == null) {

            Musteri mevcutMusteriHesabi = musteriHesapBul(girilenMusteriHesabi);
            int counter = 5;
            if (mevcutMusteriHesabi != null) {
                boolean girisBasarili = false;
                do {
                    System.out.print("Lutfen sifrenizi giriniz :");
                    String girilenSifre = scan.nextLine();
                    if (mevcutMusteriHesabi.getKullanıcıSifre().equals(girilenSifre)) {
                        System.out.println("Giris basarili !");
                        MusteriMenusu.musteriMenu(scan, mevcutMusteriHesabi);
                        girisBasarili = true;
                    } else {
                        counter--;
                        System.out.println("Sifreniz yanlis !" + counter + " defa deneme hakkiniz var. Tekrar deneyiniz.");
                    }

                    if (counter == 0) {

                        Musteri.getEngellenenKullanicilar().add(mevcutMusteriHesabi);
                        Musteri.getTumKullanicilar().remove(mevcutMusteriHesabi);

                        System.out.println("Sifrenizi 5 defa hatali girdiniz !\n" +
                                "Hesabiniz bloke edildi !\n" +
                                "Lutfen musteri hizmetlerine ulasiniz.");

                        //eger kullanici bloke olduysa giriste onun uyarisini gorsun. bunu ayarla!
                    }


                } while (!girisBasarili || counter == 0);

            } else {
                System.out.print("Girdiginiz kullanici hesabi bulunamadi !\n" +
                        "1 : Farkli bir hesap deneyiniz\n" +
                        "2 : Yeni hesap ac\n" +
                        "Ana menuye donmek icin herhangi bir sayiya basabilirsiniz.\n" +
                        "Lutfen hangi islemi yapmak istediginizi belirtiniz :");

                int secim = intScanner(scan);
                if (secim == 1) {
                    musteriGirisi(scan);
                } else if (secim == 2) {
                    yeniHesapAc(scan);
                } else {

                }
            }


        } else {
            System.out.println("Bu hesap bloke olmustur. Lutfen musteri hizmetlerine ulasiniz.\n" +
                    "Veya yeni bir hesap olusturunuz.");

        }

        //Omer Faruk Bey

    }

    static void makbuz(Musteri mevcutMusteriHesabi) {
        // Odeme tamamlandiktan sonra bir makbuz yazilsin.
        // Alinan urunler fiyatlari vs ve toplam miktar vs vs yazsin.
        if (musteriHesapBul(mevcutMusteriHesabi.getKullaniciNumarasi()) != null) {

            System.out.println("Makbuzunuz asagidaki gibidir.");

            System.out.printf("\u001B[36m%-15s%-20s%-20s%-20s%-20s\u001B[0m%n", "Islem Tarihi", "Urun Adi", "Alinan Urun Adeti",
                    "Urun Fiyati", "Toplam Fiyat");

            for (Urunler alinanUrun : mevcutMusteriHesabi.getAlinanUrunGecmisi()) {

                System.out.printf("\u001B[36m%-15s%-20s%-20d%-20.2f%-20.2f\u001B[0m%n",
                        alinanUrun.getIslemTarihi(), alinanUrun.getUrunAdi(), alinanUrun.getAlinanUrunAdeti(),
                        alinanUrun.getUrunFiyati(), (alinanUrun.getAlinanUrunAdeti() * alinanUrun.getUrunFiyati()));
            }
        } else {
            System.out.println("Makbuzunuz asagidaki gibidir.");

            System.out.printf("\u001B[36m%-15s%-20s%-20s%-20s%-20s\u001B[0m%n", "Islem Tarihi", "Urun Adi", "Alinan Urun Adeti",
                    "Urun Fiyati", "Toplam Fiyat");

            for (Urunler alinanUrun : mevcutMusteriHesabi.getAlinanUrunGecmisi()) {

                System.out.printf("\u001B[36m%-15s%-20s%-20d%-20.2f%-20.2f\u001B[0m%n",
                        alinanUrun.getIslemTarihi(), alinanUrun.getUrunAdi(), alinanUrun.getAlinanUrunAdeti(),
                        alinanUrun.getUrunFiyati(), (alinanUrun.getAlinanUrunAdeti() * alinanUrun.getUrunFiyati()));
            }
        }
        // Yavuz Bey
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


            System.out.println("Site Bakiyesinden : " + tutar + "tutarında ödeme yapılmıştır. Kalan Bakiye: "
                    + mevcutMusteriHesabi.getSiteBakiyesi());

            Musteri harcamaGecmisi = new Musteri(islemTarihi, islemOncesiBakiye, tutar, islemSonrasiBakiye);
            mevcutMusteriHesabi.getHarcamaGecmisi().add(harcamaGecmisi);
            makbuz(mevcutMusteriHesabi);
            mevcutMusteriHesabi.getAlisverisSepeti().clear();
        } else {
            System.out.println("Yetersiz Bakiye. Ödeme yapılamadı.\n" +
                    "Hesabiniza bakiye yuklemek isterseniz 1'e,\n" +
                    "Ana menuye donmek isterseniz 2'ye\n" +
                    "Cikis yapmak isterseniz istediginiz bir tusa basiniz.");
            int secim = intScanner(scan);
            if (secim == 1) {
                bakiyeYukle(scan, mevcutMusteriHesabi);
            } else if (secim == 2) {
                AnaSayfa.Application();
            } else {
                System.exit(0);
            }
        }
        //Cemal Bey
    }

    static void bankaKartiIleOde(Musteri mevcutMusteriHesabi, Scanner scan, double tutar) {
        scan.nextLine();
        System.out.print("Lutfen kart numaranizi giriniz : ");
        String kartNo = scan.nextLine();
        System.out.print("Lutfen kartinizin son kullanma tarihini giriniz : ");
        String sonKullanmaTarihi = scan.nextLine();
        System.out.print("Lutfen kartinizin arkasindaki guvenlik kodunu giriniz : ");
        String cvv = scan.nextLine();


        if (!validKartNo(kartNo) || !validSonKullanmaTarihi(sonKullanmaTarihi) || !validCVV(cvv)) {
            System.out.println("Hata: Geçersiz veya eksik parametreler. Ödeme işlemi gerçekleştirilemedi.");
            return;
        }
        if (tutar <= 0) {
            System.out.println("Hata: Geçersiz ödeme miktarı. Ödeme işlemi gerçekleştirilemedi.");
            return;
        }
        System.out.println("Banka Kartı ile: " + tutar + " TL. tutarında ödeme yapılmıştır.");

        makbuz(mevcutMusteriHesabi);

        Musteri harcamaGecmisi = new Musteri(LocalDate.now().toString(), mevcutMusteriHesabi.getSiteBakiyesi(), tutar, mevcutMusteriHesabi.getSiteBakiyesi());
        mevcutMusteriHesabi.getHarcamaGecmisi().add(harcamaGecmisi);

        mevcutMusteriHesabi.getAlisverisSepeti().clear();
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
