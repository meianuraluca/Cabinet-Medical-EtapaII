package medic_familie.configuration;

import medic_familie.domain.repository.*;

import java.io.FileNotFoundException;

public class RepositoryConfiguration {
    private static RepositoryConfiguration instance = new RepositoryConfiguration();
    private PacientInterface pacientrepo;
    private DoctorInterface doctorrepo;
    private FisaConsulatatiiInterface fisarepo;
    public static RepositoryConfiguration getInstance(){
        return instance;
    }
    private RepositoryConfiguration(){
        //System.out.println("ajung pe aici");
        try {
             doctorrepo = new DoctorRepositoryFile("pediatru.csv","medicFamilie.csv");
              }
        catch (FileNotFoundException E){
            System.out.println("Fisierul nu este bun");
        }
    }

    public PacientInterface getPacientrepo() {
        return pacientrepo;
    }

    public DoctorInterface getDoctorrepo() {
        return doctorrepo;
    }

    public FisaConsulatatiiInterface getFisarepo() {
        return fisarepo;
    }
}
