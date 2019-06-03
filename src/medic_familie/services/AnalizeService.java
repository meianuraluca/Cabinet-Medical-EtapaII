package medic_familie.services;

import medic_familie.Tools.Iesire;
import medic_familie.domain.entity.Analize;

public class AnalizeService {
    public boolean rezultatAnalize(Analize analiza) {
        Iesire.getInstance().addToFile("Rezultate analize");
        int nr = 0;
        if (analiza.getCalciu() < 3.83 || analiza.getCalciu() > 5.06) {
            nr++;
        }
        if (analiza.getGlucoza() < 74 || analiza.getGlucoza() > 106)
            nr++;
        if (analiza.getMagneziu() < 1.71 || analiza.getMagneziu() > 2.22)
            nr++;
        if (analiza.getProteine() < 6.6 || analiza.getProteine()> 8.7)
            nr++;
        if (nr > 1) {
            System.out.println("Analizele nu au iesit bune");
            return true;
        }
        return false;
    }

    public void diagnosticAnalize(Analize analize) {
        Iesire.getInstance().addToFile("Diagnostic analize");
        double nr = analize.getCalciu() - 5.06;
        if (nr > 3) {
            analize.setBolnavCalciu(true);
            System.out.println("Calcemia a iesit foarte mare");
        }
        nr = analize.getGlucoza() - 106;
        if (nr > 30) {
            analize.setBolnavGlucoza(true);
            System.out.println("Glucoza este mult prea mare");
        }
        nr = 1.71 - analize.getMagneziu();
        if (nr > 2) {
            analize.setBolnavMagneziu(true);
            System.out.println("Lipsa de magneziu");
        }
        nr = 6.6 - analize.getProteine();
        if (nr > 3) {
            analize.setBolnavProteine(true);
            System.out.println("Lipsa de proteine");
        }
        System.out.println("In urma rezultatelor, pacientul a fost diagnosticat cu ");
        if (analize.isBolnavCalciu()) System.out.println("HIPERCALCEMIE");
        if (analize.isBolnavGlucoza()) System.out.println("DIABET ZAHARAT");
        if (analize.isBolnavMagneziu()) System.out.println("ANEMIE");
        if (analize.isBolnavProteine()) System.out.println("KWASHIORKOR");
    }
}
