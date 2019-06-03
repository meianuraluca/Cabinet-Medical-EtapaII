package medic_familie.domain.repository;
import medic_familie.domain.entity.Analize;
import medic_familie.domain.entity.FisaConsultatii;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class FisaConsultatiiRepositoryFile implements FisaConsulatatiiInterface {
    TreeSet<FisaConsultatii> a = new TreeSet<>(new Comparator<FisaConsultatii>() {
        @Override
        public int compare(FisaConsultatii o1, FisaConsultatii o2) {
            if (o1.getAn()>o2.getAn())
                return 0;
            else
                if (o1.getAn()<o2.getAn())
                    return 1;
                else
                    if (o1.getLuna()>o2.getLuna())
                        return 0;
                    else
                        if(o1.getLuna()<o2.getLuna())
                            return 1;
                        else
                            if(o1.getZi()>o2.getZi())
                                return 0;
                            return 1;

        }
    });

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
            Analize analiza = new Analize(Float.parseFloat(valori[3]), Float.parseFloat(valori[4]), Float.parseFloat(valori[5]), Float.parseFloat(valori[6]), Float.parseFloat(valori[7]));
            //a.add(new FisaConsultatii(nume,prenume,an, luna, zi, analiza));
        }
    }
}
