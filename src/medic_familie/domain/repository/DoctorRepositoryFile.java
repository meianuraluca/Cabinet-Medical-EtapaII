package medic_familie.domain.repository;
import medic_familie.domain.entity.Doctor;
import medic_familie.domain.entity.Pediatru;
import medic_familie.domain.entity.MedicFamilie;

import javax.print.Doc;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorRepositoryFile implements DoctorInterface {
    List<Doctor> a = new ArrayList<>();
    public List<Doctor> getDoctori(){
        return a;
    }
    public DoctorRepositoryFile(String fisier1, String fisier2) throws FileNotFoundException{
        FileInputStream fisMedicFamilie = new FileInputStream(fisier1);
        Scanner scanner1 = new Scanner(fisMedicFamilie);
        while(scanner1.hasNext()){
            String linie = scanner1.nextLine();
            String[] valori = linie.split(",");
            a.add(new MedicFamilie(valori[0], valori[1],Integer.parseInt(valori[2]),valori[3], Boolean.parseBoolean(valori[4]),valori[5]));
        }
        FileInputStream fisPediatru = new FileInputStream(fisier2);
        Scanner scanner2 = new Scanner(fisPediatru);
        while(scanner2.hasNext()){
            String linie = scanner2.nextLine();
            String[] valori = linie.split(",");
            a.add(new Pediatru(valori[0], valori[1], Integer.parseInt(valori[2]), valori[3],Boolean.parseBoolean(valori[4]),valori[5]));
        }
    }
}
