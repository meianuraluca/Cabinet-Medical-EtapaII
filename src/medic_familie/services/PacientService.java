package medic_familie.services;
import medic_familie.configuration.RepositoryConfiguration;
import medic_familie.domain.entity.Pacient;
import medic_familie.domain.repository.PacientInterface;
import java.util.ArrayList;
import java.util.List;

public class PacientService {
    PacientInterface pacient = RepositoryConfiguration.getInstance().getPacientrepo();
    public Pacient cautaPacient(String nume, String prenume){
        List<Pacient> pacients = pacient.getPacienti();
        int ok=-1;
        for(int i=0;i<pacients.size();i++)
            if(pacients.get(i).getNume().equals(nume) && pacients.get(i).getPrenume().equals(prenume)) {
                System.out.println("nu intru niciodata aici");
                ok = i;
            }
        if (ok == -1) {
            System.out.println("Nu exista aceasta persoana in baza de date");
            return  null;
        }

        return pacients.get(ok);
    }
    public String tipPacient(Pacient pacient){
        return pacient.getTip();
    }
    public void afiseazaPacienti(){
        List<Pacient> pacients = pacient.getPacienti();
        System.out.println("Doctorii sunt: ");
        for(int i=0;i<pacients.size();i++) {

            System.out.println("Cod " + i + " si numele " + pacients.get(i).getNume()+" si prenume "+ pacients.get(i).getPrenume());
        }
    }
}
