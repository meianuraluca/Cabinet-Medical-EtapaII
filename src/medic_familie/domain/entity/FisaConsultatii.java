package medic_familie.domain.entity;

public class FisaConsultatii {
    private int an, zi ,luna;
    private Analize setAnalize;
    private String diagnostic;

    public FisaConsultatii(int an, int luna , int zi,Analize setAnalize) {
        this.an = an;
        this.luna = luna;
        this.zi = zi;
        this.setAnalize = setAnalize;
    }

    public Analize getSet_analize() {
        return setAnalize;
    }

    public void setSetAnalize(Analize setAnalize) {
        this.setAnalize = setAnalize;
    }
    public void decideDiagnostic(){
        if(setAnalize.isBolnavCalciu())
            diagnostic = "hipercalcemie";
        if(setAnalize.isBolnavGlucoza())
            diagnostic = "diabet zaharat";
        if(setAnalize.isBolnavMagneziu())
            diagnostic = "anemie";
        if(setAnalize.isBolnavProteine())
            diagnostic = "kwashiorkor";
    }
    public void setLuna(int luna) {
        this.luna = luna;
    }

    public void setZi(int zi) {
        this.zi = zi;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getZi() {
        return zi;
    }

    public int getLuna() {
        return luna;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public int getAn() {
        return an;
    }
}
