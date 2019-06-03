package medic_familie.Tools;

import medic_familie.domain.entity.Batran;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DataExtractorBatran {
    public static Batran extractSingleBatranFrom(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Batran batran = new Batran();
            batran.setNume(rs.getString("nume"));
            batran.setPrenume(rs.getString("prenume"));
            batran.setVarsta(rs.getInt("varsta"));
            batran.setFumator(rs.getBoolean("fumator"));
            batran.setGradSedentarism(rs.getInt("gradsedentarism"));
            batran.setAsigurat(rs.getBoolean("asigurat"));
            batran.setColesterol(rs.getInt("colesterol"));
            batran.setTensiune(rs.getInt("tensiune"));
            batran.setTip(rs.getString("tip"));
            return batran;
        } else {
            return null;
        }
    }

    public static Set<Batran> extractBatranSetFrom(ResultSet rs) throws SQLException {
        Set<Batran> batrani = new HashSet<>();
        while (rs.next()) {
            Batran batran = new Batran();
            batran.setNume(rs.getString("nume"));
            batran.setPrenume(rs.getString("prenume"));
            batran.setVarsta(rs.getInt("varsta"));
            batran.setFumator(rs.getBoolean("fumator"));
            batran.setGradSedentarism(rs.getInt("gradsedentarism"));
            batran.setAsigurat(rs.getBoolean("asigurat"));
            batran.setColesterol(rs.getInt("colesterol"));
            batran.setTensiune(rs.getInt("tensiune"));
            batran.setTip(rs.getString("tip"));
            batrani.add(batran);
        }
        return batrani;
    }
}
