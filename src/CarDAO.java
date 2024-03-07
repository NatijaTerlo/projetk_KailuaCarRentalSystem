import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CarDAO {
    public boolean addCar(Car car) {
        String sql = "INSERT INTO Cars (Maerke, Model, Braendstoftype, Registreringsnummer, FoersteRegistrering, Kilometertaeller, Kategori) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, car.getMærke());
            pstmt.setString(2, car.getModel());
            pstmt.setString(3, car.getBrændstoftype());
            pstmt.setString(4, car.getRegistreringsnummer());
            pstmt.setString(5, car.getFørsteRegistrering());
            pstmt.setInt(6, car.getKilometertæller());
            pstmt.setString(7, car.getKategori());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Error adding the car: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM Cars";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Car car = new Car(
                        rs.getString("Ford"),
                        rs.getString("Sidste model"),
                        rs.getString("Hybrid"),
                        rs.getString("123456"),
                        rs.getString("00000"),
                        rs.getInt("78695"),
                        rs.getString("Fokus")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving all cars: " + e.getMessage());
            e.printStackTrace();
        }

        return cars;
    }
}


