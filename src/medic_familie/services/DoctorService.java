package medic_familie.services;

import medic_familie.Tools.Iesire;
import medic_familie.configuration.RepositoryConfiguration;
import medic_familie.domain.entity.Doctor;
import medic_familie.domain.repository.DoctorInterface;

import java.util.List;

public class DoctorService {
    DoctorInterface doctor = RepositoryConfiguration.getInstance().getDoctorrepo();
    public void afiseazaDoctori(){
        Iesire.getInstance().addToFile("Afiseaza Doctori");
        List<Doctor> doctori = doctor.getDoctori();
        System.out.println("Doctorii sunt: ");
        for(int i=0;i<doctori.size();i++) {

            System.out.println("Cod " + i + " si numele " + doctori.get(i).getNume()+" iar specializarea este "+doctori.get(i).getSpecializare());
        }
    }
    public String daSpecializare(int cod){
        Iesire.getInstance().addToFile("Specializarea docturului");
        String specializare="";
        List<Doctor> doctori = doctor.getDoctori();
        for(int i=0;i<doctori.size();i++){
            if(cod == i)
                specializare = doctori.get(i).getSpecializare();
        }
        return specializare;
    }
    public Doctor daDoctor(int cod){
        Iesire.getInstance().addToFile("Returneaza doctor");
        List<Doctor> doctori = doctor.getDoctori();
        return doctori.get(cod);
    }
}
