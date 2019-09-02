package Driver;

/**
 * <h1>InvalidTripException</h1>
 * The InvalidTripException class extend Exceptions.
 * This class is simply to create a unique error to be thrown for an invalid driver trip
 * <p>
 * i.e.: Discard any trips that average a speed of less than 5 mph or greater than 100 mph.
 *
 * @author Xavier Shelton
 * @version 1.0
 * @since 2019-08-15
 */
public class InvalidTripException extends Exception {
    public InvalidTripException(String s) {
        super(s);
    }
}
