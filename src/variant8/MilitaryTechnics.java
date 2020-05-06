package variant8;

public class MilitaryTechnics {

    private int id = -1;
    private String category = "";
    private String name = "";
    private String country = "";
    private int year = 0;
    private double price = 0.0;

    public MilitaryTechnics() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MilitaryTechnics(int id, String category, String name, String country, int year, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.country = country;
        this.year = year;
        this.price = price;
    }
}
