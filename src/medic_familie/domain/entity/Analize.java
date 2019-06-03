package medic_familie.domain.entity;

public class Analize {
    private float calciu, glucoza, vitamine, proteine, magneziu;
    private boolean bolnavCalciu,bolnavGlucoza,bolnavProteine,bolnavMagneziu;


    public Analize(float calciu, float glucoza, float vitamine, float proteine, float magneziu) {
        this.calciu = calciu;
        this.glucoza = glucoza;
        this.vitamine = vitamine;
        this.proteine = proteine;
        this.magneziu = magneziu;
    }
    public void afiseazaAnalize(){
        System.out.println("Datele iesite la analize sunt urmatoarele:\n");
        System.out.println("Calciu - "+ calciu +"\n");
        System.out.println("Glucoza - "+ glucoza+"\n");
        System.out.println("Vitamine - "+ vitamine+"\n");
        System.out.println("Proteine - "+ proteine+"\n");
        System.out.println("Magneziu - "+ magneziu+"\n");

    }

    public void setCalciu(float calciu) {
        this.calciu = calciu;
    }

    public void setGlucoza(float glucoza) {
        this.glucoza = glucoza;
    }

    public void setVitamine(float vitamine) {
        this.vitamine = vitamine;
    }

    public void setProteine(float proteine) {
        this.proteine = proteine;
    }

    public void setMagneziu(float magneziu) {
        this.magneziu = magneziu;
    }

    public float getCalciu() {
        return calciu;
    }

    public float getGlucoza() {
        return glucoza;
    }

    public float getVitamine() {
        return vitamine;
    }

    public float getProteine() {
        return proteine;
    }

    public float getMagneziu() {
        return magneziu;
    }

    public boolean isBolnavCalciu() {
        return bolnavCalciu;
    }

    public void setBolnavCalciu(boolean bolnavCalciu) {
        this.bolnavCalciu = bolnavCalciu;
    }

    public boolean isBolnavGlucoza() {
        return bolnavGlucoza;
    }

    public void setBolnavGlucoza(boolean bolnavGlucoza) {
        this.bolnavGlucoza = bolnavGlucoza;
    }

    public boolean isBolnavProteine() {
        return bolnavProteine;
    }

    public void setBolnavProteine(boolean bolnavProteine) {
        this.bolnavProteine = bolnavProteine;
    }

    public boolean isBolnavMagneziu() {
        return bolnavMagneziu;
    }

    public void setBolnavMagneziu(boolean bolnavMagneziu) {
        this.bolnavMagneziu = bolnavMagneziu;
    }
}
