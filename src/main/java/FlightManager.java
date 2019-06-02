public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public int getReservedBagWeight() {
        return this.flight.getPlane().getPlaneType().getMaximumTakeOffWeight() / 2;
    }

    public int getReservedPassengerBagWeight() {
        //reserved passenger bag weight = half plane maximum take off weight divided by the capacity
        return this.getReservedBagWeight() / this.flight.getPlane().getPlaneType().getCapacity();
    }

    public int getBookedBagWeight() {
        // booked bag weight is the total bags for each booked passenger multiplied by bag weight - assuming 30Kg per bag
        int STANDARDBAGWIEGHT = 30;
        int totalBags = 0;
        for (Passenger passenger : this.flight.getPassengers()) {
            totalBags += passenger.getBags();
        }
        return totalBags * STANDARDBAGWIEGHT;
    }

    public int getRemainingBaggageWeight() {
        return this.getReservedBagWeight() - this.getBookedBagWeight();
    }
}
