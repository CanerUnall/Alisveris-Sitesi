package baslangic;

public class Runner {

    static {
        UrunlerMethodlar.kirtasiye();
        UrunlerMethodlar.elektronik();
        UrunlerMethodlar.manav();
        UrunlerMethodlar.tekstil();
        UrunlerMethodlar.otoAksesuar();
        UrunlerMethodlar.hirdavat();
        UrunlerMethodlar.kisiselBakim();
        UrunlerMethodlar.spor();
        UrunlerMethodlar.kozmetik();
        UrunlerMethodlar.hayvanUrunleri();
        UrunlerMethodlar.tumKategoriler();
        YoneticiMethodlar.tumYoneticiler();

    }

    public static void main(String[] args) {
        UrunlerMethodlar.indirimiAktiflestir();
        AnaSayfa.Application();
        //buraya
    }
}
