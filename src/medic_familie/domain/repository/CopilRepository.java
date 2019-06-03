package medic_familie.domain.repository;

import medic_familie.domain.CabinetException;
import medic_familie.domain.ErrorCode;
import medic_familie.domain.entity.Copil;

import java.util.Set;

public interface CopilRepository {
    public Set<Copil> getCopii();

    default public boolean insertCopil(Copil copil){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }

    default public boolean saveUpdateCopil(Copil copil){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }

    default public boolean deleteCopil(String nume, String prenume){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }
    default public void updateCopil(String nume, String prenume, int colesterol, int tensiune){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }
}
