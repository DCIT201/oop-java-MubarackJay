public class Truck extends Vehicle {
    private int payloadCapacity; // in tons

    public Truck(String vehicleId, String model, double baseRentalRate, int payloadCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Apply a 50% surcharge for high payload capacity trucks
        if (payloadCapacity > 5) {
            return days * getBaseRentalRate() * 1.5;
        } else {
            return days * getBaseRentalRate();
        }
    }

    @Override
    public boolean isAvailableForRental() {
        // Example of a rule: Trucks with large payloads require special permits
        if (payloadCapacity > 10) {
            return isAvailable() && hasRequiredPermits();
        } else {
            return isAvailable();
        }
    }

    private boolean hasRequiredPermits() {
        // Simulating permit check logic
        return true; // Assume the required permits are available
    }

    // Getters and setters
    public int getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(int payloadCapacity) {
        if (payloadCapacity <= 0) {
            throw new IllegalArgumentException("Payload capacity must be greater than 0.");
        }
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "payloadCapacity=" + payloadCapacity +
                ", vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                '}';
    }
}
