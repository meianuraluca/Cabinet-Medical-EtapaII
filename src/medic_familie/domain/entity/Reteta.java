package medic_familie.domain.entity;

public class Reteta {

    private String nume, prenume, diagnostic, pastila;
    private int nrPastileZi;
    private String doctor, cabinet;

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getCabinet() {
        return cabinet;
    }

    public Reteta(String nume, String prenume, String diagnostic, String pastila, int nrPastileZi, String doctor, String cabinet) {
        this.nume = nume;
        this.prenume = prenume;
        this.diagnostic = diagnostic;
        this.pastila = pastila;
        this.nrPastileZi = nrPastileZi;
        this.doctor = doctor;
        this.cabinet = cabinet;
    }
    public Reteta(){
        this.nume = "";
        this.prenume = "";
        this.diagnostic = "";
        this.pastila = "";
        this.nrPastileZi = 0;
        this.doctor = "";
        this.cabinet = "";
    }
    public void afiseazaReteta(){
        System.out.println("Numele pacientului: "+ nume);

        System.out.println("Prenumele pacientului: " + prenume);

        System.out.println("Numele cabinetului: "+ cabinet);

        System.out.println("Numele doctorului: "+doctor);

        System.out.println("Diagnosticul: " + diagnostic);

        System.out.println("Numele pastilei: "+ pastila);

        System.out.println("Numarul de pastile pe zi: "+ nrPastileZi);


    }
    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public String getPastila() {
        return pastila;
    }

    public int getNrPastileZi() {
        return nrPastileZi;
    }

    public void setNrPastileZi(int nrPastileZi) {
        this.nrPastileZi = nrPastileZi;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public void setPastila(String pastila) {
        this.pastila = pastila;
    }


}
