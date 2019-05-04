package medic_familie.domain.repository;

import medic_familie.domain.entity.Doctor;
import medic_familie.domain.entity.MedicFamilie;
import medic_familie.domain.entity.Pediatru;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository implements DoctorInterface{
    private List<Doctor> doctori = new ArrayList<>();
    public List<Doctor> getDoctori(){
        return doctori;
    }
    public DoctorRepository(){

        doctori.add(new MedicFamilie("Folea", "Elena",50,"Medlife",true,"medic familie"));
        doctori.add(new Pediatru("Popescu", "Marian", 34,"Medlife",true,"pediatru"));
    }
}
