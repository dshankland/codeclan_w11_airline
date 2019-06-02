public enum PlaneType {
    AIRBUSA380(555, 544310),
    BOEING777(301, 299370),
    CONCORDE(128, 185000);

    private final int capacity;   // in people
    private final int maximumTakeOffWeight; // in kilograms

    PlaneType(int capacity, int maximumTakeOffWeight) {
        this.capacity = capacity;
        this.maximumTakeOffWeight = maximumTakeOffWeight;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getMaximumTakeOffWeight() {
        return this.maximumTakeOffWeight;
    }
}
