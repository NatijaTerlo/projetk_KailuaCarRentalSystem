import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO Customers (Name, Address, PostalCode, City, MobilePhone, Phone, Email, DriverLicenseNumber, DriverLicenseIssueDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getAddress());
            pstmt.setString(3, customer.getPostalCode());
            pstmt.setString(4, customer.getCity());
            pstmt.setString(5, customer.getMobilePhone());
            pstmt.setString(6, customer.getEmail());
            pstmt.setString(7, customer.getDriverLicenseNumber());
            pstmt.setDate(8, java.sql.Date.valueOf(customer.getDriverLicenseIssueDate()));

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Error adding the customer: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customers";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setPostalCode(Integer.parseInt(rs.getString("postalCode")));
                customer.setCity(rs.getString("city"));
                customer.setMobilePhone(rs.getString("mobilePhone"));
                customer.setEmail(rs.getString("email"));
                customer.setDriverLicenseNumber(rs.getString("driverLicenseNumber"));
                customer.setDriverLicenseIssueDate(String.valueOf(rs.getDate("driverLicenseIssueDate").toLocalDate()));


                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving customers: " + e.getMessage());
            e.printStackTrace();
        }
        return customers;
    }
}
