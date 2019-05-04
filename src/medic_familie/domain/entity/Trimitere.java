package medic_familie.domain.entity;

public class Trimitere {
    private String locatie;
    private String specialist;
    private String diagnostic;
    private String nume;
    private String prenume;
    private String doctor;

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    private String cabinet;

    public Trimitere(String locatie, String specialist, String diagnostic, String nume, String prenume, String doctor, String cabinet) {
        this.locatie = locatie;
        this.specialist = specialist;
        this.diagnostic = diagnostic;
        this.nume = nume;
        this.prenume = prenume;
        this.doctor = doctor;
        this.cabinet = cabinet;
    }

    public Trimitere(){
        this.locatie="";
        this.specialist="";
        this.diagnostic="";
        this.nume ="";
        this.prenume="";
        this.cabinet="";
        this.doctor="";
    }
    public void afiseazaTrimitere(){
        System.out.println("Numele pacientului: "+ nume);

        System.out.println("Prenumele pacientului: " + prenume);

        System.out.println("Numele cabinetului: "+ cabinet);

        System.out.println("Numele doctorului: "+doctor);

        System.out.println("Diagnosticul: " + diagnostic);

        System.out.println("Specialistul: "+ specialist);

        System.out.println("Locatia: "+ locatie);


    }
    public String getLocatie() {
        return locatie;
    }

    public String getSpecialist() {
        return specialist;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
}
