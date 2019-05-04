package medic_familie.domain.entity;

public class Analize {
    private double calciu, glucoza, vitamine, proteine, magneziu;
    private boolean bolnavCalciu,bolnavGlucoza,bolnavProteine,bolnavMagneziu;


    public Analize(double calciu, double glucoza, double vitamine, double proteine, double magneziu) {
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

    public void setCalciu(double calciu) {
        this.calciu = calciu;
    }

    public void setGlucoza(double glucoza) {
        this.glucoza = glucoza;
    }

    public void setVitamine(double vitamine) {
        this.vitamine = vitamine;
    }

    public void setProteine(double proteine) {
        this.proteine = proteine;
    }

    public void setMagneziu(double magneziu) {
        this.magneziu = magneziu;
    }

    public double getCalciu() {
        return calciu;
    }

    public double getGlucoza() {
        return glucoza;
    }

    public double getVitamine() {
        return vitamine;
    }

    public double getProteine() {
        return proteine;
    }

    public double getMagneziu() {
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
