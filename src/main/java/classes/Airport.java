package classes;

public class Airport {
    String year;
    String make;
    String model;
    String description;
    String price;

    public Airport(String year, String make, String model, String description, String price){
        this.year = year;
        this.make =make;
        this.model = model;
        this.description = description;
        this.price = price;
    }
    public void print(){
        System.out.printf("%8s %10s %20s %40s %10s \n",
                this.year, this.make, this.model, this.description, this.price);
    }
    public String getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}
