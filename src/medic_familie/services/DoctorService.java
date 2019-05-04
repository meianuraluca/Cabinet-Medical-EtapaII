package medic_familie.services;

import com.sun.jdi.ThreadReference;
import medic_familie.configuration.RepositoryConfiguration;
import medic_familie.domain.entity.Doctor;
import medic_familie.domain.repository.DoctorInterface;

import javax.print.Doc;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class DoctorService {
    DoctorInterface doctor = RepositoryConfiguration.getInstance().getDoctorrepo();
    public void afiseazaDoctori(){
        List<Doctor> doctori = doctor.getDoctori();
        System.out.println("Doctorii sunt: ");
        for(int i=0;i<doctori.size();i++) {

            System.out.println("Cod " + i + " si numele " + doctori.get(i).getNume()+" iar specializarea este "+doctori.get(i).getSpecializare());
        }
    }
    public String daSpecializare(int cod){
        String specializare="";
        List<Doctor> doctori = doctor.getDoctori();
        for(int i=0;i<doctori.size();i++){
            if(cod == i)
                specializare = doctori.get(i).getSpecializare();
        }
        return specializare;
    }
    public Doctor daDoctor(int cod){
        List<Doctor> doctori = doctor.getDoctori();
        return doctori.get(cod);
    }
}
