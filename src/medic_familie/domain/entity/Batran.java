package medic_familie.domain.entity;

public class Batran extends Pacient {
    private int gradSedentarism;
    private boolean fumator;
    public Batran(){
        super();
    }
    public Batran(String name1, String name2, int varsta, String risc, int colest, int tens, boolean asigurat,String tip, int gradSedentarism,boolean fumator) {
        super(name1, name2, varsta, risc, colest, tens, asigurat,tip);
        this.gradSedentarism = gradSedentarism;
        this.fumator = fumator;
    }
    public void riscCardiovascular(){
        int nr = 0;
        if( getTensiune() > 139 || getTensiune() < 130)
            nr += 1;
        if(getColesterol() > 240 || getColesterol() < 200)
            nr++;
        if(fumator == true)
            nr++;
        if(gradSedentarism >=3 )
            nr++;
        if(nr >= 2)
            setRisc("ridicat");
        else
            setRisc("scazut");
    }

    @Override
    public void afiseazaDatePacient() {
        super.afiseazaDatePacient();
        if(fumator == true)
            System.out.println("Fumator: DA");
        else
            System.out.println("Fumator: Nu");
        System.out.println("Grad sedentarism: "+ gradSedentarism+"\n");
    }

    public void setFumator(boolean fumator) {
        this.fumator = fumator;
    }

    public void setGradSedentarism(int gradSedentarism) {
        this.gradSedentarism = gradSedentarism;
    }

    public boolean isFumator() {
        return fumator;
    }

    public int getGradSedentarism() {
        return gradSedentarism;
    }
}
