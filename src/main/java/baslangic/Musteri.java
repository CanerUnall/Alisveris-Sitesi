package baslangic;

import java.util.ArrayList;
import java.util.List;

public class Musteri {
    private double kazanilanBonus;
    private String kullaniciAdi;
    private String kullanıcıSifre;
    private int kullaniciYasi;
    private String kullaniciCinsiyeti;
    private String bankaKartiNumarasi;
    private String bankaKartiGuvenlikKodu;
    private String kargoAdresi;
    private String tel;
    private String mailAdresi;
    private double siteBakiyesi;
    private String kullaniciNumarasi;
    private String islemTarihi;
    private double islemTutari;
    private double musteriBonus;
    private double islemOncesiSiteBakiyesi;

    public double getIslemOncesiSiteBakiyesi() {
        return islemOncesiSiteBakiyesi;
    }

    public double getKazanilanBonus() {
        return kazanilanBonus;
    }

    public double getMusteriBonus() {
        return musteriBonus;
    }

    public static void setKullaniciKayitNumarasi(int kullaniciKayitNumarasi) {
        Musteri.kullaniciKayitNumarasi = kullaniciKayitNumarasi;
    }

    private static int kullaniciKayitNumarasi = 1000;
    private static List<Musteri> tumKullanicilar = new ArrayList<>();
    private static List<Musteri> engellenenKullanicilar = new ArrayList<>();
    private List<Urunler> alisverisSepeti = new ArrayList<>();
    private List<Musteri> bakiyeYuklemeGecmisi = new ArrayList<>();
    private List<Musteri> bakiyeCekmeGecmisi = new ArrayList<>();
    private List<Urunler> alinanUrunGecmisi = new ArrayList<>();
    private List<Musteri> bonusGecmisi = new ArrayList<>();

    public List<Urunler> getAlisverisSepeti() {
        return alisverisSepeti;
    }

    public List<Musteri> getBakiyeYuklemeGecmisi() {
        return bakiyeYuklemeGecmisi;
    }

    public List<Musteri> getBakiyeCekmeGecmisi() {
        return bakiyeCekmeGecmisi;
    }

    public List<Urunler> getAlinanUrunGecmisi() {
        return alinanUrunGecmisi;
    }

    public List<Musteri> getBonusGecmisi() {
        return bonusGecmisi;
    }

    public static List<Musteri> getEngellenenKullanicilar() {
        return engellenenKullanicilar;
    }

    public static int getKullaniciKayitNumarasi() {
        return kullaniciKayitNumarasi;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getKullanıcıSifre() {
        return kullanıcıSifre;
    }

    public int getKullaniciYasi() {
        return kullaniciYasi;
    }

    public static List<Musteri> getTumKullanicilar() {
        return tumKullanicilar;
    }

    public String getKullaniciCinsiyeti() {
        return kullaniciCinsiyeti;
    }

    public String getBankaKartiNumarasi() {
        return bankaKartiNumarasi;
    }

    public String getBankaKartiGuvenlikKodu() {
        return bankaKartiGuvenlikKodu;
    }

    public String getKargoAdresi() {
        return kargoAdresi;
    }

    public double getSiteBakiyesi() {
        return siteBakiyesi;
    }

    public String getKullaniciNumarasi() {
        return kullaniciNumarasi;
    }

    public String getTel() {
        return tel;
    }

    public String getMailAdresi() {
        return mailAdresi;
    }

    public void setSiteBakiyesi(double siteBakiyesi) {
        this.siteBakiyesi = siteBakiyesi;
    }

    public String getIslemTarihi() {
        return islemTarihi;
    }

    public void setMusteriBonus(double musteriBonus) {
        this.musteriBonus = musteriBonus;
    }

    public double getIslemTutari() {
        return islemTutari;
    }

    public Musteri(String kullaniciAdi, String kullaniciSifre, int kullaniciYasi,
                   String kullaniciCinsiyeti, String bankaKartiNumarasi, String bankaKartiGuvenlikKodu,
                   String kargoAdresi, String tel, String mailAdresi, double siteBakiyesi, double musteriBonus,
                   String kullaniciNumarasi, List<Urunler> alisverisSepeti, List<Urunler> alinanUrunGecmisi,
                   List<Musteri> bakiyeCekmeGecmisi, List<Musteri> bakiyeYuklemeGecmisi, List<Musteri> bonusGecmisi) {

        this.kullaniciAdi = kullaniciAdi;
        this.kullanıcıSifre = kullaniciSifre;
        this.kullaniciYasi = kullaniciYasi;
        this.kullaniciCinsiyeti = kullaniciCinsiyeti;
        this.bankaKartiNumarasi = bankaKartiNumarasi;
        this.bankaKartiGuvenlikKodu = bankaKartiGuvenlikKodu;
        this.kargoAdresi = kargoAdresi;
        this.tel = tel;
        this.mailAdresi = mailAdresi;
        this.siteBakiyesi = siteBakiyesi;
        this.musteriBonus = musteriBonus;
        this.kullaniciNumarasi = kullaniciNumarasi;
        this.alinanUrunGecmisi = alinanUrunGecmisi;
        this.alisverisSepeti = alisverisSepeti;
        this.bakiyeCekmeGecmisi = bakiyeCekmeGecmisi;
        this.bakiyeYuklemeGecmisi = bakiyeYuklemeGecmisi;
        this.bonusGecmisi = bonusGecmisi;

    }

    //islem gecmisi icin olusturduk
    public Musteri(String islemTarih,double islemOncesiSiteBakiyesi, double islemTutari, double siteBakiyesi) {
        this.islemTarihi = islemTarih;
        this.islemTutari = islemTutari;
        this.siteBakiyesi = siteBakiyesi;
        this.islemOncesiSiteBakiyesi=islemOncesiSiteBakiyesi;
    }

    //bonus gecmısı ıcın olusturduk
    public Musteri(double kazanilanBonus, String islemTarih, double musteriBonus) {
        this.islemTarihi = islemTarih;
        this.kazanilanBonus = kazanilanBonus;
        this.musteriBonus = musteriBonus;
    }


    public Musteri() {
    }
}


