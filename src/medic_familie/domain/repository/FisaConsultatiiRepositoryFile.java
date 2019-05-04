package medic_familie.domain.repository;
import medic_familie.domain.entity.FisaConsultatii;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import medic_familie.domain.entity.Analize;

public class FisaConsultatiiRepositoryFile implements FisaConsulatatiiInterface {
    TreeSet<FisaConsultatii> a = new TreeSet<>();

    public TreeSet<FisaConsultatii> getFise() {
        return a;
    }

    public FisaConsultatiiRepositoryFile(String fisier1) throws FileNotFoundException {
        FileInputStream fisMedicFamilie = new FileInputStream(fisier1);
        Scanner scanner1 = new Scanner(fisMedicFamilie);
        while (scanner1.hasNext()) {
            String linie = scanner1.nextLine();
            String[] valori = linie.split(",");
            int an = Integer.parseInt(valori[0]);
            int luna = Integer.parseInt(valori[1]);
            int zi = Integer.parseInt(valori[2]);
            Analize analiza = new Analize(Double.parseDouble(valori[3]), Double.parseDouble(valori[4]), Double.parseDouble(valori[5]), Double.parseDouble(valori[6]), Double.parseDouble(valori[7]));
            a.add(new FisaConsultatii(an, luna, zi, analiza));
        }
    }
}
