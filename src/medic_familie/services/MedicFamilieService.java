package medic_familie.services;

import medic_familie.configuration.RepositoryConfiguration;
import medic_familie.domain.entity.*;

import java.util.List;
import java.util.Scanner;
import medic_familie.domain.entity.Trimitere;
import medic_familie.domain.repository.DoctorInterface;
public class MedicFamilieService {
    public void adaugaAnaliza(Analize set_analize, Pacient pacient, int zi, int luna, int an){
        FisaConsultatii[] fisa = pacient.getFisaConsultatie();
        if(fisa.length>=1) {
            FisaConsultatii[] newA = new FisaConsultatii[fisa.length + 1];
            for (int i = 0; i < fisa.length; i++) {
                newA[i].setAn(fisa[i].getAn());
                newA[i].setLuna(fisa[i].getLuna());
                newA[i].setZi(fisa[i].getZi());
                newA[i].setDiagnostic(fisa[i].getDiagnostic());
                newA[i].setSetAnalize(fisa[i].getSet_analize());
            }

            newA[newA.length - 1].setZi(zi);
            newA[newA.length - 1].setLuna(luna);
            newA[newA.length - 1].setAn(an);
            newA[newA.length - 1].setSetAnalize(set_analize);
            fisa = newA;
        }
        else {

            FisaConsultatii[] fisa_consultatie = new FisaConsultatii[]{new FisaConsultatii(2019,3,30,set_analize)};
            pacient.setFisaConsultatie(fisa_consultatie);
        }



    }
    public void scrieRetetaAutomat(Pacient pacient, Doctor doctor){
        Reteta reteta = new Reteta();
        reteta.setNume(pacient.getNume());
        reteta.setPrenume(pacient.getPrenume());
        reteta.setCabinet(doctor.getCabinetDoctor());
        reteta.setDoctor(doctor.getNume() +" "+doctor.getPrenume());
        if(pacient.getRisc().equals("ridicat"))
            reteta.setDiagnostic("cardiovascular");
        FisaConsultatii[] fisa = pacient.getFisaConsultatie();
        AnalizeService var = new AnalizeService();
        var.diagnosticAnalize(fisa[fisa.length-1].getSet_analize());
        fisa[fisa.length-1].decideDiagnostic();
        reteta.setDiagnostic(fisa[fisa.length-1].getDiagnostic());
        pastileRecomandate(reteta.getDiagnostic(),reteta);
        reteta.afiseazaReteta();
        System.out.println("Daca sunteti de acord cu reteta generata scrieti --DA--, altfel scrie --NU-- pentru a genera manual reteta");
        Scanner input10 = new Scanner(System.in);
        String alegere = input10.nextLine();
        if(alegere.equals("NU"))
            scrieRetetaManual();
    }
    public void pastileRecomandate(String diagnostic,Reteta reteta){
        String pastila;
        int nr_pastile;
        if(diagnostic.equals("cardiovascular")){
            pastila = "aspirina";
            reteta.setPastila(pastila);
            nr_pastile = 1;
            reteta.setNrPastileZi(nr_pastile);
        }
        if(diagnostic.equals("hipercalcemie")){
            pastila = "Calciu Forte";
            reteta.setPastila(pastila);
            nr_pastile = 2;
            reteta.setNrPastileZi(nr_pastile);
        }
        if(diagnostic.equals("diabet zaharat")){
            pastila = "suliqua";
            reteta.setPastila(pastila);
            nr_pastile = 1;
            reteta.setNrPastileZi(nr_pastile);
        }
        if(diagnostic.equals("anemie")){
            pastila = "ferrogradumet";
            reteta.setPastila(pastila);
            nr_pastile = 1;
            reteta.setNrPastileZi(nr_pastile);

        }
        if(diagnostic.equals("kwashiorkor")){
            pastila = "vitamina B12";
            reteta.setPastila(pastila);
            nr_pastile = 2;
            reteta.setNrPastileZi(nr_pastile);
        }
    }
    public void scrieRetetaManual(){
        Reteta reteta = new Reteta();
        System.out.println("Dati numele pacientului");
        Scanner input2 = new Scanner(System.in);
        String nume = input2.nextLine();
        reteta.setNume(nume);
        System.out.println("Dati prenumele pacientului");
        Scanner input3 = new Scanner(System.in);
        String prenume = input3.nextLine();
        reteta.setPrenume(prenume);
        System.out.println("Dati numele cabinetului");
        Scanner input4 = new Scanner(System.in);
        String cabinet = input4.nextLine();
        reteta.setCabinet(cabinet);
        System.out.println("Dati numele doctorului");
        Scanner input5 = new Scanner(System.in);
        String docotor = input5.nextLine();
        reteta.setDoctor(docotor);
        System.out.println("Dati diagnosticul");
        Scanner input6 = new Scanner(System.in);
        String diagnostic = input6.nextLine();
        reteta.setDiagnostic(diagnostic);
        System.out.println("Dati numele pastilei");
        Scanner input7 = new Scanner(System.in);
        String pastila = input7.nextLine();
        reteta.setPastila(pastila);
        System.out.println("Dati numarul de pastile pe zi");
        Scanner input8 = new Scanner(System.in);
        int nr_pastile = input8.nextInt();
        reteta.setNrPastileZi(nr_pastile);

    }

