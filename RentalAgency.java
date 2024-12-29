import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> vehicleFleet = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicleFleet.add(vehicle);
    }

    public void processRental(Customer customer, Vehicle vehicle, int days) {
        if (vehicle instanceof Rentable) {
            ((Rentable) vehicle).rent(customer, days);
        }
    }

    public void returnVehicle(Vehicle vehicle) {
        if (vehicle instanceof Rentable) {
            ((Rentable) vehicle).returnVehicle();
        }
    }
}

