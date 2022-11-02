package utilsLib;

import java.util.concurrent.TimeUnit;

public class Utils {
	public static void waitForSomeTime(int seconds){
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
