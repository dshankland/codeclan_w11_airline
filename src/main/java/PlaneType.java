public enum PlaneType {
    AIRBUSA380(555, 277000),
    BOEING777(301, 134800),
    CONCORDE(128, 92080);

    private final int capacity;   // in people
    private final int operatingWeight; // in kilograms

    PlaneType(int capacity, int operatingWeight) {
        this.capacity = capacity;
        this.operatingWeight = operatingWeight;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getOperatingWeight() {
        return this.operatingWeight;
    }
}
