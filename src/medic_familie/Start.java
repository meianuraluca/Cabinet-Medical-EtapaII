
package medic_familie;

import medic_familie.domain.entity.*;
import medic_familie.services.*;

import java.util.Scanner;

public class Start {
    public static void main(String[] args){
        DatabaseSetup datebase = DatabaseSetup.getInstance();
        datebase.initDatabase();
       // Application.launch(args);
        System.out.println("Bine ati venit la cabinetul nostru");
        System.out.println("Alegeti codul unuia dintre doctorii nostri");
        DoctorService doctori = new DoctorService();
        PacientService pacienti = new PacientService();
        FisaService fise = new FisaService();
        PediatruService pediatru = new PediatruService();
        MedicFamilieService medicFamilie = new MedicFamilieService();
        AnalizeService analizeService = new AnalizeService();
        doctori.afiseazaDoctori();
        Scanner input = new Scanner(System.in);
        int optiune = input.nextInt();
        Doctor doctor = doctori.daDoctor(optiune);
        String specializare = doctori.daSpecializare(optiune);
        System.out.println("Introdu numele pacientului");
        Scanner input1 = new Scanner(System.in);
        String nume = input1.nextLine();
        System.out.println("Introdu prenumele pacientului");
        Scanner input2 = new Scanner(System.in);
        String prenume = input2.nextLine();
        System.out.println("Introdu tipul pacientului");
        Scanner input3 = new Scanner(System.in);
        String tip = input3.nextLine();
        System.out.println("Se cauta pacientul in baza de date ");
        Pacient pacient = pacienti.cautaPacient(nume, prenume,tip);

        if(specializare.equals("pediatru") && pacient != null) {
            Copil copil = (Copil) pacient;
            System.out.println("Introdu 1 -- pentru a scrie o trimitere\nIntrodu 2 -- pentru a verifica daca copilul are nevoie de vreun vaccin\nIntrodu 3 -- pentru a scrie o reteta ");
            Scanner input4 = new Scanner(System.in);
            int caz = input4.nextInt();
            while (caz != 0) {
                switch (caz) {
                    case 1: {
                        pediatru.scrieTrimitere(copil,doctor);
                        break;
                    }
                    case 2: {
                        pediatru.verficaVaccin(copil);
                        break;
                    }
                    case 3: {
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
                            analiza.afiseazaAnalize();}
                        else
                            System.out.println("Nu ati facut niciun set de analize");
                        break;
                    }
                    case 2: {
                        if(raspuns1.equals("DA")) {
                            FisaConsultatii[] fisa_analize = pacient.getFisaConsultatie();
                            Analize analiza = fisa_analize[fisa_analize.length - 1].getSet_analize();
                            boolean rezultat = analizeService.rezultatAnalize(analiza);
                            if (rezultat = true) {
                                System.out.println("Vreti diagnosticul? --DA-- sau --NU--");
                                Scanner input8 = new Scanner(System.in);
                                String raspuns2 = input8.nextLine();
                                if (raspuns2.equals("DA")) {
                                    analizeService.diagnosticAnalize(analiza);
                                }
                            }
                        }
                        else
                            System.out.println("Nu ati facut niciun set de analize");
                        break;
                    }
                    case 3: {
                        if (tip.equals("copil")) {
                            pacient = (Copil) pacient;
                            ((Copil) pacient).riscCardiovascular();
                        }
                        if (tip.equals("adult")) {
                            pacient = (Adult) pacient;
                            ((Adult) pacient).riscCardiovascular();
                        }
                        if (tip.equals("batran")) {
                            pacient = (Batran) pacient;
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
                            medicFamilie.scrieRetetaManual();
                        }
                        else
                        if(optiune1 == 2) {
                            medicFamilie.scrieRetetaAutomat(pacient,doctor);
                        }
                        break;
                    }
                    case 5:{
                        System.out.println("Intrudu 1 -- pentru a genera tu trimitere\nIntrodu 2 -- pentru a genera calculatorul trimitere");
                        Scanner input9 = new Scanner(System.in);
                        int optiune1 = input9.nextInt();
                        if(optiune1 == 1){
                            medicFamilie.scrieTrimitereManual();
                        }
                        else
                        if(optiune1 == 2) {
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
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        URL resource = getClass().getResource("Prima.fxml");
//        Parent root = FXMLLoader.load(resource);
//        primaryStage.setScene(new Scene(root,800,500));
//        primaryStage.show();
//    }



}

