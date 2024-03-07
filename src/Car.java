public class Car {
    private String mærke;
    private String model;
    private String brændstoftype;
    private String registreringsnummer;
    private String førsteRegistrering;
    private int kilometertæller;
    private String kategori;

    public Car(String mærke, String model, String brændstoftype, String registreringsnummer, String førsteRegistrering, int kilometertæller, String kategori) {
        this.mærke = mærke;
        this.model = model;
        this.brændstoftype = brændstoftype;
        this.registreringsnummer = registreringsnummer;
        this.førsteRegistrering = førsteRegistrering;
        this.kilometertæller = kilometertæller;
        this.kategori = kategori;
    }

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrændstoftype() {
        return brændstoftype;
    }

    public void setBrændstoftype(String brændstoftype) {
        this.brændstoftype = brændstoftype;
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public String getFørsteRegistrering() {
        return førsteRegistrering;
    }

    public void setFørsteRegistrering(String førsteRegistrering) {
        this.førsteRegistrering = førsteRegistrering;
    }

    public int getKilometertæller() {
        return kilometertæller;
    }

    public void setKilometertæller(int kilometertæller) {
        this.kilometertæller = kilometertæller;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mærke='" + mærke + '\'' +
                ", model='" + model + '\'' +
                ", brændstoftype='" + brændstoftype + '\'' +
                ", registreringsnummer='" + registreringsnummer + '\'' +
                ", førsteRegistrering='" + førsteRegistrering + '\'' +
                ", kilometertæller=" + kilometertæller +
                ", kategori='" + kategori + '\'' +
                '}';
    }
}
