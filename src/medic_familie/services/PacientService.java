package medic_familie.services;
import medic_familie.Tools.Iesire;
import medic_familie.domain.entity.Adult;
import medic_familie.domain.entity.Batran;
import medic_familie.domain.entity.Copil;
import medic_familie.domain.entity.Pacient;
import medic_familie.domain.repository.AdultRepositoryDB;
import medic_familie.domain.repository.BatranRepositoryDB;
import medic_familie.domain.repository.CopilRepositoryDB;

import java.util.Scanner;
import java.util.Set;

public class PacientService {
    public Pacient cautaPacient(String nume, String prenume,String tip){
        Iesire.getInstance().addToFile("Cauta pacient");
        Pacient aux = new Pacient();
        if(tip.equals("copil")){
            CopilRepositoryDB pacient = CopilRepositoryDB.getInstance();
            Set<Copil> pacients = pacient.getCopii();
            int ok=-1;
            for(Copil copil:pacients)
                if(copil.getNume().equals(nume) && copil.getPrenume().equals(prenume)) {
                    System.out.println("nu intru niciodata aici");
                    System.out.println(copil.getNume()+copil.getPrenume());
                    ok = 1;
                    aux = copil;
                }
            if (ok == -1) {
                System.out.println("Nu exista aceasta persoana in baza de date. Doriti sa o introduceti? DA/NU");
                Scanner input7 = new Scanner(System.in);
                String raspuns1 = input7.nextLine();
                if (raspuns1.equals("DA")){
                    CopilRepositoryDB copil = CopilRepositoryDB.getInstance();
                    System.out.println("Dati numele");
                    Scanner input1 = new Scanner(System.in);
                    String numee = input1.nextLine();
                    System.out.println("Dati prenumele");
                    Scanner input2 = new Scanner(System.in);
                    String prenumee= input2.nextLine();
                    System.out.println("Dati varsta");
                    Scanner input3 = new Scanner(System.in);
                    Integer varsta = input3.nextInt();
                    String gen = "copil";
                    System.out.println("Dati colesterol");
                    Scanner input4 = new Scanner(System.in);
                    Integer colesterol = input4.nextInt();
                    System.out.println("Dati tensiune");
                    Scanner input5 = new Scanner(System.in);
                    Integer tensiune = input5.nextInt();
                    Boolean asigurat = true;
                    System.out.println("Dati prenumele mamei");
                    Scanner input6 = new Scanner(System.in);
                    String mama = input6.nextLine();
                    System.out.println("Dati prenumele tatalui");
                    Scanner input8 = new Scanner(System.in);
                    String tata= input8.nextLine();
                    System.out.println("Dati nr persoane bolnave in familie");
                    Scanner input9= new Scanner(System.in);
                    Integer bolna = input9.nextInt();
                    System.out.println("Dati nr vaccinuri");
                    Scanner input10 = new Scanner(System.in);
                    Integer nr = input10.nextInt();
                    System.out.println("Dati vaccinurile facute");
                    Scanner input11 = new Scanner(System.in);
                    String vaccinuri = input11.nextLine();
                    Copil copilas = new Copil(numee,prenumee,varsta,"",colesterol,tensiune,asigurat,gen,bolna,nr,mama,tata,vaccinuri);
                    copil.insertCopil(copilas);
                    aux = copilas;
                }
            }}

        if(tip.equals("adult")){
            AdultRepositoryDB pacient = AdultRepositoryDB.getInstance();
            Set<Adult> pacients = pacient.getAdulti();
            int ok=-1;
            for(Adult adult:pacients)
                if(adult.getNume().equals(nume) && adult.getPrenume().equals(prenume)) {
                    System.out.println("nu intru niciodata aici");
                    System.out.println(adult.getNume()+adult.getPrenume());
                    ok = 1;
                    aux = adult;
                }
            if (ok == -1) {
                System.out.println("Nu exista aceasta persoana in baza de date. Doriti sa o introduceti? DA/NU");
                Scanner input7 = new Scanner(System.in);
                String raspuns1 = input7.nextLine();
                if (raspuns1.equals("DA")){
                    AdultRepositoryDB adultt = AdultRepositoryDB.getInstance();
                    System.out.println("Dati numele");
                    Scanner input1 = new Scanner(System.in);
                    String numee = input1.nextLine();
                    System.out.println("Dati prenumele");
                    Scanner input2 = new Scanner(System.in);
                    String prenumee= input2.nextLine();
                    System.out.println("Dati varsta");
                    Scanner input3 = new Scanner(System.in);
                    Integer varsta = input3.nextInt();
                    String gen = "adult";
                    System.out.println("Dati colesterol");
                    Scanner input4 = new Scanner(System.in);
                    Integer colesterol = input4.nextInt();
                    System.out.println("Dati tensiune");
                    Scanner input5 = new Scanner(System.in);
                    Integer tensiune = input5.nextInt();
                    Boolean asigurat = true;
                    System.out.println("Dati ocupatia");
                    Scanner input6 = new Scanner(System.in);
                    String ocupatia = input6.nextLine();
                    System.out.println("Sunteti fumator? DA/NU");
                    Scanner input11 = new Scanner(System.in);
                    String rasp = input11.nextLine();
                    Boolean fumator = false;
                    if (rasp.equals("DA"))
                        fumator = true;
                    Adult adult = new Adult(numee,prenumee,varsta,"",colesterol,tensiune,asigurat,gen,fumator,ocupatia);
                    adultt.insertAdult(adult);
                    aux = adult;
            }}}
        if(tip.equals("batran")){
            BatranRepositoryDB pacient = BatranRepositoryDB.getInstance();
            Set<Batran> pacients = pacient.getBatrani();
            int ok=-1;
            for(Batran batran:pacients)
                if(batran.getNume().equals(nume) && batran.getPrenume().equals(prenume)) {
                    System.out.println("nu intru niciodata aici");
                    System.out.println(batran.getNume()+batran.getPrenume());
                    ok = 1;
                    aux = batran;
                }
            if (ok == -1) {
                BatranRepositoryDB batran = BatranRepositoryDB.getInstance();
                System.out.println("Dati numele");
                Scanner input1 = new Scanner(System.in);
                String numee = input1.nextLine();
                System.out.println("Dati prenumele");
                Scanner input2 = new Scanner(System.in);
                String prenumee= input2.nextLine();
                System.out.println("Dati varsta");
                Scanner input3 = new Scanner(System.in);
                Integer varsta = input3.nextInt();
                String gen = "batran";
                System.out.println("Dati colesterol");
                Scanner input4 = new Scanner(System.in);
                Integer colesterol = input4.nextInt();
                System.out.println("Dati tensiune");
                Scanner input5 = new Scanner(System.in);
                Integer tensiune = input5.nextInt();
                Boolean asigurat = true;
                System.out.println("Dati gradul de sedentarism");
                Scanner input9 = new Scanner(System.in);
                Integer grad = input9.nextInt();
                System.out.println("Sunteti fumator? DA/NU");
                Scanner input11 = new Scanner(System.in);
                String rasp = input11.nextLine();
                Boolean fumator = false;
                if (rasp.equals("DA"))
                    fumator = true;
                Batran batranel = new Batran(numee,prenumee,varsta,"",colesterol,tensiune,asigurat,gen,grad,fumator);
                batran.insertBatran(batranel);
                aux = batranel;
            }}
        return aux;
    }
    }


