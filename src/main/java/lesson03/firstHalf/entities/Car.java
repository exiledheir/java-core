package lesson03.firstHalf.entities;

public class Car {
    private final String country;
    private final String model;
    private final int yearOfManufacture;

    public Car(String country, String model, int yearOfManufacture) {
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Enter valid country");
        }
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Enter valid model");
        }
        this.country = country;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    public void printCarInfo() {
        System.out.println("Car{" + "country='" + country + '\'' + ", model='" + model + '\'' + ", yearOfManufacture=" + yearOfManufacture + '}');
    }
}
