package medic_familie.domain.entity;

public class Pacient extends Persoana {
    private String risc, tip;
    private int colesterol, tensiune;
    private boolean asigurat;
    private FisaConsultatii[] fisaConsultatie = new FisaConsultatii[]{};

    public FisaConsultatii[] getFisaConsultatie() {
        return fisaConsultatie;
    }

    public void setFisaConsultatie(FisaConsultatii[] fisaConsultatie) {
        this.fisaConsultatie = fisaConsultatie;
    }
    public Pacient(){
        super();
        this.risc="";
        this.colesterol=0;
        this.tensiune=0;
        this.tip="";
    }
    public Pacient(String nume, String prenume, int varsta, String risc, int colesterol, int tensiune, boolean asigurat,String tip) {
        super(nume, prenume, varsta);
        this.risc = risc;
        this.colesterol = colesterol;
        this.tensiune = tensiune;
        this.asigurat = asigurat;
        this.tip = tip;
    }

    public void afiseazaDatePacient(){
        System.out.println("Nume: " + getNume());
        System.out.println("Prenume: "+  getPrenume());
        System.out.println("Varsta: "+ getVarsta());
        if(asigurat==true)
            System.out.println("Pacientul este asigurat");
        else
            System.out.println(" Pacientul nu este asigurat");
        System.out.println("Colesterolul: "+colesterol);
        System.out.println("Tensiune: "+tensiune);
    }
    public boolean isAsigurat() {
        return asigurat;
    }

    public void setAsigurat(boolean asigurat) {
        this.asigurat = asigurat;
    }

    public void setTensiune(int tensiune) {
        this.tensiune = tensiune;
    }

    public void setColesterol(int colesterol) {
        this.colesterol = colesterol;
    }

    public void setRisc(String risc) {
        this.risc = risc;
    }


    public int getTensiune() {
        return tensiune;
    }

    public int getColesterol() {
        return colesterol;
    }

    public String getRisc() {
        return risc;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
