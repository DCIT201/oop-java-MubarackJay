public class Motorcycle extends Vehicle {
    private int engineCapacity; // in cc (cubic centimeters)

    public Motorcycle(String vehicleId, String model, double baseRentalRate, int engineCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Apply a 20% surcharge for high engine capacity motorcycles
        if (engineCapacity > 650) {
            return days * getBaseRentalRate() * 1.2;
        } else {
            return days * getBaseRentalRate();
        }
    }

    @Override
    public boolean isAvailableForRental() {
        // Example of a rule: High engine capacity requires a special license
        if (engineCapacity > 1000) {
            return isAvailable() && hasRequiredLicense();
        } else {
            return isAvailable();
        }
    }

    private boolean hasRequiredLicense() {
        // Simulating license check logic
        return true; // Assume the customer has the required license
    }

    // Getters and setters
    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        if (engineCapacity <= 0) {
            throw new IllegalArgumentException("Engine capacity must be greater than 0.");
        }
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "engineCapacity=" + engineCapacity +
                ", vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                '}';
    }
}

