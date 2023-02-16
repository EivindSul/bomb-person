package inf112.grid;

import java.util.Objects;

public class Location {
    public final int row;
    public final int col;

    public Location(int row, int col){
        this.row = row;
        this.col =col;

    }

    public Location neighbour(GridDirection direction){
        return direction.getNeighbour(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return row == location.row && col == location.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "Location{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
    public int gridDistanceTo(Location loc){
        return Math.abs(row- loc.row )  + Math.abs(col - loc.col);
    }

}
