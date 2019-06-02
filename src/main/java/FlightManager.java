import java.beans.PersistenceDelegate;
import java.util.ArrayList;

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

    public void bubbleSortPassengers() {
        ArrayList<Passenger> passengers = this.getFlight().getPassengers();
        for (int outerIndex = 0; outerIndex < passengers.size(); outerIndex++) {
            for (int innerIndex = 0; innerIndex < passengers.size() - outerIndex - 1; innerIndex++) {
                if (passengers.get(innerIndex).getSeatNumber() > passengers.get(innerIndex + 1).getSeatNumber() ) {
                    Passenger temp = passengers.get(innerIndex);
                    passengers.set(innerIndex, passengers.get(innerIndex + 1));
                    passengers.set(innerIndex + 1, temp);
                    }
                }
            }
        }

    public int getLowestBookedSeatNumber() {
        int lowestBookedSeatNumber = this.flight.getPlane().getPlaneType().getCapacity();
        for (Passenger passenger : this.getFlight().getPassengers()) {
            if (passenger.getSeatNumber() < lowestBookedSeatNumber) {
                lowestBookedSeatNumber = passenger.getSeatNumber();
            }
        }
        return lowestBookedSeatNumber;
    }

    public int getHighestBookedSeatNumber() {
        int highestBookedSeatNumber = 0;
        for (Passenger passenger : this.getFlight().getPassengers()) {
            if (passenger.getSeatNumber() > highestBookedSeatNumber) {
                highestBookedSeatNumber = passenger.getSeatNumber();
            }
        }
        return highestBookedSeatNumber;
    }

    public Passenger binarySeatSearch(ArrayList<Passenger> array, int seatNumber){
        if (array.size() == 0){
            return null;
        }

        int midIndex = 0;
        if (array.size() > 1) {
            midIndex = array.size() / 2;
        }

        int midPointSeatNumber = array.get(midIndex).getSeatNumber();

        if (seatNumber == midPointSeatNumber){
            return array.get(midIndex);
        }

        ArrayList<Passenger> newSearchArea;

        if (seatNumber < midPointSeatNumber){
            newSearchArea = new ArrayList<Passenger>(array.subList(0, midIndex));
        } else {
            newSearchArea = new ArrayList<Passenger>(array.subList(midIndex + 1, array.size()));
        }
        return binarySeatSearch(newSearchArea, seatNumber);
    }
}
