package inf112.grid;

public class TwoLocations {
    private final Location from;
    private final Location to;

    public TwoLocations(Location from, Location to) {
        this.from = from;
        this.to = to;
    }

    public Location getFrom() {
        return this.from;
    }

    public Location getTo() {
        return this.to;
    }
}
