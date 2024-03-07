import java.util.Scanner;
import java.sql.Connection;


public class CarRentalApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Forbundet til databasen succesfuld!");
            connection.close();
        }catch (Exception e) {
            System.out.println("Kunne ikke oprette forbindelse til databasen.");
            e.printStackTrace();
        }


        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewCar(scanner);
                    System.out.println("New is car added!");
                    break;
                case 2:
                    showAllCars();
                    System.out.println("All new cars");
                    break;
                case 3:
                    addNewCustomer(scanner);
                    System.out.println("New customer is added");
                    break;
                case 4:
                    showAllCustomers();
                    System.out.println("All customers in this system");
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

   private static void printMenu() {
        System.out.println("\n=== Car Rental Menu ===");
        System.out.println("1. Add new car");
        System.out.println("2. Show all cars");
        System.out.println("3. Add new customer");
        System.out.println("4. Show all customers");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }



    private static void showAllCars() {
        System.out.println("\n=== All Cars ===");
        for (Car car : carDAO.getAllCars()) {
            System.out.println(car);
        }
    }

    private static void addNewCustomer(Scanner scanner) {
        System.out.println("Enter customer details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Postal code: ");
        int postalCode = scanner.nextInt();
        scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("Mobile phone: ");
        String mobilePhone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Driver's license number: ");
        String licenseNumber = scanner.nextLine();
        System.out.print("Driver's license issue date: ");
        String issueDate = scanner.nextLine();

        customerDAO.addCustomer(new Customer(name, address, postalCode, city, mobilePhone, email, licenseNumber, issueDate));
        System.out.println("Customer added successfully!");
    }

    private static void showAllCustomers() {
        System.out.println("\n=== All Customers ===");
        for (Customer customer : customerDAO.getAllCustomers()) {
            System.out.println(customer);
        }
    }
    private static void addNewCar(Scanner scanner) {
        System.out.println("Enter car details:");

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Fuel type: ");
        String fuelType = scanner.nextLine();

        System.out.print("Registration number: ");
        String regNumber = scanner.nextLine();

        System.out.print("First registration date (YYYY-MM-DD): ");
        String regDate = scanner.nextLine();

        System.out.print("Mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        Car newCar = new Car(make, model, fuelType, regNumber, regDate, mileage, category);

        boolean success = carDAO.addCar(newCar);
        if (success) {
            System.out.println("Car added successfully!");
        } else {
            System.out.println("Failed to add the car. Please check the details and try again.");
        }
    }
    private static CarDAO carDAO = new CarDAO();
    private static CustomerDAO customerDAO = new CustomerDAO();

}


