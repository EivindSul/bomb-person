package inf112.grid;

import java.util.Iterator;

public class GridLocationIterator implements Iterator<Location>, Iterable<Location> {
    private int numRows;
    private int numCols;
    private Location current;

    public GridLocationIterator(IGrid<?> grid) {
        this(grid.numRows(), grid.numCols());

    }

    public GridLocationIterator(int numRows, int numCols){
        this.numRows = numRows;
        this.numCols = numCols;
        this.current = new Location(0,0);
    }


    @Override
    public Iterator<Location> iterator() {
        return new GridLocationIterator(numRows,numCols);
    }

    @Override
    public boolean hasNext() {
        return current.row < numRows && current.col < numCols;
    }

    @Override
    public Location next() {
        Location elem = current;
        if(current.col < numCols-1){
            current = current.neighbour(GridDirection.EAST);
        } else {
            current = new Location(current.row+1,0);
        }
        return elem;
    }
}
