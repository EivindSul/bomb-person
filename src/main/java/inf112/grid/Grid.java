package inf112.grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Grid<T> implements IGrid<T>{
    private final List<T> cells;
    private final int cols;
    private final int rows;

    public Grid(int width, int height, Function<Location, T> initializer) {
        this(width , height);
        fill(initializer);
    }

    public Grid(int width, int height, T elem){
        this(width, height);
        fill(elem);
    }

    public Grid(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>(rows * cols);
        for (int i = 0; i < rows * cols; i++) {
            cells.add(null);
        }
    }

    @Override
    public int numRows() {
        return this.rows;
    }

    @Override
    public int numCols() {
        return this.cols;
    }

    @Override
    public T getLocation(Location loc) {
        checkLocation(loc);
        return cells.get(locationToIndex(loc));
    }

    @Override
    public void set(Location pos, T element) {
        checkLocation(pos);
        cells.set(locationToIndex(pos), element);
    }

    private int locationToIndex(Location pos){
        return pos.col + pos.row * cols;
    }

    public  void checkLocation(Location loc){
        if(!isOnGrid(loc)){
            throw new IndexOutOfBoundsException("Not within Bound");
        }
    }

    @Override
    public void fill(Function<Location, T> initialiser) {
        if(initialiser == null){
            throw new NullPointerException("Not null");
        }
        for (Location loc : locations()
             ) {
            set(loc,initialiser.apply(loc));
        }
    }

    @Override
    public void fill(T element) {
        Collections.fill(cells,element);
    }

    @Override
    public IGrid<T> copy() {
        Grid<T> newGrid = new Grid<>(numRows(),numCols());
        fillCopy(newGrid);
        return newGrid;
    }

    public void fillCopy(Grid<T> newGrid){
        for (Location loc: locations()) {
            newGrid.set(loc, this.getLocation(loc));
        }
    }

    @Override
    public boolean isOnGrid(Location pos) {
        if(pos == null){
            return false;
        }
        if(pos.row < 0 ||  pos.row >= rows){
            return false;
        }
        return pos.col >= 0 && pos.col < cols;
}

    @Override
    public GridLocationIterator locations() {
        return new GridLocationIterator(numRows(),numCols());
    }

    @Override
    public boolean canGo(Location from, GridDirection dir) {

        return isOnGrid(from.neighbour(dir));
    }

    @Override
    public Iterator<T> iterator() {
        return cells.iterator();
    }

    public boolean contains(Object obj){
        return cells.contains(obj);
    }

    public Location locationOf(Object obj){
        for (Location loc: locations()
             ) {
            if (getLocation(loc).equals(obj))
            return loc;
        }
        throw new IllegalArgumentException("cannot find argument");
    }
    public void clear(){
        Collections.fill(cells,null);
    }



}
