package medic_familie.domain.repository;
import medic_familie.domain.CabinetException;
import medic_familie.domain.ErrorCode;
import medic_familie.domain.entity.FisaConsultatii;

import java.util.TreeSet;

public interface FisaConsulatatiiInterface {
    public TreeSet<FisaConsultatii> getFise();

    default public boolean insertFise(FisaConsultatii fisaConsultatii){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }

    default public boolean saveUpdateFise(FisaConsultatii fisaConsultatii){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }

    default public boolean deleteFise(String nume, String prenume){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }
}
