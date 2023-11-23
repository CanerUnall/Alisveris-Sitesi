package baslangic;

public class Urunler {

    //Ubeyde bey

    private String urunAdi;
    private double urunFiyati;
    private int stokAdeti;

    public String getUrunAdi() {
        return urunAdi;
    }

    public double getUrunFiyati() {
        return urunFiyati;
    }

    public int getStokAdeti() {
        return stokAdeti;
    }

    public Urunler(String urunAdi, double urunFiyati, int stokAdeti) {
        this.urunAdi = urunAdi;
        this.urunFiyati = urunFiyati;
        this.stokAdeti = stokAdeti;
    }

    public Urunler() {
    }


}
