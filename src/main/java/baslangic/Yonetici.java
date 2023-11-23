package baslangic;

public class Yonetici {
    //Setler kullanilabilir
    private String yoneticiID;
    private String yoneticiSifre;

    public String getYoneticiID() {
        return yoneticiID;
    }

    public String getYoneticiSifre() {
        return yoneticiSifre;
    }

    public Yonetici(String yoneticiID, String yoneticiSifre) {
        this.yoneticiID = yoneticiID;
        this.yoneticiSifre = yoneticiSifre;

    }

    public Yonetici() {
    }
}
