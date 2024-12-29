public class Car extends Vehicle implements Rentable {
    private int numberOfDoors;

    public Car(String vehicleId, String model, double baseRentalRate, int numberOfDoors) {
        super(vehicleId, model, baseRentalRate);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getBaseRentalRate();
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            System.out.println("Car rented by " + customer.getName() + " for " + days + " days.");
        } else {
            System.out.println("Car is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car returned.");
    }
}

