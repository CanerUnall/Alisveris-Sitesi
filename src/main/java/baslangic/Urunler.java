package baslangic;

public class Urunler {

    //Ubeyde bey

    private String urunAdi;
    private double urunFiyati;
    private int stokAdeti;
    private double indirimsizFiyat;
    private String indirimsizIsim;

    public String getIndirimsizIsim() {
        return indirimsizIsim;
    }


    public double getIndirimsizFiyat() {
        return indirimsizFiyat;
    }

    public void setUrunFiyati(double urunFiyati) {
        this.urunFiyati = urunFiyati;
    }

    private String islemTarihi;
    private int alinanUrunAdeti;

    public String getUrunAdi() {
        return urunAdi;
    }

    public String getIslemTarihi() {
        return islemTarihi;
    }

    public int getAlinanUrunAdeti() {
        return alinanUrunAdeti;
    }

    public double getUrunFiyati() {
        return urunFiyati;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public int getStokAdeti() {
        return stokAdeti;
    }

    public void setStokAdeti(int stokAdeti) {
        this.stokAdeti = stokAdeti;
    }

    public Urunler(String urunAdi, double urunFiyati, int stokAdeti) {
        this.urunAdi = urunAdi;
        this.urunFiyati = urunFiyati;
        this.stokAdeti = stokAdeti;
        this.indirimsizFiyat = urunFiyati;
        this.indirimsizIsim= urunAdi;
    }

    // islem tarihini belirlemek icin olusturduk
    public Urunler(String islemTarihi, String urunAdi, double urunFiyati, int alinanUrunAdeti) {
        this.urunAdi = urunAdi;
        this.urunFiyati = urunFiyati;
        this.islemTarihi = islemTarihi;
        this.alinanUrunAdeti = alinanUrunAdeti;
    }
}
