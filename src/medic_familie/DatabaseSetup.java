package medic_familie;
import medic_familie.configuration.ConnectionFactory;
import java.sql.*;
public class DatabaseSetup {
    private static DatabaseSetup instance = new DatabaseSetup();
    public static DatabaseSetup getInstance(){
        return instance;
    }
    public static void initDatabase() {
        System.out.println("aaaaaaaaaaaaaaaaaa");
        String Query;
        try(Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            Query = "DROP TABLE adult IF EXISTS";
            stmt.executeUpdate(Query);
            Query = "CREATE TABLE adult (" +
                    "nume varchar2(200)," +
                    "prenume varchar2(200)," +
                    "varsta number(3)," +
                    "colesterol number(4)," +
                    "tensiune number(4)," +
                    "asigurat boolean," +
                    "tip varchar2(20)," +
                    "fumator boolean," +
                    "locMunca varchar(30))";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO adult VALUES('Meianu','Aurelia',48,180,12,true,'adult',false,'educator')";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO adult VALUES('Meianu','Gheorghe',49,170,12,true,'adult',false,'tamplar')";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO adult VALUES('Smaranda','Lili',30,140,12,false,'adult',true,'barman')";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO adult VALUES('Smaranda','Claudiu',38,180,12,false,'adult',true,'tirist')";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO adult VALUES('Gavrila','Mona',34,190,11,true,'adult',false,'vanzator')";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO adult VALUES('Gavrila','Nelu',40,200,12,true,'adult',true,'vanzator')";
            stmt.executeUpdate(Query);


            Query = "DROP TABLE copil IF EXISTS";
            stmt.executeUpdate(Query);
            Query = "CREATE TABLE copil (" +
                    "nume varchar2(200)," +
                    "prenume varchar2(200)," +
                    "varsta number(3)," +
                    "colesterol number(4)," +
                    "tensiune number(4)," +
                    "asigurat boolean," +
                    "tip varchar2(20)," +
                    "persoaneBolnavaFamilie number(2)," +
                    "nrVaccin number(2)," +
                    "prenumeMama varchar2(300)," +
                    "prenumeTata varchar2(300)," +
                    "vaccinuri varchar2(300))";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO copil VALUES('Meianu','Teodora',11,200,13,true,'copil',0,2,'Aurelia','Gheorghe','antitetanic antituberculoza')";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO copil VALUES('Smaranda','Andrei',19,170,12,false,'copil',0,1,'Lili','Claudiu','antituberculoza')";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO copil VALUES('Gavrila','Andrada',19,180,11,true,'copil',2,3,'Mona','Nelu','antitetanic')";
            stmt.executeUpdate(Query);


            Query = "DROP TABLE batran IF EXISTS";
            stmt.executeUpdate(Query);
            Query = "CREATE TABLE batran (" +
                    "nume varchar2(200)," +
                    "prenume varchar2(200)," +
                    "varsta number(3)," +
                    "colesterol number(4)," +
                    "tensiune number(4)," +
                    "asigurat boolean," +
                    "tip varchar2(20)," +
                    "gradSedendarism number(2)," +
                    "fumator boolean)";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO batran VALUES('Barbulescu','Elena',70,190,13,true,'batran',2,false)";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO batran VALUES('Budascu','Alexandra',80,190,12,false,'batran',3,true)";
            stmt.executeUpdate(Query);
            Query = "INSERT INTO batran VALUES('Aledea','Sorina',90,180,11,true,'batran',2,true)";
            stmt.executeUpdate(Query);

        }
        catch(SQLException e) {
            System.out.println("Eroare la conectarea cu BD!" + e);
        }
    }
}

