package medic_familie.domain.entity;

public  class Doctor extends Persoana {
    private String cabinetDoctor, specializare;
    private boolean titular;


    public Doctor(String nume, String prenume, int varsta, String cabinetDoctor, boolean titular,String specializare) {
        super(nume, prenume, varsta);
        this.cabinetDoctor = cabinetDoctor;
        this.titular = titular;
        this.specializare = specializare;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }
    public boolean isTitular() {
        return titular;
    }


    public String getCabinetDoctor() {
        return cabinetDoctor;
    }

    public void setCabinetDoctor(String cabinet_doctor) {
        this.cabinetDoctor = cabinet_doctor;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }
}
