package medic_familie.services;
import medic_familie.Tools.Iesire;
import medic_familie.domain.entity.Adult;
import medic_familie.domain.entity.Batran;
import medic_familie.domain.entity.Copil;
import medic_familie.domain.entity.Pacient;
import medic_familie.domain.repository.AdultRepositoryDB;
import medic_familie.domain.repository.BatranRepositoryDB;
import medic_familie.domain.repository.CopilRepositoryDB;

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
                System.out.println("Nu exista aceasta persoana in baza de date");
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
                System.out.println("Nu exista aceasta persoana in baza de date");
            }}
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
                System.out.println("Nu exista aceasta persoana in baza de date");
            }}
        return aux;
    }
    public String tipPacient(Pacient pacient){
        return pacient.getTip();
    }
    }

