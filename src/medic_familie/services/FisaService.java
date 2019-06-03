package medic_familie.services;

import medic_familie.Tools.Iesire;
import medic_familie.configuration.RepositoryConfiguration;
import medic_familie.domain.entity.FisaConsultatii;
import medic_familie.domain.repository.FisaConsulatatiiInterface;

import java.util.Iterator;
import java.util.TreeSet;

public class FisaService {
    FisaConsulatatiiInterface fise = RepositoryConfiguration.getInstance().getFisarepo();
    public void afiseaza_fisele (){
        Iesire.getInstance().addToFile("Afiseaza Fisele");
        TreeSet<FisaConsultatii> fisa = fise.getFise();
        Iterator<FisaConsultatii> iterator = fisa.iterator();
        FisaConsultatii indice = null;
        while((iterator.hasNext())){
            indice = iterator.next();
            System.out.println(indice.getZi()+" "+indice.getLuna() + " "+ indice.getAn() + " " +indice.getDiagnostic());
        }
    }
}
