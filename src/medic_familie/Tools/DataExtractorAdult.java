package medic_familie.Tools;

import medic_familie.domain.entity.Adult;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DataExtractorAdult {
    public static Adult extractSingleAdultFrom(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Adult adult = new Adult();
            adult.setNume(rs.getString("nume"));
            adult.setPrenume(rs.getString("prenume"));
            adult.setVarsta(rs.getInt("varsta"));
            adult.setFumator(rs.getBoolean("fumator"));
            adult.setLoc_de_munca(rs.getString("locmunca"));
            adult.setAsigurat(rs.getBoolean("asigurat"));
            adult.setColesterol(rs.getInt("colesterol"));
            adult.setTensiune(rs.getInt("tensiune"));
            adult.setTip(rs.getString("tip"));
            return adult;
        } else {
            return null;
        }
    }

    public static Set<Adult> extractAdultSetFrom(ResultSet rs) throws SQLException {
        Set<Adult> adulti = new HashSet<>();
        while (rs.next()) {
            Adult adult = new Adult();
            adult.setNume(rs.getString("nume"));
            adult.setPrenume(rs.getString("prenume"));
            adult.setVarsta(rs.getInt("varsta"));
            adult.setFumator(rs.getBoolean("fumator"));
            adult.setLoc_de_munca(rs.getString("locmunca"));
            adult.setAsigurat(rs.getBoolean("asigurat"));
            adult.setColesterol(rs.getInt("colesterol"));
            adult.setTensiune(rs.getInt("tensiune"));
            adult.setTip(rs.getString("tip"));
            adulti.add(adult);
        }
        return adulti;
    }
}
