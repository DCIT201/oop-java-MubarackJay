public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        Vehicle car = new Car("C001", "Toyota Corolla", 50.0, 4);
        Customer customer = new Customer("U001", "Mubarack Jay", "mubarackjay@example.com");

        agency.addVehicle(car);
        agency.processRental(customer, car, 3);
        agency.returnVehicle(car);
    }
}

