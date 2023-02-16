package inf112.grid;

import inf112.grid.GridDirection;
import inf112.grid.Location;

import java.util.function.Function;

/**
 * This interface
 * @param <T>
 */
public interface IGrid<T> extends Iterable<T>{
    /**
     *
     * @return The height of the grid
     */
    int numRows();
    /**
     * @return The width of the grid
     */

    int numCols();

    /**
     * @return rows
     */
    T getLocation(Location loc);




    void set(Location pos, T element);

    /**
     * @
     * @param initialiser
     */
    void fill(Function<Location, T> initialiser);
    void fill (T element);
    IGrid<T> copy();

    boolean isOnGrid(Location pos);
    Iterable<Location> locations();
    boolean canGo(Location from, GridDirection dir);

}