    public void scrieTrimitereAutomat(Pacient pacient, Doctor doctor){
        Trimitere trimitere = new Trimitere();
        trimitere.setNume(pacient.getNume());
        trimitere.setPrenume(pacient.getPrenume());
        trimitere.setCabinet(doctor.getCabinetDoctor());
        trimitere.setDoctor(doctor.getNume() + " "+ doctor.getPrenume());
        if(pacient.getRisc().equals("ridicat"))
            trimitere.setDiagnostic("cardiovascular");
        FisaConsultatii[] fisa = pacient.getFisaConsultatie();
        AnalizeService var = new AnalizeService();
        var.diagnosticAnalize(fisa[fisa.length-1].getSet_analize());
        fisa[fisa.length-1].decideDiagnostic();
        trimitere.setDiagnostic(fisa[fisa.length-1].getDiagnostic());
        specialistRecomandat(trimitere.getDiagnostic(),trimitere);
        trimitere.afiseazaTrimitere();
        System.out.println("Daca sunteti de acord cu reteta generata scrieti --DA--, altfel scrie --NU-- pentru a genera manual reteta");
        Scanner input10 = new Scanner(System.in);
        String alegere = input10.nextLine();
        if (alegere.equals("NU"))
            scrieTrimitereManual();
    }
    public void specialistRecomandat(String diagnostic,Trimitere trimitere){
        String specialist, locatie;
        if(diagnostic.equals("cardiovascular")){
            specialist = "cardiolog";
            trimitere.setSpecialist(specialist);
            locatie = "Cardiologie la Spitalul Universitar/ Elias";
            trimitere.setLocatie(locatie);
        }
        if(diagnostic.equals("hipercalcemie")){
            specialist = "endocrinolog";
            trimitere.setSpecialist(specialist);
            locatie = "Endocrinologie la Clinica Imamed/Exmedica/ Institutul Național de Endocrinologie C.I. Parhon";
            trimitere.setLocatie(locatie);
        }
        if(diagnostic.equals("diabet zaharat")){
            specialist = "medic specializat diabet";
            trimitere.setSpecialist(specialist);
            locatie = "La Spitalul Medijobs/ Institutul Național de Diabet, Nutriție și Boli Metabolice";
            trimitere.setLocatie(locatie);
        }
        if(diagnostic.equals("anemie")){
            specialist = "hematolog";
            trimitere.setSpecialist(specialist);
            locatie = "Hematologie la Spitalul Fundeni/Centrul de Transfuzie Sanguină";
            trimitere.setLocatie(locatie);

        }
        if(diagnostic.equals("kwashiorkor")){
            specialist = "medic specializat nutritie";
            trimitere.setSpecialist(specialist);
            locatie = "La Institutul Național de Diabet, Nutriție și Boli Metabolice";
            trimitere.setLocatie(locatie);
        }
    }
    public void scrieTrimitereManual(){
        Trimitere trimitere = new Trimitere();
        System.out.println("Dati numele pacientului");
        Scanner input2 = new Scanner(System.in);
        String nume = input2.nextLine();
        trimitere.setNume(nume);
        System.out.println("Dati prenumele pacientului");
        Scanner input3 = new Scanner(System.in);
        String prenume = input3.nextLine();
        trimitere.setPrenume(prenume);
        System.out.println("Dati numele cabinetului");
        Scanner input4 = new Scanner(System.in);
        String cabinet = input4.nextLine();
        trimitere.setCabinet(cabinet);
        System.out.println("Dati numele doctorului");
        Scanner input5 = new Scanner(System.in);
        String docotor = input5.nextLine();
        trimitere.setDoctor(docotor);
        System.out.println("Dati diagnosticul");
        Scanner input6 = new Scanner(System.in);
        String diagnostic = input6.nextLine();
        trimitere.setDiagnostic(diagnostic);
        System.out.println("Dati specialistul");
        Scanner input7 = new Scanner(System.in);
        String specialist = input7.nextLine();
        trimitere.setSpecialist(specialist);
        System.out.println("Dati locatia");
        Scanner input8 = new Scanner(System.in);
        String  locatie = input8.nextLine();
        trimitere.setLocatie(locatie);

    }



}
