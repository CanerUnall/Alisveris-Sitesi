package baslangic;

import java.util.ArrayList;
import java.util.List;

public class Musteri {

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

    private double musteriBonus;

    public double getMusteriBonus() {
        return musteriBonus;
    }

    private static List<Musteri> tumKullanicilar = new ArrayList<>() ;
    private static List<Musteri> engellenenKullanicilar = new ArrayList<>() ;

    public static List<Musteri> getEngellenenKullanicilar() {
        return engellenenKullanicilar;
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

    public Musteri(String kullaniciAdi, String kullanıcıSifre, int kullaniciYasi,
                   String kullaniciCinsiyeti, String bankaKartiNumarasi, String bankaKartiGuvenlikKodu,
                   String kargoAdresi, String tel, String mailAdresi, double siteBakiyesi, double musteriBonus) {

        this.kullaniciAdi = kullaniciAdi;
        this.kullanıcıSifre = kullanıcıSifre;
        this.kullaniciYasi = kullaniciYasi;
        this.kullaniciCinsiyeti = kullaniciCinsiyeti;
        this.bankaKartiNumarasi = bankaKartiNumarasi;
        this.bankaKartiGuvenlikKodu = bankaKartiGuvenlikKodu;
        this.kargoAdresi = kargoAdresi;
        this.tel = tel;
        this.mailAdresi = mailAdresi;
        this.siteBakiyesi = siteBakiyesi;
        this.musteriBonus = musteriBonus;

    }

    public Musteri() {
    }

}


