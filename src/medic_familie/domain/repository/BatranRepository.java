package medic_familie.domain.repository;

import medic_familie.domain.CabinetException;
import medic_familie.domain.ErrorCode;
import medic_familie.domain.entity.Batran;

import java.util.Set;

public interface BatranRepository {
    public Set<Batran> getBatrani();

    default public boolean insertBatran(Batran batran){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }

    default public boolean saveUpdateBatran(Batran batran){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }

    default public boolean deleteBatran(String nume, String prenume){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }
    default public void updateBatran(String nume, String prenume, int colesterol, int tensiune){
        throw new CabinetException(ErrorCode.NOT_IMPLEMENTED,"Metoda nu este implementata");
    }
}
