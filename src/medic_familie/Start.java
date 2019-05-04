package medic_familie;

import medic_familie.domain.entity.*;
import medic_familie.services.*;

import java.util.Scanner;
import medic_familie.Tools.Iesire;
public class Start {
    public static void main(String[] args){
        System.out.println("Bine ati venit la cabinetul nostru");
        System.out.println("Alegeti codul unuia dintre doctorii nostri");
        Iesire variabila = new Iesire();
        DoctorService doctori = new DoctorService();
        PacientService pacienti = new PacientService();
        pacienti.afiseazaPacienti();
        PediatruService pediatru = new PediatruService();
        MedicFamilieService medicFamilie = new MedicFamilieService();
        AnalizeService analizeService = new AnalizeService();
        variabila.addToFile("Afiseaza Doctorii");
        doctori.afiseazaDoctori();
        Scanner input = new Scanner(System.in);
        int optiune = input.nextInt();
        variabila.addToFile("Returneaza doctorul");
        Doctor doctor = doctori.daDoctor(optiune);
        variabila.addToFile("Specializarea Doctorului");
        String specializare = doctori.daSpecializare(optiune);
        System.out.println("Introdu numele pacientului");
        Scanner input1 = new Scanner(System.in);
        String nume = input1.nextLine();
        System.out.println("Introdu prenumele pacientului");
        Scanner input2 = new Scanner(System.in);
        String prenume = input2.nextLine();
        System.out.println("Se cauta pacientul in baza de date ");
        variabila.addToFile("Cauta pacientul");
        Pacient pacient = pacienti.cautaPacient(nume, prenume);
        if(specializare.equals("pediatru") && pacient != null) {
            Copil copil = (Copil) pacient;
            System.out.println("Introdu 1 -- pentru a scrie o trimitere\nIntrodu 2 -- pentru a verifica daca copilul are nevoie de vreun vaccin\nIntrodu 3 -- pentru a scrie o reteta ");
            Scanner input4 = new Scanner(System.in);
            int caz = input4.nextInt();
            while (caz != 0) {
                switch (caz) {
                    case 1: {
                        variabila.addToFile("Scrie trimitere");
                        pediatru.scrieTrimitere(copil,doctor);
                        break;
                    }
                    case 2: {
                        variabila.addToFile("Verifica vaccinurile");
                        pediatru.verficaVaccin(copil);
                        break;
                    }
                    case 3: {
                        variabila.addToFile("Scrie reteta");
                        pediatru.scrieReteta(copil,doctor);
                        break;
                    }
                }
                System.out.println("Pentru a iesi apasati 0 altfel una din optiunile de mai sus");
                Scanner input6 = new Scanner(System.in);
                caz = input6.nextInt();
                }
            }
        if(specializare.equals("medic familie") && pacient!= null) {
            System.out.println("Vrei sa faci un set de analize pacientului? --DA-- sau --NU--");
            Scanner input7 = new Scanner(System.in);
            String raspuns1 = input7.nextLine();
            Analize set_analize ;
            if(raspuns1.equals("DA")) {
                set_analize = new Analize(9, 170, 22, 7, 1);
                //variabila.addToFile("Adauga analize");
                medicFamilie.adaugaAnaliza(set_analize,pacient,30,3,2019);
            }
            System.out.println("Introdu 1 -- pentru a afisa analizele\nIntrodu 2 -- pentru a vedea cum au iesit analizele\nIntrodu 3 -- pentru a verifica riscul pacientului la boli cardiovasculare\nIntrodu 4 -- pentru scierea retetei\nIntrodu 5 -- pentru scrierea trimiterii");
            Scanner input4 = new Scanner(System.in);
            int caz = input4.nextInt();
            while (caz != 0) {
                switch (caz) {
                    case 1: {
                        if(raspuns1.equals("DA"))
                        {
                            FisaConsultatii[] fisa_analize = pacient.getFisaConsultatie();
                            Analize analiza = fisa_analize[fisa_analize.length-1].getSet_analize();
                            variabila.addToFile("Afiseaza analize");
                            analiza.afiseazaAnalize();}
                        else
                            System.out.println("Nu ati facut niciun set de analize");
                        break;
                    }
                    case 2: {
                        if(raspuns1.equals("DA")) {
                            FisaConsultatii[] fisa_analize = pacient.getFisaConsultatie();
                            Analize analiza = fisa_analize[fisa_analize.length - 1].getSet_analize();
                            variabila.addToFile("Rezultate analize");
                            boolean rezultat = analizeService.rezultatAnalize(analiza);
                            if (rezultat = true) {
                                System.out.println("Vreti diagnosticul? --DA-- sau --NU--");
                                Scanner input8 = new Scanner(System.in);
                                String raspuns2 = input8.nextLine();
                                if (raspuns2.equals("DA")) {
                                    variabila.addToFile("Diagnostic analize");
                                    analizeService.diagnosticAnalize(analiza);
                                }
                            }
                        }
                        else
                            System.out.println("Nu ati facut niciun set de analize");
                        break;
                    }
                    case 3: {
                        if (pacienti.tipPacient(pacient).equals("copil")) {
                            pacient = (Copil) pacient;
                            variabila.addToFile("Risc cardiovascular");
                            ((Copil) pacient).riscCardiovascular();
                        }
                        if (pacienti.tipPacient(pacient).equals("adult")) {
                            pacient = (Adult) pacient;
                            variabila.addToFile("Risc cardiovascular");
                            ((Adult) pacient).riscCardiovascular();
                        }
                        if (pacienti.tipPacient(pacient).equals("batran")) {
                            pacient = (Batran) pacient;
                            variabila.addToFile("Risc cardiovascular");
                            ((Batran) pacient).riscCardiovascular();
                        }
                        System.out.println("Riscul cardiovascular este "+ pacient.getRisc());
                        break;
                    }
                    case 4:{
                        System.out.println("Intrudu 1 -- pentru a genera tu reteta\nIntrodu 2 -- pentru a genera calculatorul reteta");
                        Scanner input9 = new Scanner(System.in);
                        int optiune1 = input9.nextInt();
                        if(optiune1 == 1){
                            variabila.addToFile("Scrie reteta manual");
                            medicFamilie.scrieRetetaManual();
                        }
                        else
                        if(optiune1 == 2) {
                            variabila.addToFile("Scrie reteta automat");
                            medicFamilie.scrieRetetaAutomat(pacient,doctor);
                        }
                        break;
                    }
                    case 5:{
                        System.out.println("Intrudu 1 -- pentru a genera tu trimitere\nIntrodu 2 -- pentru a genera calculatorul trimitere");
                        Scanner input9 = new Scanner(System.in);
                        int optiune1 = input9.nextInt();
                        if(optiune1 == 1){
                            variabila.addToFile("Scrie trimitere manual");
                            medicFamilie.scrieTrimitereManual();
                        }
                        else
                        if(optiune1 == 2) {
                            variabila.addToFile("Scrie trimitere automat");
                            medicFamilie.scrieTrimitereAutomat(pacient,doctor);
                        }
                        break;
                    }
                }
                System.out.println("Pentru a iesi apasati 0 altfel una din optiunile de mai sus");
                Scanner input6 = new Scanner(System.in);
                caz = input6.nextInt();
            }
        }
    }

}

