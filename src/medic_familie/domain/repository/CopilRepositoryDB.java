package medic_familie.domain.repository;

import medic_familie.Tools.DataExtractorCopil;
import medic_familie.configuration.ConnectionFactory;
import medic_familie.domain.entity.Copil;

import java.sql.Connection;
import java.util.BitSet;
import java.util.Set;
import java.sql.*;
public class CopilRepositoryDB implements CopilRepository {
    private static final String GET_ALL_USERS = "SELECT * FROM copil";
    private static final String CREATE_NEW_USER = "INSERT INTO copil (nume,prenume,varsta,colesterol,tensiune,asigurat,tip,persoanebolnavafamilie,nrvaccin,prenumemama,prenumetata,vaccinuri) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    private static CopilRepositoryDB instance = new CopilRepositoryDB();
    public static CopilRepositoryDB getInstance(){
        return instance;
    }
    @Override
    public Set<Copil> getCopii() {
        System.out.println("intru in DB");
        try (Connection connection = ConnectionFactory.getConnection()) {
            System.out.println("reusesc sa ma connectez la baza de date");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_USERS);
            return DataExtractorCopil.extractCopilSetFrom(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertCopil(Copil copil) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(CREATE_NEW_USER);
            stmt.setString(1, copil.getNume());
            stmt.setString(2, copil.getPrenume());
            stmt.setInt(3, copil.getVarsta());
            stmt.setInt(4, copil.getColesterol());
            stmt.setInt(5, copil.getTensiune());
            stmt.setBoolean(6,copil.isAsigurat());
            stmt.setString(7,copil.getTip());
            stmt.setInt(8,copil.getPersoaneBolnaveFamilie());
            stmt.setInt(9, copil.getNrVaccin());
            stmt.setString(10,copil.getPrenumeMama());
            stmt.setString(11,copil.getPrenumeTata());
            stmt.setString(12,copil.getVaccinuri());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveUpdateCopil(Copil copil) {
        return false;
    }

    @Override
    public boolean deleteCopil(String nume, String prenume) {
        return false;
    }

    @Override
    public void updateCopil(String nume, String prenume, int colesterol, int tensiune) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update copil set colesterol=?, tensiune = ? where nume = ? and prenume = ?");
            statement.setString(3,nume);
            statement.setString(4,prenume);
            statement.setInt(1,colesterol);
            statement.setInt(2,tensiune);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("ERROR: Could not update copil.");
        }
    }
}


