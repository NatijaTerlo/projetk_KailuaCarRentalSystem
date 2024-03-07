public class Customer {
    private int id;
    private String name;
    private String address;
    private int postalCode;
    private String city;
    private String mobilePhone;
    private String email;
    private String driverLicenseNumber;
    private String driverLicenseIssueDate;


    public Customer(String name, String address, int postalCode, String city, String mobilePhone, String email, String driverLicenseNumber, String driverLicenseIssueDate) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.driverLicenseNumber = driverLicenseNumber;
        this.driverLicenseIssueDate = driverLicenseIssueDate;
    }



    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDriverLicenseIssueDate() {
        return driverLicenseIssueDate;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getPostalCode() {
        return String.valueOf(postalCode);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDriverLicenseIssueDate(String driverLicenseIssueDate) {
        this.driverLicenseIssueDate = driverLicenseIssueDate;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public Customer(){

    }
}


