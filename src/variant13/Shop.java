package variant13;

public class Shop {

    private int id = -1;
    private String category = "";
    private String name = "";
    private String address = "";
    private int retailSpace = 0;
    private double capital = 0.0;

    public Shop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRetailSpace() {
        return retailSpace;
    }

    public void setRetailSpace(int retailSpace) {
        this.retailSpace = retailSpace;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public Shop(int id, String category, String name, String country, int year, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.address = country;
        this.retailSpace = year;
        this.capital = price;
    }
}
