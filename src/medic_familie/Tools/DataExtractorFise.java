package medic_familie.Tools;

import medic_familie.domain.entity.FisaConsultatii;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.TreeSet;

public class DataExtractorFise {
    public static FisaConsultatii extractSingleFiseFrom(ResultSet rs) throws SQLException {
        if (rs.next()) {
            FisaConsultatii fisa = new FisaConsultatii();
            fisa.setNume(rs.getString("nume"));
            fisa.setPrenume(rs.getString("prenume"));
            fisa.setAn(rs.getInt("an"));
            fisa.setLuna(rs.getInt("luna"));
            fisa.setZi(rs.getInt("zi"));
            fisa.setSetAnalize(rs.getFloat("calciu"),rs.getFloat("glucoza"),rs.getFloat("vitamine"),rs.getFloat("proteine"),rs.getFloat("mangneziu"));
            return fisa;
        } else {
            return null;
        }
    }

    public static TreeSet<FisaConsultatii> extractFiseSetFrom(ResultSet rs) throws SQLException {
        TreeSet<FisaConsultatii> fise = new TreeSet<>();
        while (rs.next()) {
            FisaConsultatii fisa = new FisaConsultatii();
            fisa.setNume(rs.getString("nume"));
            fisa.setPrenume(rs.getString("prenume"));
            fisa.setAn(rs.getInt("an"));
            fisa.setLuna(rs.getInt("luna"));
            fisa.setZi(rs.getInt("zi"));
            fisa.setSetAnalize(rs.getFloat("calciu"),rs.getFloat("glucoza"),rs.getFloat("vitamine"),rs.getFloat("proteine"),rs.getFloat("mangneziu"));
            fise.add(fisa);
        }
        return fise;
    }
}
