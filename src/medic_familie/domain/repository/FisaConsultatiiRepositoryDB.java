package medic_familie.domain.repository;

import medic_familie.Tools.DataExtractorFise;
import medic_familie.configuration.ConnectionFactory;
import medic_familie.domain.entity.Analize;
import medic_familie.domain.entity.FisaConsultatii;

import java.sql.*;
import java.util.TreeSet;

public class FisaConsultatiiRepositoryDB implements FisaConsulatatiiInterface {
    private static final String GET_ALL_USERS = "SELECT * FROM fise";
    private static final String CREATE_NEW_USER = "INSERT INTO fise (nume,prenume,an,luna,zi,calciu,glucoza,vitamine,proteine,mangneziu) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static FisaConsultatiiRepositoryDB instance = new FisaConsultatiiRepositoryDB();
    public static FisaConsultatiiRepositoryDB getInstance(){
        return instance;
    }

    @Override
    public TreeSet<FisaConsultatii> getFise() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_USERS);
            return DataExtractorFise.extractFiseSetFrom(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertFise(FisaConsultatii fisaConsultatii) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(CREATE_NEW_USER);
            stmt.setString(1, fisaConsultatii.getNume());
            stmt.setString(2, fisaConsultatii.getPrenume());
            stmt.setInt(3, fisaConsultatii.getAn());
            stmt.setInt(4, fisaConsultatii.getLuna());
            stmt.setInt(5, fisaConsultatii.getZi());
            Analize analize = fisaConsultatii.getSetAnalize();
            stmt.setFloat(6, analize.getCalciu());
            stmt.setFloat(7,analize.getGlucoza());
            stmt.setFloat(8, analize.getVitamine());
            stmt.setFloat(9,analize.getProteine());
            stmt.setFloat(10,analize.getMagneziu());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveUpdateFise(FisaConsultatii fisaConsultatii) {
        return false;
    }

    @Override
    public boolean deleteFise(String nume, String prenume) {
        return false;
    }

}

