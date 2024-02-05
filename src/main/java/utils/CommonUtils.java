package utils;

import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICITLYWAIT = 10;
	public static final int LOADTIME = 15;
	public static final int EXPLICIT_WAIT_BASIC_TIME = 30;
	
	public static String generateEmailAddress() {
		
		Date date = new Date();
		String email = date.toString().replace(" ", "_").replace(":", "_");
		
		return "a0san"+email+"@gmail.com";
	}

}
