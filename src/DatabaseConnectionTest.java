import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            if (connection != null) {
                System.out.println("Forbindelse til databasen blev etableret succesfuldt.");

                connection.close();
            } else {
                System.out.println("Forbindelse til databasen mislykkedes.");
            }
        } catch (SQLException e) {
            System.out.println("Databaseforbindelsesfejl: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
