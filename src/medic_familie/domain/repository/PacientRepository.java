package medic_familie.domain.repository;

import medic_familie.domain.entity.Pacient;
import medic_familie.domain.entity.Copil;
import medic_familie.domain.entity.Adult;
import medic_familie.domain.entity.Batran;
import java.util.ArrayList;
import java.util.List;

public class PacientRepository {
    private List<Pacient> pacienti = new ArrayList<>();
    public List<Pacient> getPacienti(){
        return pacienti;
    }
    public PacientRepository(){
        pacienti.add(new Copil("Meianu", "Teodora",11,"",200,13,true,"copil",0,2,"Aurelia", "Gheorghe","antitetanic antituberculoza"));
        pacienti.add(new Copil("Smaranda", "Andrei",19,"",170,12,false,"copil",0,1,"Lili","Claudiu",""));
        pacienti.add(new Copil("Gavrila","Andrada",19,"",180,11,true,"copil",2,3,"Mona","Nelu",""));
        pacienti.add(new Adult("Meianu","Aurelia",48,"",180,12,true,"adult",false,"educator"));
        pacienti.add(new Adult("Meianu", "Gheorghe",49,"",170,12,true,"adult",false,"tamplar"));
        pacienti.add(new Adult("Smaranda", "Lili",30,"",140,12,false,"adult",true,"barman"));
        pacienti.add(new Adult("Smaranda","Claudiu",38,"",180,12,false,"adult",true,"tirist"));
        pacienti.add(new Adult("Gavrila","Mona",34,"",190,11,true,"adult",false,"vanzator"));
        pacienti.add(new Adult("Gavrila", "Nelu",40,"",200,12,true,"adult",true,"vanzator"));
        pacienti.add(new Batran("Barbulescu","Elena",70,"",190,13,true,"batran",2,false));
        pacienti.add(new Batran("Budascu","Alexandra",80,"",190,12,false,"batran",3,true));
        pacienti.add(new Batran("Aledea","Sorina",90,"",180,11,true,"batran",2,true));
    }
}
