package medic_familie.Tools;

import medic_familie.domain.entity.Copil;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DataExtractorCopil {
    public static Copil extractSingleCopilFrom(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Copil copil = new Copil();
            copil.setNume(rs.getString("nume"));
            copil.setPrenume(rs.getString("prenume"));
            copil.setVarsta(rs.getInt("varsta"));
            copil.setPersoaneBolnaveFamilie(rs.getInt("persoanebolnavafamilie"));
            copil.setNrVaccin(rs.getInt("nrvaccin"));
            copil.setAsigurat(rs.getBoolean("asigurat"));
            copil.setColesterol(rs.getInt("colesterol"));
            copil.setTensiune(rs.getInt("tensiune"));
            copil.setTip(rs.getString("tip"));
            copil.setPrenumeMama(rs.getString("prenumemama"));
            copil.setPrenumeTata(rs.getString("prenumetata"));
            copil.setVaccinuri(rs.getString("vaccinuri"));
            return copil;
        } else {
            return null;
        }
    }

    public static Set<Copil> extractCopilSetFrom(ResultSet rs) throws SQLException {
        Set<Copil> copii = new HashSet<>();
        System.out.println("si ajung si pana la extragere");
        while (rs.next()) {
            Copil copil = new Copil();
            copil.setNume(rs.getString("nume"));
            copil.setPrenume(rs.getString("prenume"));
            copil.setVarsta(rs.getInt("varsta"));
            copil.setPersoaneBolnaveFamilie(rs.getInt("persoanebolnavafamilie"));
            copil.setNrVaccin(rs.getInt("nrvaccin"));
            copil.setAsigurat(rs.getBoolean("asigurat"));
            copil.setColesterol(rs.getInt("colesterol"));
            copil.setTensiune(rs.getInt("tensiune"));
            copil.setTip(rs.getString("tip"));
            copil.setPrenumeMama(rs.getString("prenumemama"));
            copil.setPrenumeTata(rs.getString("prenumetata"));
            copil.setVaccinuri(rs.getString("vaccinuri"));
            copii.add(copil);
        }
        System.out.println(copii);
        return copii;
    }
}
