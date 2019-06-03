package medic_familie.domain.repository;

import medic_familie.domain.entity.Pacient;
import medic_familie.domain.entity.Copil;
import medic_familie.domain.entity.Adult;
import medic_familie.domain.entity.Batran;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PacientRepositoryFile implements PacientInterface {
    List<Pacient> a = new ArrayList<>();
    public List<Pacient> getPacienti(){
        return a;
    }
//    public PacientRepositoryFile(String fisier1, String fisier2, String fisier3) throws FileNotFoundException{
//        //System.out.println("Si intru si aici");
//        FileInputStream fisCopii = new FileInputStream(fisier1);
//        Scanner scanner1 = new Scanner(fisCopii);
//        while(scanner1.hasNext()){
//            String linie = scanner1.nextLine();
//            String[] valori = linie.split(",");
//            a.add(new Copil(valori[0], valori[1],Integer.parseInt(valori[2]),valori[3], Integer.parseInt(valori[4]),Integer.parseInt(valori[5]),Boolean.parseBoolean(valori[6]),valori[7],Integer.parseInt(valori[8]),Integer.parseInt(valori[9]),valori[10],valori[11],valori[12]));
//        }
//        FileInputStream fisAdult = new FileInputStream(fisier2);
//        Scanner scanner2 = new Scanner(fisAdult);
//        while(scanner2.hasNext()){
//            String linie = scanner2.nextLine();
//            String[] valori = linie.split(",");
//            a.add(new Adult(valori[0], valori[1],Integer.parseInt(valori[2]),valori[3], Integer.parseInt(valori[4]),Integer.parseInt(valori[5]),Boolean.parseBoolean(valori[6]),valori[7], Boolean.parseBoolean(valori[8]),valori[9]));
//        }
//        FileInputStream fisBatran = new FileInputStream(fisier3);
//        Scanner scanner3 = new Scanner(fisBatran);
//        while(scanner3.hasNext()){
//            String linie = scanner3.nextLine();
//            String[] valori = linie.split(",");
//            a.add(new Batran(valori[0], valori[1],Integer.parseInt(valori[2]),valori[3], Integer.parseInt(valori[4]),Integer.parseInt(valori[5]),Boolean.parseBoolean(valori[6]),valori[7],Integer.parseInt(valori[8]), Boolean.parseBoolean(valori[9])));
//        }
//    }
}
