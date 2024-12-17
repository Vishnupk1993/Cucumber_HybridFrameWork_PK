package utils;

import java.util.Date;

public class commonUtils {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=15;
	public static final int EXPLICIT_WAIT_TIME=15;
	
	public static String getEmailwithTimestamp()
	{
		Date date = new Date();
		return "vishnu.menon"+date.toString().replace(" ", "_").replace(":","_" )+"@gmail.com";
	}

}
