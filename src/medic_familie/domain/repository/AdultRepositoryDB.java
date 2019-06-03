package medic_familie.domain.repository;

import medic_familie.Tools.DataExtractorAdult;
import medic_familie.configuration.ConnectionFactory;
import medic_familie.domain.entity.Adult;

import java.sql.*;
import java.util.Set;
public class AdultRepositoryDB implements AdultRepository {
    private static final String GET_ALL_USERS = "SELECT * FROM adult";
    private static final String CREATE_NEW_USER = "INSERT INTO adult (nume,prenume,varsta,colesterol,tensiune,asigurat,tip,fumator,locmunca) VALUES (?,?,?,?,?,?,?,?,?)";
    private static AdultRepositoryDB instance = new AdultRepositoryDB();
    public static AdultRepositoryDB getInstance(){
        return instance;
    }

    @Override
    public Set<Adult> getAdulti() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_USERS);
            return DataExtractorAdult.extractAdultSetFrom(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertAdult(Adult adult) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(CREATE_NEW_USER);
            stmt.setString(1, adult.getNume());
            stmt.setString(2, adult.getPrenume());
            stmt.setInt(3, adult.getVarsta());
            stmt.setInt(4, adult.getColesterol());
            stmt.setInt(5, adult.getTensiune());
            stmt.setBoolean(6,adult.isAsigurat());
            stmt.setString(7,adult.getTip());
            stmt.setBoolean(8, adult.isFumator());
            stmt.setString(9,adult.getLoc_de_munca());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveUpdateAdult(Adult adult) {
        return false;
    }

    @Override
    public boolean deleteAdult(String nume, String prenume) {
        return false;
    }

    @Override
    public void updateAdult(String nume, String prenume, int colesterol, int tensiune) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update adult set colesterol=?, tensiune = ? where nume = ? and prenume = ?");
            statement.setString(3,nume);
            statement.setString(4,prenume);
            statement.setInt(1,colesterol);
            statement.setInt(2,tensiune);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("ERROR: Could not update adult.");
        }
    }
    }

