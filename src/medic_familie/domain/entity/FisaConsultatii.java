package medic_familie.domain.entity;

public class FisaConsultatii {
    private int an, zi ,luna;
    private Analize setAnalize;
    private String diagnostic, nume, prenume;
    public FisaConsultatii(){
        an = 0;
        zi = 0;
        luna = 0;
    }
    public FisaConsultatii(String nume,String prenume,int an, int luna , int zi,Analize setAnalize) {
        this.nume = nume;
        this.prenume = prenume;
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

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
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

    public Analize getSetAnalize() {
        return setAnalize;
    }
    public void setSetAnalize(float a, float b,float c, float d, float e){
        setAnalize.setCalciu(a);
        setAnalize.setGlucoza(b);
        setAnalize.setVitamine(c);
        setAnalize.setProteine(d);
        setAnalize.setMagneziu(e);
    }
    public int getAn() {
        return an;
    }
}
