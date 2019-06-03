package medic_familie.domain.entity;

public class Copil extends Pacient {
    private int persoaneBolnaveFamilie, nrVaccin;
    private String prenumeMama, prenumeTata;
    private String vaccinuri;
    public Copil(){
        super();
    }
    public Copil(String name1, String name2, int varsta, String risc, int colest, int tens, boolean asigurat, String tip, int persoaneBolnaveFamilie, int nrVaccin, String prenumeMama, String prenumeTata, String vaccinuri) {
        super(name1, name2, varsta, risc, colest, tens, asigurat,tip);
        this.persoaneBolnaveFamilie = persoaneBolnaveFamilie;
        this.nrVaccin = nrVaccin;
        this.prenumeMama = prenumeMama;
        this.prenumeTata = prenumeTata;
        this.vaccinuri = vaccinuri;
    }

    @Override
    public void afiseazaDatePacient() {
        super.afiseazaDatePacient();
        System.out.println("Nr persoane cu boli cardiovasculare din familie: " + persoaneBolnaveFamilie);
        System.out.println("Mama: "+ prenumeMama + " " + getNume()+ "\nTata: " + prenumeTata + " " + getNume());
        System.out.println("Nr vaccinuri: "+ nrVaccin + " iar vaccinurile sunt: "+ vaccinuri);
    }

    public void riscCardiovascular(){
        int nr = 0;
        if( getTensiune() > 139 || getTensiune() < 130)
            nr += 1;
        if(getColesterol() > 240 || getColesterol() < 200)
            nr++;
        if(persoaneBolnaveFamilie == 1 || persoaneBolnaveFamilie == 2)
            nr++;
        if(nr >= 2)
            setRisc("ridicat");
        else
            setRisc("scazut");
    }

    public int getPersoaneBolnaveFamilie() {
        return persoaneBolnaveFamilie;
    }

    public void setPersoaneBolnaveFamilie(int persoaneBolnaveFamilie) {
        this.persoaneBolnaveFamilie = persoaneBolnaveFamilie;
    }

    public int getNrVaccin() {
        return nrVaccin;
    }

    public void setNrVaccin(int nrVaccin) {
        this.nrVaccin = nrVaccin;
    }

    public String getPrenumeMama() {
        return prenumeMama;
    }

    public void setPrenumeMama(String prenumeMama) {
        this.prenumeMama = prenumeMama;
    }

    public String getPrenumeTata() {
        return prenumeTata;
    }

    public void setPrenumeTata(String prenumeTata) {
        this.prenumeTata = prenumeTata;
    }

    public String getVaccinuri() {
        return vaccinuri;
    }

    public void setVaccinuri(String vaccinuri) {
        this.vaccinuri = vaccinuri;
    }
}



