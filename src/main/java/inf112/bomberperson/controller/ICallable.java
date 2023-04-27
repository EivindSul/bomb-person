package inf112.bomberperson.controller;

/**
 * Simple interface to facilitate making controller methods into the hashmaps of MyInputProcessor
 */
public interface ICallable<T> {
    
    /**
     * Method that contains the code to be executed when the player wants to move in a certain direction
     */
    public T call();
}
