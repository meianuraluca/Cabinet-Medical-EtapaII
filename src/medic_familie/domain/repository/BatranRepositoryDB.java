package medic_familie.domain.repository;

import medic_familie.Tools.DataExtractorAdult;
import medic_familie.Tools.DataExtractorBatran;
import medic_familie.configuration.ConnectionFactory;
import medic_familie.domain.entity.Batran;

import java.sql.Connection;
import java.util.BitSet;
import java.util.Set;
import java.sql.*;
public class BatranRepositoryDB implements BatranRepository {
    private static final String GET_ALL_USERS = "SELECT * FROM batran";
    private static final String CREATE_NEW_USER = "INSERT INTO batran (nume,prenume,varsta,colesterol,tensiune,asigurat,tip,gradsedentarism,fumator) VALUES (?,?,?,?,?,?,?,?,?)";
    private static BatranRepositoryDB instance = new BatranRepositoryDB();
    public static BatranRepositoryDB getInstance(){
        return instance;
    }

    @Override
    public Set<Batran> getBatrani() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_USERS);
            return DataExtractorBatran.extractBatranSetFrom(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertBatran(Batran batran) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(CREATE_NEW_USER);
            stmt.setString(1, batran.getNume());
            stmt.setString(2, batran.getPrenume());
            stmt.setInt(3, batran.getVarsta());
            stmt.setInt(4, batran.getColesterol());
            stmt.setInt(5, batran.getTensiune());
            stmt.setBoolean(6,batran.isAsigurat());
            stmt.setString(7,batran.getTip());
            stmt.setInt(8,batran.getGradSedentarism() );
            stmt.setBoolean(9, batran.isFumator());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveUpdateBatran(Batran batran) {
        return false;
    }

    @Override
    public boolean deleteBatran(String nume, String prenume) {
        return false;
    }

    @Override
    public void updateBatran(String nume, String prenume, int colesterol, int tensiune) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update batran set colesterol=?, tensiune = ? where nume = ? and prenume = ?");
            statement.setString(3,nume);
            statement.setString(4,prenume);
            statement.setInt(1,colesterol);
            statement.setInt(2,tensiune);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("ERROR: Could not update batran.");
        }
    }
}

