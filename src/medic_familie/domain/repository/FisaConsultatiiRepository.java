package medic_familie.domain.repository;

import medic_familie.domain.entity.FisaConsultatii;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;

public class FisaConsultatiiRepository {
    private TreeSet<FisaConsultatii> fise = new TreeSet<>();
    public TreeSet<FisaConsultatii> getFise(){
        return fise;
    }
}
