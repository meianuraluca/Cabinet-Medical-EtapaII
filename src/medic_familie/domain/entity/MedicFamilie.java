package medic_familie.domain.entity;

import java.util.Scanner;
import java.util.TreeSet;

public class MedicFamilie extends Doctor {
    private Reteta[] reteteDate;
    private Trimitere[] trimiteri;
    public MedicFamilie(String nume, String prenume, int varsta, String cabinetDoctor, boolean titular,String specializare) {
        super(nume, prenume, varsta, cabinetDoctor, titular,specializare);
    }

    public Reteta[] getRetete_date() {
        return reteteDate;
    }

    public void setRetete_date(Reteta[] retete_date) {
        this.reteteDate = retete_date;
    }

    public Trimitere[] getTrimiteri() {
        return trimiteri;
    }

    public void setTrimiteri(Trimitere[] trimiteri) {
        this.trimiteri = trimiteri;
    }

}
