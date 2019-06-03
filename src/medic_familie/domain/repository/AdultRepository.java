package medic_familie.domain.repository;

import medic_familie.domain.CabinetException;
import medic_familie.domain.ErrorCode;
import medic_familie.domain.entity.Adult;

import java.util.Set;

public interface AdultRepository {
    public Set<Adult> getAdulti();

    default public boolean insertAdult(Adult adult){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }

    default public boolean saveUpdateAdult(Adult adult){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }

    default public boolean deleteAdult(String nume, String prenume){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }
    default public void updateAdult(String nume, String prenume, int colesterol, int tensiune){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }
}
