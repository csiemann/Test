
/*
 * Data: 21 de out de 2019
 * @author Caetano Siemann
 *
 */
public class Utils {

	public Utils() {}
	
	public static void pause(int ms) {
	    try {
	        Thread.sleep(ms);
	    } catch (InterruptedException e) {
	        System.err.format("IOException: %s%n", e);
	    }
	}
}
