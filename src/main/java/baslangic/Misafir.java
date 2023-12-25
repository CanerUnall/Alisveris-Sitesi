package baslangic;

import java.util.ArrayList;
import java.util.List;

public class Misafir {
    private List<Misafir> misafir = new ArrayList<>();

    public List<Misafir> getMisafir() {
        return misafir;
    }

    public Misafir(List<Misafir> misafir) {
        this.misafir=misafir;
    }
}
