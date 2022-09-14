package lu.bnl.browsertrix.client.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class TimeUtils 
{
	/**
	 * Browsertrix uses timestamps of the form:
	 * 		yyyy-MM-dd'T'HH:mm:ss
	 * 
	 * This method converts that into seconds since Epoch.
	 */
	public static long timestampToSecondsSinceEpoch(String timestamp) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Instant instant = sdf.parse(timestamp).toInstant();
		
		return instant.getEpochSecond();
	}
}
