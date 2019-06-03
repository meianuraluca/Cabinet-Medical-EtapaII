package medic_familie.domain.entity;

public class Adult extends Pacient {
    private boolean fumator;
    private String ocupatie;

    public Adult(){
        super();
        this.ocupatie="";
    }
    public Adult(String name1, String name2, int varsta, String risc, int colest, int tens, boolean asigurat,String tip, boolean fumator, String locMunca) {
        super(name1, name2, varsta, risc, colest, tens, asigurat,tip);
        this.fumator = fumator;
        this.ocupatie = locMunca;
    }
    public void riscCardiovascular(){
        int nr = 0;
        if( getTensiune() > 139 || getTensiune() < 130)
            nr += 1;
        if(getColesterol() > 240 || getColesterol() < 200)
            nr++;
        if(fumator == true)
            nr++;
        if(nr >= 2)
            setRisc("ridicat");
        else
            setRisc("scazut");
    }

    @Override
    public void afiseazaDatePacient() {
        super.afiseazaDatePacient();
        System.out.println("Ocupatie : " + ocupatie);
        if(fumator == true)
            System.out.println("Fumator: DA");
        else
            System.out.println("Fumator: Nu");

    }

    public void setLoc_de_munca(String loc_de_munca) {
        this.ocupatie = loc_de_munca;
    }

    public void setFumator(boolean fumator) {
        this.fumator = fumator;
    }

    public String getLoc_de_munca() {
        return ocupatie;
    }

    public boolean isFumator() {
        return fumator;
    }
}
