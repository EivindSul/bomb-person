package inf112.grid;
import java.util.Arrays;
import  java.util.List;
import java.util.WeakHashMap;

public enum GridDirection {
    EAST(1, 0),
    NORTH(0, -1),
    WEST(-1, 0),
    SOUTH(0,1),
    CENTER(0, 0);

    /**
     * The four main directions: {@link #NORTH}
     */
    public static final List<GridDirection> DIRECTIONS = Arrays.asList(EAST, NORTH, WEST, SOUTH);


    private final int dx;
    private final int dy;

    GridDirection(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }
    public Location getNeighbour(Location loc){
        return new Location(loc.row + dy, loc.col +dx);
    }


}
